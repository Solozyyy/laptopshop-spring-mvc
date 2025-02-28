package java_spring_laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java_spring_laptopshop.service.UserService;
import org.springframework.web.bind.annotation.RequestMethod;
import java_spring_laptopshop.domain.*;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        String val = this.userService.HandleHello();
        model.addAttribute("khoa", val);
        return "test";
    }

    @RequestMapping("/admin/user")
    public String getUser(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @RequestMapping(value = "/admin/user/create1", method = RequestMethod.POST)
    public String createUser(Model model, @ModelAttribute("newUser") User khoa) {
        System.out.println(khoa);
        return "test";
    }

}
