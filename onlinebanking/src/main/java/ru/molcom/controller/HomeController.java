package ru.molcom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.molcom.domain.User;
import ru.molcom.service.interfaces.IUserService;

@Controller
public class HomeController {

    @Autowired
    public IUserService userService;

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/signup")
    public String signup(Model model) {
        User user = new User();

        model.addAttribute("user", user);

        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupPost(@ModelAttribute("user") User user, Model model) {

        if(userService.checkUserExists(user.getUserName(), user.getEmail()))  {

            if (userService.checkEmailExists(user.getEmail())) {
                model.addAttribute("emailExists", true);
            }

           if (userService.checkUsernameExists(user.getUserName())) {
                model.addAttribute("usernameExists", true);
            }

            return "signup";
        } /*else {
            Set<UserRole> userRoles = new HashSet<>();
            userRoles.add(new UserRole(user, roleDao.findByName("ROLE_USER")));

            userService.createUser(user, userRoles);

            return "redirect:/";
        }*/
        else {

            userService.save(user);

            return "redirect:/";
        }
    }
}
