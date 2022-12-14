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

    public Todo(
            String title,
            int todo_order,
            Boolean completed
    ) {
        this.title = title;
        this.todo_order = todo_order;
        this.completed = completed;
    }

}
