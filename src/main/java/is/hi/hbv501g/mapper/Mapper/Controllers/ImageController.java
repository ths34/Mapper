package is.hi.hbv501g.mapper.Mapper.Controllers;


import is.hi.hbv501g.mapper.Mapper.Entities.Image;
import is.hi.hbv501g.mapper.Mapper.Entities.Location;
import is.hi.hbv501g.mapper.Mapper.Entities.User;
import is.hi.hbv501g.mapper.Mapper.Services.ImageService;
import is.hi.hbv501g.mapper.Mapper.Services.LocationService;
import is.hi.hbv501g.mapper.Mapper.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.InputStream;
import java.nio.file.*;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;

@Controller
public class ImageController {
    @Autowired
    private UserService userService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private LocationService locationService;

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String uploadFilePOST(@ModelAttribute(name = "image") Image image, RedirectAttributes ra, @RequestParam("fileimage") MultipartFile multipartFile)
            throws IOException {
        String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename());

        /*
      Athugar hvort vanti upplýsingar af upload form.
       */

        if(image.getImageTitle().isEmpty() || image.getDescription().isEmpty()) {
            System.out.println("Vantar í form");
            return "uploadFile";
        }

        if (filename.isEmpty())
        {
            System.out.println("vantar file");
            return "uploadFile";
        }
        /*
        Gervigögntil að testa image upload.
        todo þarf að geta tekið inn user af uploadform og location.

         */
        Location testloc = locationService.save(new Location(0.999,1.444,"prufa"));
        User testUser = userService.save(new User("þorri", "Már", "ths34", "passw"));

        /*
        Setur alla attributes á image object

         */
        image.setImageTitle(image.getImageTitle());
        image.setDescription(image.getDescription());
        image.setOwner(testUser); //todo tengja við html
        image.setImagelocation(testloc); // //todo tengja við html


        /*
        Vistar mynd í gagnagrunni og á harðadisk á kerfi. Lendir undir user-photos í verkefnamöppu. Býr til möppu
        eftir userID og undirmöppu eftir imageID.

         */
        Image savedImaged = imageService.save(image);
        String uploadDir = "./user-photos/" + image.getOwner().getId() + "/"+ savedImaged.getId();
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(filename);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + image.getImageTitle(), ioe);
        }


        return "uploadFile";
    }



    @RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
    public String uploadFileGET(Image image) {

        return "uploadFile";
    }

}
