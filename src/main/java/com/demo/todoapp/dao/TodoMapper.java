package com.demo.todoapp.dao;

import com.demo.todoapp.dto.TodoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TodoMapper {
    public void insertTodo(TodoDTO todoDTO);
    public TodoDTO selectTodo(String id);
    public List<TodoDTO> selectTodoList();
    public void updateTodo(TodoDTO todoDTO);
    public void deleteTodo(TodoDTO todoDTO);
}
