package is.hi.hbv501g.mapper.Mapper.Controllers;

import is.hi.hbv501g.mapper.Mapper.Entities.Image;
import is.hi.hbv501g.mapper.Mapper.Entities.Location;
import is.hi.hbv501g.mapper.Mapper.Entities.User;
import is.hi.hbv501g.mapper.Mapper.Services.ImageService;
import is.hi.hbv501g.mapper.Mapper.Services.LocationService;
import is.hi.hbv501g.mapper.Mapper.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
public class HomeController {
    @Autowired
    private UserService userService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private LocationService locationService;


    @RequestMapping("/")
    public String Home(Model model) {
        model.addAttribute("Users", userService.findAll());
        return "Home";
    }



    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String createNewUser(@ModelAttribute(name = "user") User user, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "Home";
        }
        userService.save(user);
        return "Home";
    }
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String addNewUserForm(User user) {
        return "register";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userService.findById(id).orElseThrow(() -> new IllegalArgumentException("No such user"));
        userService.delete(user);
        model.addAttribute("User",userService.findAll());
        return "Home";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGET(User user){

        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPOST(@ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session){
        if(result.hasErrors()){
            return "login";
        }
        User exists = userService.login(user);
        if(exists != null){
            
            session.setAttribute("LoggedInUser", user);
            return "redirect:/";
        }
        return "redirect:/";
    }
}
