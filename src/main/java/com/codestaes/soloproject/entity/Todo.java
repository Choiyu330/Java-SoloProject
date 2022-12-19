package com.codestaes.soloproject.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    private long todoId;
    private String title;
    private int todo_order;
    private boolean completed;

}
