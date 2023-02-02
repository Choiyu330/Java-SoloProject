package com.codestaes.soloproject.controller;

import com.codestaes.soloproject.dto.PageResponseDto;
import com.codestaes.soloproject.dto.TodoPatchDto;
import com.codestaes.soloproject.dto.TodoPostDto;
import com.codestaes.soloproject.dto.TodoResponseDto;
import com.codestaes.soloproject.entity.Todo;
import com.codestaes.soloproject.mapper.TodoMapper;
import com.codestaes.soloproject.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;
    private final TodoMapper todoMapper;

    // 할 일 등록
    @PostMapping
    public ResponseEntity postTodo(@Valid @RequestBody TodoPostDto todoPostDto) {
        Todo save = todoService.createTodo(
                todoMapper.TodoPostDtoToEntity(todoPostDto)
        );
        System.out.println("등록 성공 !");
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    // 할 일 수정
    @PatchMapping("/{todo-id}")
    public ResponseEntity patchTodo(@PathVariable("todo-id") Long todoId,
                                    @RequestBody TodoPatchDto todoPatchDto) throws Exception {
        Todo update = todoService.updateTodo(
                todoMapper.TodoPatchDtoToEntity(todoPatchDto)
        );
        return new ResponseEntity<>(update, HttpStatus.OK);
    }

    // 할 일 단건 조회
    @GetMapping("/{todo-id}")
    public ResponseEntity getTodo(@PathVariable("todo-id") @Positive Long todoId) throws Exception {

        Todo todo = todoService.verifyTodoById(todoId);
        TodoResponseDto todoResponseDto =
                todoMapper.TodoEntityToResponseDto(todo);

        return new ResponseEntity<>(todoResponseDto, HttpStatus.OK);
    }

    // 할일 전체 조회
    @GetMapping
    public ResponseEntity getTodos(
            @PageableDefault(page = 0, size = 10, sort = "todoId", direction = Sort.Direction.DESC)
            Pageable pageable
            ) {

        Page<Todo> todos = todoService.findTodos(pageable);
        List<TodoResponseDto> todoList =
                todoMapper.TodoListToResponseDtoList(todos.getContent());
        PageResponseDto response = PageResponseDto.of(
                todoList,
                new PageImpl<>(
                        todoList,
                        todos.getPageable(),
                        todos.getTotalElements()
                ));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 할 일 삭제
    @DeleteMapping("/{todo-id}")
    public ResponseEntity deleteTodos(@PathVariable("todo-id") long todoId) {
        todoService.deleteTodo(todoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
