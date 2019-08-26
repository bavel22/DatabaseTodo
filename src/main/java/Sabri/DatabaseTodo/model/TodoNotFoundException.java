package Sabri.DatabaseTodo.model;

import java.util.UUID;

public class TodoNotFoundException extends RuntimeException {


    public TodoNotFoundException(UUID id) {
        super("Todo with id " + id + " was not found");
    }
}
