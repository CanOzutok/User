package com.example.User.services.interfaces;

import com.example.User.Dto.UserDto;


import java.util.List;

public interface UserService {




    UserDto saveUser(UserDto userdto);



    List<UserDto> getAllUsers();

    void deleteUser(Long id);
}
