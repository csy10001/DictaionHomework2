package org.example.dictaionhomework2.User.controller;

import lombok.RequiredArgsConstructor;
import org.example.dictaionhomework2.User.dto.UserRequestDto;
import org.example.dictaionhomework2.User.dto.UserResponseDto;
import org.example.dictaionhomework2.User.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public UserResponseDto createUser(@RequestBody UserRequestDto userResponseDto){
        return userService.createUser(userResponseDto);
    }

    @GetMapping("/users")
    public List<UserResponseDto> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/users/{userId}")
    public UserResponseDto getUser(@PathVariable Long userId) {
        return userService.getUser(userId);
    }

    @PutMapping("/users/{userId}")
    public UserResponseDto updateUser(@PathVariable Long userId, @RequestBody UserRequestDto userRequestDto){
        return userService.updateUser(userId,userRequestDto);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
    }
}
