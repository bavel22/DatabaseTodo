package Sabri.DatabaseTodo.dao;

import Sabri.DatabaseTodo.model.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface TodoDao {


    UUID addTodo (UUID id, Todo todo);

    default UUID addTodo(Todo todo) {

        UUID id = UUID.randomUUID();
        return addTodo(id, todo);
    }

     Todo getTodo(UUID id);

    List<Todo> getAllTodo();
}
