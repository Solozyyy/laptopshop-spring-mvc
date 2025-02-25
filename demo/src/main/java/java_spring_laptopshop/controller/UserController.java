package java_spring_laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java_spring_laptopshop.service.UserService;

@Controller
public class UserController {

    @RequestMapping("/")
    public String getHomePage() {
        return "test";
    }

}
