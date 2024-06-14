package com.liliia.Controllers;
/*import com.liliia.model.User;
import com.liliia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/register")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

        public static final String USER_DELETED_SUCCESSFULLY = "User deleted successfully";



       /* @PostMapping(
                path = "/add",
                produces = MediaType.APPLICATION_JSON_VALUE
        )
        public ResponseEntity<User> addNewUser(
                @RequestBody @Valid User user
        ) throws UserNotFoundException, UsernameExistException, EmailExistsException {

            User newUser = userService.addNewUser(user);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        }

        @PostMapping(
                path = "/update",
                produces = {MediaType.APPLICATION_JSON_VALUE}
        )
        public ResponseEntity<User> updateUser(
                @RequestBody User user
        ) throws UserNotFoundException, UsernameExistException, EmailExistsException {

            User updatedUser = userService.updateUser(user);
            return new ResponseEntity<>(updatedUser, OK);
        }


        @PostMapping(path = "/update/profile")
        public ResponseEntity<User> updateUserProfile(
                @RequestParam("currentUsername") String currentUsername,
                @RequestParam("firstName") String firstName,
                @RequestParam("lastName") String lastName,
                @RequestParam("username") String username,
                @RequestParam("email") String email,
                @RequestParam("role") String role,
                @RequestParam("enable") String enable,
                @RequestParam("job") String job,
                @RequestParam("discordAccount") String discordAccount

        ) throws UserNotFoundException, UsernameExistException, EmailExistsException {

            User updatedUserProfile = userService.updateUserProfile(
                    currentUsername, firstName, lastName, username, email, role, Boolean.parseBoolean(enable), job, discordAccount
            );
            return new ResponseEntity<>(updatedUserProfile, OK);
        }

        @GetMapping("/find/{username}")
        public ResponseEntity<User> getUser(@PathVariable("username") String username) {
            User user = userService.findUserByUsername(username);
            return new ResponseEntity<>(user, OK);
        }


        @DeleteMapping(path = "/{username}/delete")
        public ResponseEntity<HttpResponse> deleteUser(@PathVariable("username") String username)
                throws UserNotFoundException {

            userService.deleteUser(username);
            return response(OK, USER_DELETED_SUCCESSFULLY);
        }

        private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
            return new ResponseEntity<>(
                    new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(),
                            message), httpStatus);
        }
    }
}
*/