package java_spring_laptopshop.controller.admin;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
//import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.ServletContext;
import java_spring_laptopshop.domain.*;
//import java_spring_laptopshop.repository.UserRepository;
import java_spring_laptopshop.service.UserService;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private final UserService userService;
    private final ServletContext servletContext;
    // private final UserRepository userRepository;

    public UserController(UserService userService
    // , UserRepository userRepository
            , ServletContext servletContext) {
        this.userService = userService;
        // this.userRepository = userRepository;
        this.servletContext = servletContext;
    }

    @RequestMapping("/")
    public String getHomePage() {
        // String val = this.userService.HandleHello();
        // model.addAttribute("khoa", val);
        List<User> arrUser = this.userService.getAllUserByGmail("1@gmail.com");
        System.out.println(arrUser);
        return "test";
    }

    @GetMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @PostMapping(value = "/admin/user/create")
    public String handleCreateUser(Model model,
            @RequestParam("imagesFile") MultipartFile file,
            @ModelAttribute("newUser") User khoa) {
        byte[] bytes;
        try {
            bytes = file.getBytes();
            String rootPath = this.servletContext.getRealPath("/resources/images");

            File dir = new File(rootPath + File.separator + "avatar");
            if (!dir.exists())
                dir.mkdirs();

            // Create the file on server
            File serverFile = new File(dir.getAbsolutePath() + File.separator +
                    +System.currentTimeMillis() + "-" + file.getOriginalFilename());

            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // this.userRepository.save(khoa);
        // this.userService.handleSaveUser(khoa);
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

    // Get delete user page
    @GetMapping("/admin/user/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable long id) {
        // User user = this.userService.getUserById(id);
        model.addAttribute("id", id);
        User user = new User();
        // user.setId(id);
        model.addAttribute("deleteUser", user);
        return "/admin/user/delete";
    }

    // action for delete button
    @PostMapping("admin/user/delete")
    public String postDeleteUser(Model model, @ModelAttribute("deleteUser") User current) {
        // model.addAttribute("currentUser", current);
        this.userService.handleDeleteUser(current.getId());
        System.out.println("Runnn");
        return "redirect:/admin/user";
    }

}
