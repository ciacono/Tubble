package model;

import java.util.ArrayList;
import java.util.List;

public class Activity {

    private List<Task> tasks;

    public Activity() {
        this.tasks = new ArrayList<>();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }
}
