package com.codestaes.soloproject.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class TodoPostDto {

    @Positive
    @NotBlank(message = "내용은 공백이 아니어야 합니다.")
    private String title;
    private int todo_order;
    private boolean completed;

}
