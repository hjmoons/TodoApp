package com.demo.todoapp.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String id;
    private String passwd;
    private String name;
    private String email;
    private int auth;
}
