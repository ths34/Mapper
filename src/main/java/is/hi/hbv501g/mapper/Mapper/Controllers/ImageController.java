package is.hi.hbv501g.mapper.Mapper.Controllers;


import is.hi.hbv501g.mapper.Mapper.Entities.Image;
import is.hi.hbv501g.mapper.Mapper.Entities.Location;
import is.hi.hbv501g.mapper.Mapper.Entities.Upload;
import is.hi.hbv501g.mapper.Mapper.Entities.User;
import is.hi.hbv501g.mapper.Mapper.Services.ImageService;
import is.hi.hbv501g.mapper.Mapper.Services.LocationService;
import is.hi.hbv501g.mapper.Mapper.Services.UserService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.*;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;
import java.util.Optional;

@Controller
public class ImageController {
    @Autowired
    private UserService userService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private LocationService locationService;

    @RequestMapping(value = "/Image/{id}", method = RequestMethod.GET)
    public void getImageAsByteArray(@PathVariable("id") String path,HttpServletResponse response) throws IOException {
        FileInputStream in = new FileInputStream("./posts/"+path);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(in, response.getOutputStream());
    }
    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public String imgView(@PathVariable("id") long id, Model model) {
        imageService.findById(id).ifPresent(image ->model.addAttribute("image",image));
        return "post";
    }
    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public String viewAll(Model model) {
        model.addAttribute("posts", imageService.findAll());
        model.addAttribute("locations", locationService.findAll());
        return "posts";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String uploadFilePOST(@ModelAttribute(name = "image") Upload upload, RedirectAttributes ra, @RequestParam("fileimage") MultipartFile multipartFile)
            throws IOException {

        String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename());
          /*
            Athugar ef user er til í db
        */
        if (userService.findByUserName(upload.getUserName()) == null ) {
            System.out.println("User ekki í db");
            return "Home";
        }
        /*
        Athugar hvort lágmarks upplýsingar vanti af upload form.
        */
        if(upload.imageTitle.isEmpty() || upload.description.isEmpty()) {
            System.out.println("Vantar í form");
            return "Home";
        }
        if (upload.LocationName.isEmpty()) {
            if (upload.Latitude.isEmpty() || upload.Longitude.isEmpty()) {
                System.out.println("Vantar staðsetningarupplýsingar");
                return "Home";
            }
        }

        User user = userService.findByUserName(upload.getUserName());
        Location testloc = locationService.save(new Location(Double.parseDouble(upload.getLongitude()),Double.parseDouble(upload.getLatitude()),(upload.getLocationName())));
        Image image = new Image(testloc, upload.getImageTitle(),upload.getDescription(), user);


        if (filename.isEmpty()) {
            System.out.println("vantar file");
            return "Home";
        }
        /*
        Vistar mynd í gagnagrunni og á harðadisk á kerfi. Lendir undir user-photos í verkefnamöppu. Býr til möppu
        eftir userID og undirmöppu eftir imageID.
        */

        Image savedImaged = imageService.save(image);
        String uploadDir = "./posts/";
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(savedImaged.getId()+".jpg");
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + image.getImageTitle(), ioe);
        }

        return "Home";
    }


    @RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
    public String uploadFileGET(Upload upload) {

        return "uploadFile";
    }

}
