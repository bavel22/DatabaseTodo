package Sabri.DatabaseTodo.model;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;



@Repository
public interface TodoRepository extends CrudRepository<Todo, UUID> {



}