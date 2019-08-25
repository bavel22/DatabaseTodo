package Sabri.DatabaseTodo.api;




import Sabri.DatabaseTodo.model.Todo;
import Sabri.DatabaseTodo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    @PostMapping
    public void addTodo(@RequestBody Todo todo) {
        todoService.addTodo(todo);
    }

    @GetMapping
    public List<Todo> getAllTodo() {
        return todoService.getAllTodo();

    }
    @GetMapping( path = "{id}")
    public Todo getTodo(@PathVariable("id") UUID id) {
       return todoService.getTodo(id);

    }
}

