package com.company.models;

import com.company.exceptions.ElementExistsException;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Task implements Comparable<Task> {

    private static int id = 0;

    //instance variables
    private int taskId;
    private Task supertask;
    private Set<Task> subtasks;
    private String title;
    private LocalDateTime dueDate;
    private String description;
    private int taskOwnerId;
    private int taskResponsibleId;

    //constructors
    public Task(String title, LocalDateTime dueDate, String description, int taskOwnerId, int taskResponsibleId) {
        this.taskId = getStaticId();
        this.supertask = null;
        this.subtasks = new Set<>();
        this.title = title;
        this.dueDate = dueDate;
        this.description = description;
        this.taskOwnerId = taskOwnerId;
        this.taskResponsibleId = taskResponsibleId;
    }

    //create
    public void addSubtask(Task subtask) {
        try {
            subtask.setSupertask(this);
            subtasks.add(subtask);
        } catch (ElementExistsException e) {
            System.out.println("Subtask already exists");
        }
    }

    //read
    public Task getSupertask() {
        return supertask;
    }
    public String getTitle() {
        return title;
    }
    public LocalDateTime getDueDate() {
        return dueDate;
    }
    public String getDescription() {
        return description;
    }
    public int getTaskOwnerId() {
        return taskOwnerId;
    }
    public int getTaskResponsibleId() {
        return taskResponsibleId;
    }

    public Task getSubtask(int index) {
        return subtasks.getData(index);
    }

    public Set<Task> getSubtasksSet() {
        return subtasks;
    }

    public String[] getSubtasks() {
        int size = subtasks.size();
        String[] subtasksList = new String[size];
        for (int i = 0; i < size; i++) {
            subtasksList[i] = subtasks.getData(i).getTitle();
        }
        return subtasksList;
    }

    private int getStaticId() {
        id++;
        return id - 1;
    }


    //update
    public void setSupertask(Task supertask) {
        this.supertask = supertask;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setTaskOwnerId(int taskOwnerId) {
        this.taskOwnerId = taskOwnerId;
    }
    public void setTaskResponsibleId(int taskResponsibleId) {
        this.taskResponsibleId = taskResponsibleId;
    }

    public void set(Task task) {
        this.supertask = task.supertask;
        this.subtasks = task.subtasks;
        this.title = task.title;
        this.dueDate = task.dueDate;
        this.description = task.description;
        this.taskOwnerId = task.taskOwnerId;
        this.taskResponsibleId = task.taskResponsibleId;
    }

    //delete
    public void removeSubtask(int index) {
        subtasks.remove(index);
    }

    //override

    @Override
    public boolean equals(Object o) {
        Task task = (Task) o;
        return this.supertask.equals(task.supertask) &&
                this.title.equals(task.title) &&
                this.dueDate.equals(task.dueDate) &&
                this.description.equals(task.description) &&
                this.taskOwnerId == task.taskOwnerId &&
                this.taskResponsibleId == task.taskResponsibleId;
    }

    @Override
    public int compareTo(Task o) {
        return 0;
    }
}
