package com.example.User.controllers;
import com.example.User.Dto.CommonResponse;
import com.example.User.Dto.UserDto;
import com.example.User.services.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @CrossOrigin("http://localhost:8081")
    @PostMapping
    private CommonResponse SaveUser(@RequestBody UserDto userDto) {
        try {

            userService.saveUser(userDto);

            return CommonResponse.builder()
                    .code(200)
                    .message("ok").build();
        } catch (Exception ex) {
            return CommonResponse.builder()
                    .code(500)
                    .message(ex.getMessage()).build();
        }

    }

    @CrossOrigin("http://localhost:8081")
    @GetMapping("/user")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @CrossOrigin("http://localhost:8081")
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        userService.deleteUser(id);
    }


    
}
