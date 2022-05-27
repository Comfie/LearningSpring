package zw.co.group.springlearning.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import zw.co.group.springlearning.model.User;
import zw.co.group.springlearning.payload.RegisterDto;

import java.util.List;

@Service
public interface UserService {

    ResponseEntity<List<User>> getUsers();
    ResponseEntity<User> saveUser(RegisterDto user);
    ResponseEntity<User> updateUser(long id, User user);
    ResponseEntity<User> getUser(long id);
    ResponseEntity<HttpStatus> deleteUser(long id);

}
