package com.codestaes.soloproject.dto;

import javax.validation.constraints.NotBlank;

public class TodoPostDto {

    @NotBlank(message = "내용은 공백이 아니어야 합니다.")
    private String title;
    private int todo_order;
    private boolean completed;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTodo_order() {
        return todo_order;
    }

    public void setTodo_order(int todo_order) {
        this.todo_order = todo_order;
    }

    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
