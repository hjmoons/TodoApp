package com.demo.todoapp.controller;

import com.demo.todoapp.dto.ResponseDTO;
import com.demo.todoapp.dto.TodoDTO;
import com.demo.todoapp.dto.UserDTO;
import com.demo.todoapp.security.TokenProvider;
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
@RequestMapping("/auth")
@Slf4j
public class UserController {
    @Autowired
    private UserSeviceImpl service;

    @Autowired
    private TokenProvider tokenProvider;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO dto) {
        try {
            return ResponseEntity.ok().body(service.insertUser(dto));
        } catch (Exception e) {
            String error = e.getMessage();
            ResponseDTO response = ResponseDTO.builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping(value = "/signin")
    public ResponseEntity<?> authenticate(@RequestBody UserDTO dto) {
        UserDTO user = service.loginUser(dto.getEmail(), dto.getPasswd());
        if(user != null) {
            final String token = tokenProvider.create(user);
            final UserDTO responseUserDTO = UserDTO.builder()
                    .email(user.getEmail())
                    .id(user.getId())
                    .token(token)
                    .build();
            return ResponseEntity.ok().body(responseUserDTO);
        } else {
            ResponseDTO responseDTO = ResponseDTO.builder().error("Login failed.").build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }
}
