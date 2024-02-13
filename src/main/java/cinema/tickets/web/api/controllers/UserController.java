package cinema.tickets.web.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cinema.tickets.core.UserService;
import cinema.tickets.core.models.User;
import cinema.tickets.web.api.models.UserInput;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUser(int id) {
        return userService.getUser(id);
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }
    
    @PostMapping
    public User createUser(@RequestBody UserInput userInput) {
        return userService.createUser(userInput.username, userInput.password, userInput.email);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(int id) {
        userService.deleteUser(id);
    }
    
}
