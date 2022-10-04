package com.demo.todoapp.service;

import com.demo.todoapp.dto.UserDTO;

public interface UserService {
    //boolean existsUser(String userId);
    UserDTO insertUser(UserDTO userDTO);
    UserDTO loginUser(String email, String passwd);
}
