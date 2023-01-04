package com.codestaes.soloproject.mapper;

import com.codestaes.soloproject.dto.TodoPatchDto;
import com.codestaes.soloproject.dto.TodoPostDto;
import com.codestaes.soloproject.dto.TodoResponseDto;
import com.codestaes.soloproject.entity.Todo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMapper {
    Todo TodoPostDtoToEntity(TodoPostDto todoPostDto);
    Todo TodoPatchDtoToEntity(TodoPatchDto todoPatchDto);
    TodoResponseDto TodoEntityToResponseDto(Todo todo);
    List<TodoResponseDto> TodoListToResponseDtoList(List<Todo> todoList);
}
