package com.demo.todoapp.service;

import com.demo.todoapp.dao.UserMapper;
import com.demo.todoapp.dto.TodoDTO;
import com.demo.todoapp.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserSeviceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDTO insertUser(final UserDTO userDTO) {
        if(userDTO == null || userDTO.getEmail() == null) {
            throw new RuntimeException("Invalid arguments");
        }
        log.info(String.valueOf(userDTO));
        final String email = userDTO.getEmail();
        log.info(String.valueOf(userMapper.existsUser(email)));
        if(userMapper.existsUser(email) > 0) {
            log.warn("Email already exists {}", email);
            throw new RuntimeException("Email already exists");
        }

        userMapper.insertUser(userDTO);

        return userMapper.selectUser(email);
    }

    @Override
    public UserDTO loginUser(String email, String passwd) {
        return userMapper.loginUser(email, passwd);
    }
}
