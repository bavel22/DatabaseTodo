package Sabri.DatabaseTodo.dao;

import Sabri.DatabaseTodo.model.Todo;
import Sabri.DatabaseTodo.model.TodoRepository;
import javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("MySQL")
@Service
public class TodoDataAccessService implements TodoDao {

    @Autowired
    private TodoRepository todoRepository;

    public TodoDataAccessService() {
    }

    @Override
    public UUID addTodo(UUID id, Todo todo) {
        return null;
    }

    @Override
    public UUID addTodo(@RequestBody Todo todo) {

        System.out.println("Service");

        Todo n = new Todo(todo.getName(), todo.getDescription());
        todoRepository.save(n);
        return todo.getId();
    }

    @Override
    public Todo getTodoById(UUID id) {
        Todo foundTodo = new Todo();

        for (Todo todo : todoRepository.findAll()
        ) {
            if (todo.getId().equals(id)) {
                foundTodo = todo;
            }
        }
        return foundTodo;
    }
    // return  todoRepository.findById(id);   why didnt this work???


    public List<Todo> getTodoByName(String name) {
        List todos = new ArrayList();

        for (Todo todo : todoRepository.findAll()
        ) {
            if (todo.getName().equalsIgnoreCase(name)) {
                todos.add(todo);
            }
        }
        return todos;
    }

    @Override
    public Iterable<Todo> getAllTodo() {
        return todoRepository.findAll();
    }

    @Override
    public Iterable<Todo> getAllCompletedTodos() {
        List todos = new ArrayList();

        for (Todo todo : todoRepository.findAll()
        ) {
            if (todo.isComplete()) {
                todos.add(todo);
            }
        }
        return todos;
    }

    @Override
    public void deleteTodo(UUID id) {
        System.out.println("test");
        Todo foundTodo = new Todo();

        for (Todo todo : todoRepository.findAll()
        ) {
            if (todo.getId().equals(id)) {
                foundTodo = todo;
            }
        }
        System.out.println(foundTodo);
        todoRepository.delete(foundTodo);
       // todoRepository.delete(id);
    }

    @Override
    public void putTodo(UUID id, Todo todo) {
       getTodoById(id).setName(todo.getName());
       getTodoById(id).setDescription(todo.getDescription());



        System.out.println("test");

    }
}

