package com.codestaes.soloproject.dto;

public class TodoPostDto {
    private String title;
    private int todo_order;
    private boolean completed;

    public String getTitle() {
        return title;
    }

    public int getTodo_order() {
        return todo_order;
    }

    public boolean getCompleted() {
        return completed;
    }
}
