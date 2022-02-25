package mainPackage;

import java.util.Collections;

public class Task {
    private String name;
    private String description;
    private String deadline;
    private int priorityLevel;
    private String category;
    private String status;

    public Task(String name, String description, String deadline, int priorityLevel, String category, String status) {
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.priorityLevel = priorityLevel;
        this.category = category;
        this.status = status;
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

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", deadline='" + deadline + '\'' +
                ", priorityLevel=" + priorityLevel +
                ", category='" + category + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}