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

import javax.xml.crypto.Data;
import java.io.IOException;
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
        /*
        Gervigögntil að testa image upload

         */
        Location testloc = locationService.save(new Location(0.999,1.444,"prufa"));
        System.out.println(testloc.getLatitude());
        User testUser = userService.save(new User("þorri", "Már", "ths34", "passw"));
        System.out.println(userService.findAllUsers());

        String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        image.setImageTitle(filename);
        image.setDescription("prufa");
        image.setOwner(testUser);
        image.setReleaseDate(new Date());
        image.setImagelocation(testloc);

        System.out.println(
                image.getImageTitle() + " " +
                image.getDescription() + " " +
                image.getImagelocation().getLongitude() + " " +
                image.getImagelocation().getLatitude() + " " +
                image.getImagelocation().getLocationName() + " " +
                image.getReleaseDate() + " " +
                image.getOwner().getFirstName()
        );

        Image savedImaged = imageService.save(image);
        String uploadDir = "user-photos/" + savedImaged.getId();
        return "uploadFile";
    }


    @RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
    public String uploadFileGET(Image image) {

        return "uploadFile";
    }

}
