package is.hi.hbv501g.mapper.Mapper;

import is.hi.hbv501g.mapper.Mapper.Entities.User;
import is.hi.hbv501g.mapper.Mapper.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;


@Controller
public class HomeController {

    private UserService userService;
    @Autowired
    public HomeController(UserService userService) {this.userService = userService;}


    @RequestMapping("/")
    public String Home(Model model) {
        model.addAttribute("Users", userService.findAllUsers());
        return "Home";
    }

    @RequestMapping(value = "/createnewuser", method = RequestMethod.POST)
    public String createNewUser(@Validated User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "Home";
        }
        userService.save(user);
        model.addAttribute("User",userService.findAllUsers());
        return "Home";
    }
    @RequestMapping(value = "/createnewuser", method = RequestMethod.GET)
    public String addNewUserForm(Model model) {
        return "login";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userService.findById(id).orElseThrow(() -> new IllegalArgumentException("No such user"));
        userService.delete(user);
        model.addAttribute("User",userService.findAllUsers());
        return "Home";
    }
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginGET(User user){
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String loginPOST(@Validated User user, BindingResult result, Model model, HttpSession session){
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
