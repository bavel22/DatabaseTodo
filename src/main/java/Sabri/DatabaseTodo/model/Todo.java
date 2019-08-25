package Sabri.DatabaseTodo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity

public class Todo {
    @Id
    private UUID id;
    private String name = "";
    private String description = "";

    private boolean complete = false;

    private State state;

    public Todo(@JsonProperty("id") UUID id, @JsonProperty("name") String name, @JsonProperty("description") String description) {

        this.name = name;
        this.description = description;
        this.id = id;
        this.state = State.NEW;
        this.complete = complete;
    }

    public Todo(String name, String description, UUID id, boolean complete) {


        this.name = name;
        this.description = description;
        this.id = id;
        this.state = State.NEW;
        this.complete = complete;
    }


    public Todo(String name, String description) {

        this.name = name;
        this.description = description;
        this.state = State.NEW;
        this.complete = false;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", complete=" + complete +
                ", state=" + state +
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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
