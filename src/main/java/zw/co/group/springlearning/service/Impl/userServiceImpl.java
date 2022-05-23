package zw.co.group.springlearning.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import zw.co.group.springlearning.model.user;
import zw.co.group.springlearning.payload.userRequest;
import zw.co.group.springlearning.payload.userResponse;
import zw.co.group.springlearning.repository.usersRepository;
import zw.co.group.springlearning.service.userService;

@Service
@RequiredArgsConstructor
public class userServiceImpl implements userService {

    private final usersRepository usersRepository;


    @Override
    public ResponseEntity<userResponse> getUsers() {
        return ResponseEntity.ok(new userResponse(00, "All users fetched", usersRepository.findAll()));
    }


    @Override
    public ResponseEntity<userResponse> saveUser(userRequest user) {

        user user1 = new user();

        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());

        usersRepository.save(user1);

        return ResponseEntity.ok(new userResponse(200, "User saved", ""));
    }


    @Override
    public ResponseEntity<userResponse> getUser(Long id) {
        return ResponseEntity.ok(new userResponse(00, "All users fetched", usersRepository.findById(id)));
    }
}
