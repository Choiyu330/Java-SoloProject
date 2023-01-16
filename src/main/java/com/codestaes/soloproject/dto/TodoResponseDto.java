package com.codestaes.soloproject.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class TodoResponseDto {
    private Long todoId;
    private String title;
    private int todo_order;
    private Boolean completed;
    private List<TodoResponseDto> todos;
}
