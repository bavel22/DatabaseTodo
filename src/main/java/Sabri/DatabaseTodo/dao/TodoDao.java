package Sabri.DatabaseTodo.dao;

import Sabri.DatabaseTodo.model.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface TodoDao {


    void addTodo (UUID id, Todo todo);

    default void addTodo(Todo todo) {

        UUID id = UUID.randomUUID();
         addTodo(id, todo);
    }

     Todo getTodo(UUID id);

    List<Todo> getAllTodo();
}
