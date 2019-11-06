package Sabri.DatabaseTodo.api;


import Sabri.DatabaseTodo.model.Todo;
import Sabri.DatabaseTodo.model.TodoNotFoundException;
import Sabri.DatabaseTodo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/todos")
public class TodoController {

    // This is Spring boot JPA, MVC, Hibernate?, RESTful API supporting REACT/Redux front end

    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    //CREATE
    // works both on front end and back end


    @PostMapping
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }

    // GETS all
    // works on back and front end


    @GetMapping
    public ResponseEntity<Iterable<Todo>> getAllTodo() {
        return new ResponseEntity<>(todoService.getAllTodo(), HttpStatus.OK);
    }

    // GETS by name
    // only works on back end


    @RequestMapping(method = RequestMethod.GET, path = "/name/{name}")
    public ResponseEntity<Todo> findTodoByName(@PathVariable String name) {
        return new ResponseEntity<>(todoService.findTodoByName(name), HttpStatus.OK);
    }

    // GETS by id
    // only works on back end


    @GetMapping(path = "/{id}")
    public ResponseEntity<Todo> findTodoById(@PathVariable final UUID id) {
        System.out.println(id);
        return ResponseEntity.ok(todoService.findTodoById(id).orElseThrow());

    }


    // DELETE by id
    // works on both front and back end


        @DeleteMapping(path = "/{id}")
        public void deleteTodoById(@PathVariable UUID id) {
            System.out.println(id);
            todoService.deleteTodoById(id);
            System.out.println(id);

    }


    // UPDATE by id
    // works on both front end and back end

   @PutMapping( path = "/{id}")
      public void putTodo(@PathVariable final UUID id, @RequestBody Todo todo) {
        todoService.putTodo(todo);
      }


    @GetMapping( path = "/completed")
       public ResponseEntity<Iterable<Todo>> getAllCompletedTodos() {
          return new ResponseEntity<>(todoService.getAllCompletedTodos(), HttpStatus.OK);
       }

}

