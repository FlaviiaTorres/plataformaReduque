package git.flavia.PlataformaReduque.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import git.flavia.PlataformaReduque.model.Student;
import git.flavia.PlataformaReduque.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Student> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/byUser/{id}")
    public Student getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    
    @GetMapping("/byName/{name}")
    public Student getUserByUserName(@PathVariable String name) {
        return userService.getUserByName(name);
    }

    @PostMapping
    public Student createUser(@RequestBody Student user) {
        return userService.createUser(user);
    }

    @PutMapping("/updateUser/{id}")
    public Student updateUser(@PathVariable Long id, @RequestBody Student user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}