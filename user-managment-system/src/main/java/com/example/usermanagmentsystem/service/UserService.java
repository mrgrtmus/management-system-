package com.example.usermanagmentsystem.service;
import org.springframework.stereotype.Service;
import com.example.usermanagmentsystem.model.User;
import com.example.usermanagmentsystem.repository.UserRepository;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User getUserById(Integer id) {
        User userId = userRepository.getById(id);
        if (userId == null) {
            throw new RuntimeException("User not found");
        }
        return userId;
    }

    public void deleteUserByID(Integer id) {
        Optional<User> optDeleteUser = this.userRepository.findById(id);
        if (optDeleteUser.isPresent()) {
            User userToDelete = optDeleteUser.get();
            this.userRepository.delete(userToDelete);
        }
        else{
                throw new RuntimeException("User not found");
            }
        }
    }

