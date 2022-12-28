package com.codestaes.soloproject.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TodoResponseDto {
    private long todoId;
    private String title;
    private int todo_order;
    private boolean completed;
}
