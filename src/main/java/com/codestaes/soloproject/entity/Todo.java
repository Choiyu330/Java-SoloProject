package com.codestaes.soloproject.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoId;

    @Column
    private String title;

    @Column
    private int todo_order;

    @Column
    private Boolean completed;

    // 생성자
    public Todo(
            Long todoId,
            String title,
            int todo_order,
            Boolean completed
    ) {
        this.todoId = todoId;
        this.title = title;
        this.todo_order = todo_order;
        this.completed = completed;
    }

}
