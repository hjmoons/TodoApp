package com.demo.todoapp.service;

import com.demo.todoapp.dto.UserDTO;

public interface UserService {
    int validateUser(UserDTO userDTO);
    int insertUser(UserDTO userDTO);
    UserDTO loginUser(UserDTO userDTO);
}
