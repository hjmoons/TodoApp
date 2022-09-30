package com.demo.todoapp.dao;

import com.demo.todoapp.dto.TodoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TodoMapper {
    void insertTodo(TodoDTO todoDTO);
    TodoDTO selectTodo(String id);
    List<TodoDTO> selectTodoList();
    void updateTodo(TodoDTO todoDTO);
    void deleteTodo(TodoDTO todoDTO);
}
