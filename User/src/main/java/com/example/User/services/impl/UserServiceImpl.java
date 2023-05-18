package com.example.User.services.impl;

import com.example.User.Dto.UserDto;
import com.example.User.entities.User;
import com.example.User.repo.UserRepo;
import com.example.User.services.interfaces.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo){this.userRepo = userRepo;}




    public UserDto saveUser(UserDto userdto){
        if(userdto.getId()==0){
            User user =new User();
            user.setFirstname(userdto.getFirstname());
            user.setLastname((userdto.getLastname()));
            user.setEmail(userdto.getEmail());
            userRepo.save(user);
            return userdto;
        }else{
                Optional<User> user = userRepo.findById(userdto.getId());

                if(user.isPresent()){
                    User user1 = new User();
                    user.get().setFirstname(userdto.getFirstname());
                    user.get().setLastname(userdto.getLastname());
                    user.get().setEmail(userdto.getEmail());
                    user.get().setId(userdto.getId());
                    user1.setFirstname(user.get().getFirstname());
                    user1.setId(user.get().getId());
                    user1.setLastname(user.get().getLastname());
                    user1.setEmail(user.get().getEmail());
                    userRepo.save(user1);
                }
                return null;

        }

    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepo.findAll();
        List<UserDto> usersDto = new ArrayList<>();

        for (User user : users) {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setFirstname(user.getFirstname());
            userDto.setLastname(user.getLastname());
            userDto.setEmail(user.getEmail());
            usersDto.add(userDto);
        }

        return usersDto;
    }
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}
