package zw.co.group.springlearning.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import zw.co.group.springlearning.payload.userRequest;
import zw.co.group.springlearning.payload.userResponse;

@Service
public interface userService {

    ResponseEntity<userResponse> getUsers();
    ResponseEntity<userResponse> saveUser(userRequest user);
    ResponseEntity<userResponse> getUser(Long id);
}
