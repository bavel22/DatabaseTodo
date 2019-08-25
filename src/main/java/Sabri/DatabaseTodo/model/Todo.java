package Sabri.DatabaseTodo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity
@Embeddable
public class Todo {
    @Id
    private UUID id = UUID.randomUUID();
    private String name = "";
    private String description = "";

    private boolean complete = false;


    public Todo() {
    }

    public Todo(@JsonProperty("id") UUID id, @JsonProperty("name") String name, @JsonProperty("description") String description) {

        this.id = id;
        this.name = name;
        this.description = description;


        this.complete = complete;
    }

    public Todo(String name, String description, UUID id, boolean complete) {


        this.name = name;
        this.description = description;
        this.id = id;


        this.complete = complete;
    }


    public Todo(String name, String description) {

        this.name = name;
        this.description = description;

        this.complete = false;
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
        return Objects.equals(id, todo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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
