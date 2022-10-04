package com.demo.todoapp.dao;

import com.demo.todoapp.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    int existsUser(String userId);
    int insertUser(UserDTO userDTO);
    UserDTO selectUser(String email);
    UserDTO loginUser(String email, String passwd);

}
