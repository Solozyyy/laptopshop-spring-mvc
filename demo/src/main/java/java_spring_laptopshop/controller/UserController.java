package java_spring_laptopshop.controller;

import java.util.List;
//import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import java_spring_laptopshop.domain.*;
//import java_spring_laptopshop.repository.UserRepository;
import java_spring_laptopshop.service.UserService;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        // redirect + url chu khong phai file's path
        return "redirect:/admin/user";
    }

    @RequestMapping("/admin/user")
    public String getTableUsers(Model model) {
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("Users", users);
        return "/admin/user/table";
    }

    @RequestMapping("/admin/user/show/{id}")
    public String getUserByID(Model model, @PathVariable long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("id", id);
        model.addAttribute("user", user);
        // System.out.println(user);
        return "/admin/user/show";
    }

    // show page
    @GetMapping("/admin/user/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable long id) {
        User currentUser = this.userService.getUserById(id);
        model.addAttribute("newUser", currentUser);
        return "/admin/user/update";
    }

    // check null and update data of currentUser
    @PostMapping("/admin/user/update")
    public String updateUser(Model model, @ModelAttribute("newUser") User current) {
        User currentUser = this.userService.getUserById(current.getId());
        if (currentUser != null) {
            currentUser.setAddress(current.getAddress());
            currentUser.setFullName(current.getFullName());
            currentUser.setPhone(current.getPhone());
            this.userService.handleSaveUser(currentUser);
        }
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable long id) {
        // User user = this.userService.getUserById(id);
        model.addAttribute("id", id);
        User user = new User();
        // user.setId(id);
        model.addAttribute("deleteUser", user);
        return "/admin/user/delete";
    }

    @PostMapping("admin/user/delete")
    public String postDeleteUser(Model model, @ModelAttribute("deleteUser") User current) {
        // model.addAttribute("currentUser", current);
        this.userService.handleDeleteUser(current.getId());
        System.out.println("Runnn");
        return "redirect:/admin/user";
    }

}
