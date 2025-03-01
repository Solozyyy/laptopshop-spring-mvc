package java_spring_laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import java_spring_laptopshop.domain.User;
import java_spring_laptopshop.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getAllUserByGmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User handleSaveUser(User user) {
        return this.userRepository.save(user);
    }
}
