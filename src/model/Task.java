package model;

public class Task {

    double targetHours;
    double hoursSoFar;
    boolean isComplete;
    private String name;

    public Task(String name, double targetHours) {
        this.name = name;
        this.targetHours = targetHours;
        hoursSoFar = 0;
        isComplete = false;
    }

    public double getTargetHours() {
        return targetHours;
    }

    public void setTargetHours(double targetHours) {
        this.targetHours = targetHours;
    }

    public double getHoursSoFar() {
        return hoursSoFar;
    }

    public void setHoursSoFar(double hoursSoFar) {
        this.hoursSoFar = hoursSoFar;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void taskComplete() {
        //call celebration
        this.isComplete = (hoursSoFar >= targetHours);
    }
}
