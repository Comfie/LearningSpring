package zw.co.group.springlearning.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.group.springlearning.payload.userRequest;
import zw.co.group.springlearning.payload.userResponse;
import zw.co.group.springlearning.service.userService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users/")
public class userController {

    private final userService userService;

    @PostMapping("create")
    ResponseEntity<userResponse> saveUser(@RequestBody userRequest user){
        return userService.saveUser(user);
    }

    @GetMapping("getAll")
    ResponseEntity<userResponse> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("getUserById/{id}")
    ResponseEntity<userResponse> getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

}
