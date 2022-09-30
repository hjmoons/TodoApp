package com.demo.todoapp.service;

import com.demo.todoapp.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    List<TodoDTO> insertTodo(TodoDTO todoDTO);
    List<TodoDTO> selectTodoList();
    List<TodoDTO> updateTodo(TodoDTO todoDTO);
    List<TodoDTO> deleteTodo(TodoDTO todoDTO);
}
