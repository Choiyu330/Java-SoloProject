package com.codestaes.soloproject.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class TodoPatchDto {
    private Long todoId;
    @NotBlank(message = "수정하려는 내용은 공백이 아니어야 합니다.")
    private String title;
    private int todo_order;
    private Boolean completed;

}
