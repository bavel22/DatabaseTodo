package Sabri.DatabaseTodo.service;

import Sabri.DatabaseTodo.model.Todo;
import Sabri.DatabaseTodo.model.TodoNotFoundException;
import Sabri.DatabaseTodo.model.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
         return newTodo.orElseThrow(()-> new TodoNotFoundException(id));

    }

    public Todo findTodoByName(String name) {
        return todoRepository.findTodoByName(name);
    }

    public Iterable<Todo> getAllTodo() {
        return todoRepository.findAll();
    }

 //   public Iterable<Todo> getAllCompletedTodos() {
  //      return todoDao.getAllCompletedTodos();
  //  }

    public void deleteById(UUID id) {
        todoRepository.deleteById(id);
    }

 //   public void putTodo(UUID id, Todo todo) {
  //      todoDao.putTodo(id, todo);
   // }
}