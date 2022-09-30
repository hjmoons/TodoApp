package com.demo.todoapp.service;

import com.demo.todoapp.dao.TodoMapper;
import com.demo.todoapp.dto.TodoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoMapper todoMapper;

    @Override
    public List<TodoDTO> insertTodo(final TodoDTO todoDTO) {
        validate(todoDTO);
        todoMapper.insertTodo(todoDTO);
        log.info("Entity Id: {} is saved.", todoDTO.getId());
        return todoMapper.selectTodoList();
    }

    @Override
    public List<TodoDTO> selectTodoList() {
        return todoMapper.selectTodoList();
    }

    @Override
    public List<TodoDTO> updateTodo(final TodoDTO todoDTO) {
        validate(todoDTO);
        final Optional<TodoDTO> original = Optional.ofNullable(todoMapper.selectTodo(todoDTO.getId()));
        original.ifPresent(todo -> {
            todo.setTitle(todoDTO.getTitle());
            todo.setDone(todoDTO.isDone());
            todoMapper.updateTodo(todo);
        });
        return todoMapper.selectTodoList();
    }

    @Override
    public List<TodoDTO> deleteTodo(final TodoDTO todoDTO) {
        validate(todoDTO);
        try {
            todoMapper.deleteTodo(todoDTO);
        } catch (Exception e) {
            log.error("error deleting entity", todoDTO.getId(), e);
            throw new RuntimeException("error deleting entity" + todoDTO.getId());
        }
        return todoMapper.selectTodoList();
    }

    private void validate(final TodoDTO todoDTO) {
        if(todoDTO == null) {
            log.warn("Entity cannot be null.");
            throw new RuntimeException("Entity cannot be null.");
        }

        if(todoDTO.getUserId() == null) {
            log.warn("Unknown user.");
            throw new RuntimeException("Unknown user.");
        }
    }
}
