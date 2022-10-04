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
    public boolean validateUser(String userId) {
        int result = userMapper.validateUser(userId);
        return result > 0;
    }

    @Override
    public boolean insertUser(final UserDTO userDTO) {
        validate(userDTO);
        int result = userMapper.insertUser(userDTO);
        log.info("Entity Id: {} is saved.", userDTO.getId());
        return result > 0;
    }

    @Override
    public UserDTO loginUser(final UserDTO userDTO) {
        validate(userDTO);
        return userMapper.loginUser(userDTO);
    }

    private void validate(final UserDTO userDTO) {
        if(userDTO == null) {
            log.warn("Entity cannot be null.");
            throw new RuntimeException("Entity cannot be null.");
        }

        if(userDTO.getId() == null) {
            log.warn("Unknown id.");
            throw new RuntimeException("Unknown id.");
        }
    }
}
