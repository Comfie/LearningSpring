package zw.co.group.springlearning.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import zw.co.group.springlearning.model.User;
import zw.co.group.springlearning.payload.RegisterDto;
import zw.co.group.springlearning.repository.UsersRepository;
import zw.co.group.springlearning.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;


    @Override
    public ResponseEntity<List<User>> getUsers() {

        List<User> users = new ArrayList<User>();

        users.addAll(usersRepository.findAll());

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> saveUser(RegisterDto user) {

        User user1 = new User();
        user1.setUsername(user.getUsername());
        user1.setFirstname(user.getFirstname());
        user1.setLastName(user.getLastName());
        user1.setEmail(user.getEmail());
        user1.setPhone(user.getPhone());

        usersRepository.save(user1);

        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<User> updateUser(long id, User user) {
        Optional<User> userDetails = usersRepository.findById(id);
        if (userDetails.isPresent()) {
            User _user = userDetails.get();
            _user.setUsername(user.getUsername());
            _user.setFirstname(user.getFirstname());
            _user.setLastName(user.getLastName());
            _user.setPhone(user.getPhone());
            _user.setEmail(user.getEmail());

            return new ResponseEntity<>(usersRepository.save(_user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<User> getUser(long id) {

        Optional<User> userDetails = usersRepository.findById(id);

        if (userDetails.isPresent()) {
            return new ResponseEntity<>(userDetails.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<HttpStatus> deleteUser(long id) {
        try {
            usersRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
