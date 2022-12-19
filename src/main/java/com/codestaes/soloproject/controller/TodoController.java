package com.codestaes.soloproject.controller;

import com.codestaes.soloproject.dto.TodoPatchDto;
import com.codestaes.soloproject.dto.TodoPostDto;
import com.codestaes.soloproject.entity.Todo;
import com.codestaes.soloproject.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping
@Validated
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;

    }

    // 회원 정보 등록
    @PostMapping
    public ResponseEntity postTodo(@Valid @RequestBody TodoPostDto todoPostDto) {
        Todo todo = new Todo();
        todo.setTitle(todoPostDto.getTitle());
        todo.setTodo_order(todoPostDto.getTodo_order());
        todo.setCompleted(todoPostDto.getCompleted());

        Todo response = todoService.createTodo(todo);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // 회원 정보 수정
    @PatchMapping("/{todo-id}")
    public ResponseEntity patchTodo(@PathVariable("todo-id") long todoId,
                                    @Valid @RequestBody TodoPatchDto todoPatchDto) {

        Todo todo = new Todo();
        todo.setTodoId(todoPatchDto.getTodoId());
        todo.setTitle(todoPatchDto.getTitle());
        todo.setTodo_order(todoPatchDto.getTodo_order());
        todo.setCompleted(todoPatchDto.getCompleted());

        Todo response = todoService.updateTodo(todo);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 한 명의 회원 조회
    @GetMapping("/{todo-id}")
    public ResponseEntity getTodo(@PathVariable("todo-id") @Positive long todoId) {

        System.out.println("# todoId: " + todoId);

        Todo response = todoService.findTodo(todoId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 모든 회원 조회
    @GetMapping
    public ResponseEntity getTodos() {
        System.out.println("# get Todos");

        List<Todo> response = todoService.findTodos();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 회원 정보 삭제
    @DeleteMapping("/{todo-id}")
    public ResponseEntity deleteTodos(@PathVariable("todo-id") long todoId) {
        System.out.println("# delete Todos");

        todoService.deleteTodo(todoId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
