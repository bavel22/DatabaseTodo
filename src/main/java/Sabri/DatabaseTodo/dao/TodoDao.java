package Sabri.DatabaseTodo.dao;

import Sabri.DatabaseTodo.model.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TodoDao {


    UUID addTodo (UUID id, Todo todo);

    default UUID addTodo(Todo todo) {

        UUID id = UUID.randomUUID();
        return addTodo(id, todo);
    }

    Todo getTodoById(UUID id);
    List<Todo> getTodoByName(String name);

    Iterable<Todo> getAllTodo();
    Iterable<Todo> getAllCompletedTodos();

    void deleteTodo(UUID id);

    void putTodo(UUID id, Todo todo);
}
