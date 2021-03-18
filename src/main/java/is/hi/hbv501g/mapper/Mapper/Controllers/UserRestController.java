package is.hi.hbv501g.mapper.Mapper.Controllers;

import is.hi.hbv501g.mapper.Mapper.Entities.User;
import is.hi.hbv501g.mapper.Mapper.Services.ImageService;
import is.hi.hbv501g.mapper.Mapper.Services.LocationService;
import is.hi.hbv501g.mapper.Mapper.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
public class UserRestController {
    @Autowired
    private UserService userService;
    @Autowired
    private ImageService imageService;
    @Autowired
    private LocationService locationService;

    @RequestMapping("/loguser/{username}/{password}")
    public Object logInUser(@PathVariable(value = "username") String username, @PathVariable(value = "password") String password) {
        User tempuser = new User(null, null, username, password);
        User loggedInUser = userService.login(tempuser);

        if (loggedInUser == null) {
            return tempuser;
        } else {

            return "/error";
        }
    }

    /*
    * Ath eftir að finna út hvernig er skilað jsonObject
    * */
    @RequestMapping(value="/sign-up", method=RequestMethod.POST)
    @ResponseBody
    public Object signUpUser(@RequestBody User user) {
        User tempuser = new User(user.getFirstName(),user.getLastName(),user.getUserName(),user.getPassWord());
        User exists = userService.findByUserName(tempuser.getUserName());
        if(exists == null){
            return userService.save(tempuser);

        }

        return "/error";

    }
    @RequestMapping ("/get-all-users")
    public List<User> findAllUsers(){
        return userService.findAll();
    }

    @RequestMapping("/logInUser")
    public Object logInUser2(@RequestBody User user) {

        User loggedInUser = userService.login(new User(user.getFirstName(),user.getLastName(),user.getUserName(),user.getPassWord()));

        if (loggedInUser != null) {
            return loggedInUser;
        }
        return "/error";
    }
}
