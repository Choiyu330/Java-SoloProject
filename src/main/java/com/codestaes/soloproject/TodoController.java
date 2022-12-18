package com.codestaes.soloproject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
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
    @PostMapping
    public ResponseEntity postTodo(@RequestParam("title") String title,
                                   @RequestParam("todo_order") Integer todo_order,
                                   @RequestParam("completed") boolean completed) {

        Map<Object, Object> map = new HashMap<>();
        map.put("title", title);
        map.put("todo_order", todo_order);
        map.put("completed", completed);

        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @GetMapping("/{todo-id}")
    public ResponseEntity getTodo(@PathVariable("todo-id") long todoId) {
        System.out.println("# todoId: " + todoId);

        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getTodos() {
        System.out.println("# get Todos");

        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    @PatchMapping("/{todo-id}")
    public ResponseEntity updateTodos() {
        System.out.println("# update Todos");

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{todo-id}")
    public ResponseEntity deleteTodos() {
        System.out.println("# delete Todos");

        todos.remove(1L);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
