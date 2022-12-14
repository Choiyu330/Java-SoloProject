package com.codestaes.soloproject.repository;

import com.codestaes.soloproject.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    Optional<Todo> findByTodoId(Long todoId);
}
