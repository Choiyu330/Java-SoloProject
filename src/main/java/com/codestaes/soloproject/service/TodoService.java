package com.codestaes.soloproject.service;

import com.codestaes.soloproject.entity.Todo;
import com.codestaes.soloproject.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    // 할 일 등록
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    // 할 일 수정
    public Todo updateTodo(Todo todo) throws Exception {
        Todo updateTodo = verifyTodoById(todo.getTodoId());

        Optional.ofNullable(todo.getTitle())
                .ifPresent(updateTodo::setTitle);

        Optional.ofNullable(todo.getTodo_order())
                .ifPresent(updateTodo::setTodo_order);

        Optional.ofNullable(todo.getCompleted())
                .ifPresent(updateTodo::setCompleted);

        return todoRepository.save(updateTodo);
    }

    // 할 일 조회
    public Todo findTodo(Long todoId) throws Exception {
        Todo todo = verifyTodoById(todoId);
        return todo;
    }

    public Page<Todo> findTodos(Pageable pageable) { return todoRepository.findAll(pageable); }

    // 할 일 삭제
    public void deleteTodo(Long todoId) { todoRepository.deleteById(todoId); }

    public Todo verifyTodoById(Long todoId) throws Exception {
        Optional<Todo> findTodo = todoRepository.findByTodoId(todoId);
        return findTodo.orElseThrow(() -> new Exception("Not Found Todo"));
    }
}
