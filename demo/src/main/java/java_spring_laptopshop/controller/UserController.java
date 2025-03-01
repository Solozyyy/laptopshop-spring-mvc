package java_spring_laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import java_spring_laptopshop.domain.*;
import java_spring_laptopshop.repository.UserRepository;
import java_spring_laptopshop.service.UserService;

@Controller
public class UserController {

    private final UserService userService;
    // private final UserRepository userRepository;

    public UserController(UserService userService
    // , UserRepository userRepository
    ) {
        this.userService = userService;
        // this.userRepository = userRepository;
    }

    @RequestMapping("/")
    public String getHomePage() {
        // String val = this.userService.HandleHello();
        // model.addAttribute("khoa", val);
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
        // this.userRepository.save(khoa);
        this.userService.handleSaveUser(khoa);
        return "test";
    }

}
