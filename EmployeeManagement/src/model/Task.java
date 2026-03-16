package model;

public class Task {

    private int taskId;
    private String title;
    private String description;
    private int employeeId;
    private String status;
    private String submittedFile; // stores file path if submitted

    public Task(int taskId, String title, String description, int employeeId) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.employeeId = employeeId;
        this.status = "Pending";
        this.submittedFile = null;
    }

    public int getTaskId()          { return taskId; }
    public String getTitle()        { return title; }
    public String getDescription()  { return description; }
    public int getEmployeeId()      { return employeeId; }
    public String getStatus()       { return status; }
    public String getSubmittedFile(){ return submittedFile; }

    public void setStatus(String status)            { this.status = status; }
    public void setSubmittedFile(String filePath)   { this.submittedFile = filePath; }

    @Override
    public String toString() {
        return "Task ID: " + taskId +
               " | Emp ID: " + employeeId +
               " | Title: " + title +
               " | Status: " + status +
               (submittedFile != null ? " | File: " + submittedFile : "");
    }
}
