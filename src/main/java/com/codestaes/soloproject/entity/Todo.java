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
    @GeneratedValue
    private long todoId;
    private String title;
    private int todo_order;
    private boolean completed;

    public Todo(String title) {
        this.title = title;
    }

}
