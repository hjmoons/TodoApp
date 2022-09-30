package com.demo.todoapp.service;

import com.demo.todoapp.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    public List<TodoDTO> insertTodo(TodoDTO todoDTO);
    public List<TodoDTO> selectTodoList();
    public List<TodoDTO> updateTodo(TodoDTO todoDTO);
    public List<TodoDTO> deleteTodo(TodoDTO todoDTO);
}
