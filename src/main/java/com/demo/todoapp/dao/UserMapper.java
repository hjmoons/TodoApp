package com.demo.todoapp.dao;

import com.demo.todoapp.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    int validateUser(UserDTO userDTO);
    int insertUser(UserDTO userDTO);
    UserDTO loginUser(UserDTO userDTO);

}
