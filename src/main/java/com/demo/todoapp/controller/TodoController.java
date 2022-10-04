package com.demo.todoapp.controller;

import com.demo.todoapp.dto.ResponseDTO;
import com.demo.todoapp.dto.TodoDTO;
import com.demo.todoapp.service.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private TodoServiceImpl service;

    @PostMapping
    public ResponseEntity<?> insertTodo(@RequestBody TodoDTO dto) {
        try {
            String temporaryUserId = "temporary-user";
            TodoDTO entity = dto;
            entity.setId(null);
            entity.setUserId(temporaryUserId);
            List<TodoDTO> entities = service.insertTodo(entity);
            ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(entities).build();
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            String error = e.getMessage();
            ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping
    public ResponseEntity<?> selectTodoList() {
        List<TodoDTO> entities = service.selectTodoList();
        ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(entities).build();
        return ResponseEntity.ok().body(response);
    }

    @PutMapping
    public ResponseEntity<?> updateTodo(@RequestBody TodoDTO dto) {
        String temporaryUserId = "temporary-user";
        TodoDTO entity = dto;
        entity.setUserId(temporaryUserId);
        List<TodoDTO> entities = service.updateTodo(entity);
        ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(entities).build();
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteTodo(@RequestBody TodoDTO dto) {
        try {
            String temporaryUserId = "temporary-user";
            TodoDTO entity = dto;
            entity.setUserId(temporaryUserId);
            List<TodoDTO> entities = service.deleteTodo(entity);
            ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(entities).build();
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            String error = e.getMessage();
            ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }
}
