package Sabri.DatabaseTodo.service;

import Sabri.DatabaseTodo.dao.TodoDao;
import Sabri.DatabaseTodo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TodoService {

    private final TodoDao todoDao;

    @Autowired
    public TodoService(@Qualifier("MySQL") TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    public UUID addTodo(Todo todo) {

        return todoDao.addTodo(todo);


    }

    public Todo getTodoById(UUID id) {
        return todoDao.getTodoById(id);
    }

    public List<Todo> getTodoByName(String name) {
        return todoDao.getTodoByName(name);
    }

    public Iterable<Todo> getAllTodo() {
        return todoDao.getAllTodo();
    }

    public Iterable<Todo> getAllCompletedTodos() {
        return todoDao.getAllCompletedTodos();
    }

    public void deleteTodo(UUID id) {
        todoDao.deleteTodo(id);
    }

    public void putTodo(UUID id, Todo todo) {
        todoDao.putTodo(id, todo);
    }
}