package Sabri.DatabaseTodo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Todo {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;


    private String name = "";

    private String description = "";

    private boolean complete = false;

    public Todo() {
    }

    public Todo(String name, String description) {

        this.name = name;
        this.description = description;

    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", complete=" + complete +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return complete == todo.complete &&
                Objects.equals(id, todo.id) &&
                Objects.equals(name, todo.name) &&
                Objects.equals(description, todo.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, complete);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}