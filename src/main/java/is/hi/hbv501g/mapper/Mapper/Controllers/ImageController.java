package is.hi.hbv501g.mapper.Mapper.Controllers;


import is.hi.hbv501g.mapper.Mapper.Entities.Image;
import is.hi.hbv501g.mapper.Mapper.Services.ImageService;
import is.hi.hbv501g.mapper.Mapper.Services.LocationService;
import is.hi.hbv501g.mapper.Mapper.Services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
public class ImageController {
    private UserService userService;
    private ImageService imageService;
    private LocationService locationService;


    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String uploadFilePOST(@ModelAttribute(name = "image") Image image, RedirectAttributes ra, @RequestParam("fileimage") MultipartFile multipartFile)
            throws IOException {
        String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        image.setImageTitle(filename);
        System.out.println(image.getImageTitle());

        /*Image savedImaged = imageService.save(image);
        String uploadDir = "user-photos/" + savedImaged.getId();
        if (uploadDir != null) {
            System.out.println(uploadDir);

        }*/



        return "uploadFile";
    }


    @RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
    public String uploadFileGET(Image image) {

        return "uploadFile";
    }
}
