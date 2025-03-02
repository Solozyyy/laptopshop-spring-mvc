package java_spring_laptopshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import java_spring_laptopshop.domain.*;
//import java_spring_laptopshop.repository.UserRepository;
import java_spring_laptopshop.service.UserService;
//import org.springframework.web.bind.annotation.RequestParam;

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
        List<User> arrUser = this.userService.getAllUserByGmail("1@gmail.com");
        System.out.println(arrUser);
        return "test";
    }

    @RequestMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String handleCreateUser(Model model, @ModelAttribute("newUser") User khoa) {
        System.out.println(khoa);
        // this.userRepository.save(khoa);
        this.userService.handleSaveUser(khoa);
        return "test";
    }

    @RequestMapping("/admin/user")
    public String requestMethodName() {
        return "/admin/user/table";
    }

}
