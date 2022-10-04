package com.demo.todoapp.controller;

import com.demo.todoapp.dto.ResponseDTO;
import com.demo.todoapp.dto.TodoDTO;
import com.demo.todoapp.dto.UserDTO;
import com.demo.todoapp.service.TodoServiceImpl;
import com.demo.todoapp.service.UserSeviceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserSeviceImpl service;

    @PostMapping
    public ResponseEntity<?> insertTodo(@RequestBody UserDTO dto) {
        try {
            boolean entity = service.insertUser(dto);
            ResponseDTO<Boolean> response = ResponseDTO.<Boolean>builder().data(Collections.singletonList(entity)).build();
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            String error = e.getMessage();
            ResponseDTO<Boolean> response = ResponseDTO.<Boolean>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping(value = "/val")
    public ResponseEntity<?> validateUser(@RequestBody UserDTO dto) {
        try {
            boolean entity = service.validateUser(dto.getId());
            ResponseDTO<Boolean> response = ResponseDTO.<Boolean>builder().data(Collections.singletonList(entity)).build();
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            String error = e.getMessage();
            ResponseDTO<Boolean> response = ResponseDTO.<Boolean>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> loginUser(@RequestBody UserDTO dto) {
        try {
            UserDTO entity = service.loginUser(dto);
            ResponseDTO<UserDTO> response = ResponseDTO.<UserDTO>builder().data(Collections.singletonList(entity)).build();
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            String error = e.getMessage();
            ResponseDTO<UserDTO> response = ResponseDTO.<UserDTO>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }
}
