package org.example.dictaionhomework2.User.service;

import lombok.RequiredArgsConstructor;
import org.example.dictaionhomework2.User.dto.UserRequestDto;
import org.example.dictaionhomework2.User.dto.UserResponseDto;
import org.example.dictaionhomework2.User.entity.User;
import org.example.dictaionhomework2.User.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto createUser(UserRequestDto userRequestDto){
        User user = new User(userRequestDto.getName());
        User savedUser = userRepository.save(user);
        return new UserResponseDto(savedUser.getId(), savedUser.getName());
    }

    @Transactional(readOnly = true)
    public UserResponseDto getUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException("해당하는 멤버 id가 없습니다.")
        );

        return new UserResponseDto(user.getId(), user.getName()
        );
    }

    @Transactional(readOnly = true)
    public List<UserResponseDto> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponseDto> dtos = new java.util.ArrayList<>();

        for (User user : users) {
            UserResponseDto userResponseDto = new UserResponseDto(user.getId(), user.getName()
            );
            dtos.add(userResponseDto);
        }
        return dtos;
    }

    @Transactional
    public UserResponseDto updateUser(Long id, UserRequestDto userRequestDto) {
        User user = userRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 멤버 id는 없습니다.")
        );
        user.updateName(userRequestDto.getName());
        return new UserResponseDto(user.getId(), user.getName()
        );
    }

    @Transactional
    public void deleteUser(Long id){
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 멤버 id는 없습니다.")
        );
        userRepository.deleteById(id);
    }
}
