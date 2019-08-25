package Sabri.DatabaseTodo.api;




import Sabri.DatabaseTodo.model.Todo;
import Sabri.DatabaseTodo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
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
    public UUID addTodo(@RequestBody Todo todo) {
       return todoService.addTodo(todo);
    }

    @GetMapping
    public ResponseEntity<Iterable<Todo>> getAllTodo() {
        return new ResponseEntity<>(todoService.getAllTodo(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/name/{name}")
    public ResponseEntity<List<Todo>> getTodobyName(@PathVariable String name) {
        return new ResponseEntity<>(todoService.getTodoByName(name), HttpStatus.OK);
    }


    @DeleteMapping( path = "/{id}")
    public void deleteTodo(@PathVariable final UUID id) {
        todoService.deleteTodo(id);
    }

    @PutMapping( path = "/{id}")
    public void putTodo(@PathVariable final UUID id, @RequestBody Todo todo) {
        todoService.putTodo(id, todo);
    }

    // @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    @GetMapping( path = "/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable final UUID id) {
       return new ResponseEntity<>(todoService.getTodoById(id), HttpStatus.OK);
    }

    @GetMapping( path = "/completed")
    public ResponseEntity<Iterable<Todo>> getAllCompletedTodos() {
        return new ResponseEntity<>(todoService.getAllCompletedTodos(), HttpStatus.OK);
    }

}

