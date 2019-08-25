package Sabri.DatabaseTodo.dao;

import Sabri.DatabaseTodo.model.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakeTodoDataAccessService implements TodoDao {

    // connect MySQL database here?

    private final static List<Todo> todos = new ArrayList<>();



    @Override
    public UUID addTodo(UUID id, Todo todo) {
        System.out.println("DAO1");
        todos.add(new Todo(id, todo.getName(), todo.getDescription()));
        return id;
    }

    @Override
    public UUID addTodo(Todo todo) {
        System.out.println("DAO2");
        UUID id = UUID.randomUUID();
        todos.add(new Todo(id, todo.getName(), todo.getDescription()));
        return id;
    }

    @Override
    public Todo getTodo(UUID id) {

        Todo foundTodo = new Todo("Not Found", "Not Found");

        for (Todo todo: todos
             ) { UUID todoId = todo.getId();

             if (todoId.equals(id)) {
                 foundTodo = todo;
             }


        }
        return foundTodo;
    }

    @Override
    public List<Todo> getAllTodo() {
        return todos;
    }
}
