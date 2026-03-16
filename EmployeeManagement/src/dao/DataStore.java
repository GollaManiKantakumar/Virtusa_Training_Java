package dao;

import model.Employee;
import model.Task;

import java.util.ArrayList;

/**
 * DataStore acts as our "database" using ArrayLists.
 * No MySQL needed — all data lives in memory while the program runs.
 */
public class DataStore {

    // ----- Employee Storage -----
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static int empIdCounter = 1; // auto-increment ID

    // ----- Task Storage -----
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static int taskIdCounter = 1; // auto-increment ID

    // ==================== EMPLOYEE METHODS ====================

    public static void addEmployee(Employee emp) {
        employees.add(emp);
        System.out.println("✅ Employee added successfully! (ID: " + emp.getEmpId() + ")");
    }

    public static ArrayList<Employee> getAllEmployees() {
        return employees;
    }

    public static Employee findEmployeeById(int id) {
        for (Employee e : employees) {
            if (e.getEmpId() == id) return e;
        }
        return null;
    }

    public static boolean updateEmployee(int id, String newName, String newDept) {
        Employee emp = findEmployeeById(id);
        if (emp != null) {
            emp.setName(newName);
            emp.setDepartment(newDept);
            return true;
        }
        return false;
    }

    public static boolean deleteEmployee(int id) {
        Employee emp = findEmployeeById(id);
        if (emp != null) {
            employees.remove(emp);
            return true;
        }
        return false;
    }

    public static int nextEmpId() {
        return empIdCounter++;
    }

    // ==================== TASK METHODS ====================

    public static void addTask(Task task) {
        tasks.add(task);
        System.out.println("✅ Task assigned successfully! (Task ID: " + task.getTaskId() + ")");
    }

    public static ArrayList<Task> getAllTasks() {
        return tasks;
    }

    public static ArrayList<Task> getTasksByEmployee(int empId) {
        ArrayList<Task> result = new ArrayList<>();
        for (Task t : tasks) {
            if (t.getEmployeeId() == empId) result.add(t);
        }
        return result;
    }

    public static Task findTaskById(int id) {
        for (Task t : tasks) {
            if (t.getTaskId() == id) return t;
        }
        return null;
    }

    public static int nextTaskId() {
        return taskIdCounter++;
    }
}
