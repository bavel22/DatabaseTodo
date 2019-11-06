package Sabri.DatabaseTodo.service;

import Sabri.DatabaseTodo.model.Todo;
import Sabri.DatabaseTodo.model.TodoNotFoundException;
import Sabri.DatabaseTodo.model.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.*;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo addTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo getTodoById(UUID id) {
        Optional<Todo> newTodo = todoRepository.findById(id);
        return newTodo.orElseThrow(() -> new TodoNotFoundException(id));
    }

    public Todo findTodoByName(String name) {
        return todoRepository.findTodoByName(name);
    }

    public Optional<Todo> findTodoById(UUID id) {
        return todoRepository.findById(id);
    }

    @Transactional
    public void deleteTodoById(UUID id) {
        todoRepository.deleteById(id);
    }

    public Iterable<Todo> getAllTodo() {
        return todoRepository.findAll();
    }

    public Todo putTodo(Todo todo) {
        return todoRepository.save(todo);
    }


    public List<Todo> getAllCompletedTodos() {
        return todoRepository.findAllByComplete(true);
    }
}