package service;

import dao.DataStore;
import model.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskService {

    private Scanner sc = new Scanner(System.in);

    // ---- ASSIGN TASK (Admin) ----
    public void assignTask() {
        try {
            sc.nextLine(); // clear buffer

            System.out.print("  Enter Task Title: ");
            String title = sc.nextLine();

            System.out.print("  Enter Description: ");
            String desc = sc.nextLine();

            System.out.print("  Enter Employee ID to assign: ");
            int empId = sc.nextInt();

            if (DataStore.findEmployeeById(empId) == null) {
                System.out.println("❌ Employee ID not found. Task not assigned.");
                return;
            }

            int taskId = DataStore.nextTaskId();
            Task task = new Task(taskId, title, desc, empId);
            DataStore.addTask(task);

        } catch (Exception e) {
            System.out.println("❌ Error assigning task.");
        }
    }

    // ---- VIEW ALL TASKS (Admin) ----
    public void viewAllTasks() {
        ArrayList<Task> list = DataStore.getAllTasks();

        if (list.isEmpty()) {
            System.out.println("  No tasks found.");
            return;
        }

        System.out.println("\n===== ALL TASKS =====");
        for (Task t : list) {
            System.out.println("  " + t);
        }
    }

    // ---- VIEW SUBMITTED FILES (Admin) ----
    public void viewSubmittedFiles() {
        ArrayList<Task> list = DataStore.getAllTasks();
        boolean found = false;

        System.out.println("\n===== SUBMITTED TASK FILES =====");
        for (Task t : list) {
            if (t.getSubmittedFile() != null) {
                System.out.println("  Task ID: " + t.getTaskId() +
                        " | Emp ID: " + t.getEmployeeId() +
                        " | Title: " + t.getTitle() +
                        " | File: " + t.getSubmittedFile());
                found = true;
            }
        }

        if (!found) System.out.println("  No submitted files yet.");
    }

    // ---- VIEW MY TASKS (Employee) ----
    public void viewMyTasks(int empId) {
        ArrayList<Task> list = DataStore.getTasksByEmployee(empId);

        if (list.isEmpty()) {
            System.out.println("  No tasks assigned to you.");
            return;
        }

        System.out.println("\n===== MY TASKS =====");
        for (Task t : list) {
            System.out.println("  " + t);
        }
    }

    // ---- SUBMIT TASK FILE (Employee) ----
    public void submitTaskFile(int empId) {
        System.out.print("  Enter Task ID to submit: ");
        int taskId = sc.nextInt();
        sc.nextLine();

        Task task = DataStore.findTaskById(taskId);

        if (task == null) {
            System.out.println("❌ Task ID not found.");
            return;
        }

        if (task.getEmployeeId() != empId) {
            System.out.println("❌ This task does not belong to you.");
            return;
        }

        System.out.print("  Enter file path (e.g. C:/files/report.pdf): ");
        String filePath = sc.nextLine();

        task.setSubmittedFile(filePath);
        task.setStatus("Completed");
        System.out.println("✅ Task submitted successfully!");
    }

    // ---- UPDATE TASK STATUS (Employee) ----
    public void updateTaskStatus(int empId) {
        System.out.print("  Enter Task ID: ");
        int taskId = sc.nextInt();

        Task task = DataStore.findTaskById(taskId);

        if (task == null) {
            System.out.println("❌ Task ID not found.");
            return;
        }

        if (task.getEmployeeId() != empId) {
            System.out.println("❌ This task does not belong to you.");
            return;
        }

        System.out.println("  1. Pending");
        System.out.println("  2. In Progress");
        System.out.println("  3. Completed");
        System.out.print("  Choose Status: ");
        int choice = sc.nextInt();

        String status;
        switch (choice) {
            case 1: status = "Pending";      break;
            case 2: status = "In Progress";  break;
            case 3: status = "Completed";    break;
            default:
                System.out.println("❌ Invalid choice.");
                return;
        }

        task.setStatus(status);
        System.out.println("✅ Task status updated to: " + status);
    }
}
