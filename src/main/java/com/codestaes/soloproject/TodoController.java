package com.codestaes.soloproject;

import com.codestaes.soloproject.dto.TodoPatchDto;
import com.codestaes.soloproject.dto.TodoPostDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class TodoController {
    private final Map<Long, Map<Object, Object>> todos = new HashMap<>();
    @PostConstruct
    public void init() {
        Map<Object, Object> todo1 = new HashMap<>();
        long todoId = 1L;
        todo1.put("todo_id", todoId);
        todo1.put("title", "Create Controller");
        todo1.put("todo_order", 2);
        todo1.put("completed", true);

        todos.put(todoId, todo1);
    }

    // 회원 정보 등록
    @PostMapping
    public ResponseEntity postTodo(@Valid @RequestBody TodoPostDto todoPostDto) {
        return new ResponseEntity<>(todoPostDto, HttpStatus.CREATED);
    }

    // 회원 정보 수정
    @PatchMapping("/{todo-id}")
    public ResponseEntity patchTodo(@PathVariable("todo-id") long todoId,
                                    @Valid @RequestBody TodoPatchDto todoPatchDto) {

        todoPatchDto.setTodoId(todoId);
        todoPatchDto.setCompleted(true);
        System.out.println("# update Todos");

        return new ResponseEntity<>(todoPatchDto, HttpStatus.OK);
    }

    // 한 명의 회원 조회
    @GetMapping("/{todo-id}")
    public ResponseEntity getTodo(@PathVariable("todo-id") long todoId) {
        System.out.println("# todoId: " + todoId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 모든 회원 조회
    @GetMapping
    public ResponseEntity getTodos() {
        System.out.println("# get Todos");

        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 회원 정보 삭제
    @DeleteMapping("/{todo-id}")
    public ResponseEntity deleteTodos(@PathVariable("todo-id") long todoId) {
        System.out.println("# delete Todos");


        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
