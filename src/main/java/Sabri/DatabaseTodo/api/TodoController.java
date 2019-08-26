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
    public Todo addTodo(@RequestBody Todo todo) {
       return todoService.addTodo(todo);
    }

    @GetMapping
    public ResponseEntity<Iterable<Todo>> getAllTodo() {
        return new ResponseEntity<>(todoService.getAllTodo(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/name/{name}")
    public ResponseEntity<Todo> findTodoByName(@PathVariable String name) {
        return new ResponseEntity<>(todoService.findTodoByName(name), HttpStatus.OK);
    }


    @DeleteMapping( path = "/{id}")
    public void deleteById(@PathVariable UUID id) {
        todoService.deleteById(id);
    }

//    @PutMapping( path = "/{id}")
 //   public void putTodo(@PathVariable final UUID id, @RequestBody Todo todo) {
 //       todoService.putTodo(id, todo);
 //   }

    @GetMapping( path = "/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable final UUID id) {
       return new ResponseEntity<>(todoService.getTodoById(id), HttpStatus.OK);
    }

//    @GetMapping( path = "/completed")
 //   public ResponseEntity<Iterable<Todo>> getAllCompletedTodos() {
 //       return new ResponseEntity<>(todoService.getAllCompletedTodos(), HttpStatus.OK);
 //   }

}

