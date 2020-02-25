package com.rodrigo.backend.controllers;

import com.rodrigo.backend.models.User;
import com.rodrigo.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.rodrigo.backend.Routes.BASE_API_VERSION;

@RestController
@RequestMapping(BASE_API_VERSION)
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    @ResponseBody
    public User createUser(@RequestParam String name, String lastName) {
        return userService.saveUser(name, lastName);
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/users")
    public List<User> getListUsers() {
        return userService.allUsers();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
