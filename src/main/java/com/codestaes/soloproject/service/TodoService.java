package com.codestaes.soloproject.service;

import com.codestaes.soloproject.entity.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    public Todo createTodo(Todo todo) {
        Todo createdTodo = todo;
        return createdTodo;
    }

    public Todo updateTodo(Todo todo) {
        Todo updatedTodo = todo;
        return updatedTodo;
    }

    public Todo findTodo(long todoId) {
        Todo todo = new Todo(todoId, "뭐하지", 1, false);
        return todo;
    }

    public List<Todo> findTodos() {
        List<Todo> todos = List.of(
                new Todo(1, "첫 번째 할 일", 1, true),
                new Todo(2, "두 번째 할 일", 2, false)
        );
        return todos;
    }

    public void deleteTodo(long todoId) {

    }
}
