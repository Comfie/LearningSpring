package zw.co.group.springlearning.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.group.springlearning.model.User;
import zw.co.group.springlearning.payload.RegisterDto;
import zw.co.group.springlearning.service.UserService;

import java.util.List;
@CrossOrigin(origins = "http://localhost:8090")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users/")
public class UserController {

    private final UserService userService;

    @PostMapping("create")
    public ResponseEntity<User> saveUser(@RequestBody RegisterDto user){
        return userService.saveUser(user);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<User>> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("getUserById/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id){
        return userService.getUser(id);
    }

    @PutMapping("updateUser{id}")
    public ResponseEntity<User> updateUserDetails(@PathVariable long id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("deleteUser/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable long id){
        return userService.deleteUser(id);
    }

}
