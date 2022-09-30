package com.demo.todoapp.dto;

import lombok.Data;

@Data
public class TodoDTO {
    private String id;
    private String userId;
    private String title;
    private boolean done;
}
