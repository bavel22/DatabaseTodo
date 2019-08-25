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
    public TodoService(@Qualifier("fakeDao") TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    public void addTodo(Todo todo) {
        System.out.println("Service");
         todoDao.addTodo(todo);


    }

    public Todo getTodo(UUID id) {
        return todoDao.getTodo(id);
    }

    public List<Todo> getAllTodo() {
        return todoDao.getAllTodo();
    }
}