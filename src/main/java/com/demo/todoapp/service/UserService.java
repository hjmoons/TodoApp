package com.demo.todoapp.service;

import com.demo.todoapp.dto.UserDTO;

public interface UserService {
    boolean validateUser(String userId);
    boolean insertUser(UserDTO userDTO);
    UserDTO loginUser(UserDTO userDTO);
}
