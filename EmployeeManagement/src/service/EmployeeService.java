package service;

import dao.DataStore;
import model.Employee;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeService {

    private Scanner sc = new Scanner(System.in);

    // ---- ADD EMPLOYEE ----
    public void addEmployee() {
        try {
            int id = DataStore.nextEmpId();
            System.out.println("  (Auto-generated Employee ID: " + id + ")");

            System.out.print("  Enter Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("  Enter Department: ");
            String dept = sc.nextLine();

            System.out.print("  Set Password for Employee: ");
            String pass = sc.nextLine();

            Employee emp = new Employee(id, name, dept, pass);
            DataStore.addEmployee(emp);

        } catch (Exception e) {
            System.out.println("❌ Error adding employee.");
        }
    }

    // ---- VIEW ALL EMPLOYEES ----
    public void viewEmployees() {
        ArrayList<Employee> list = DataStore.getAllEmployees();

        if (list.isEmpty()) {
            System.out.println("  No employees found.");
            return;
        }

        System.out.println("\n===== EMPLOYEE LIST =====");
        for (Employee emp : list) {
            System.out.println("  " + emp);
        }
    }

    // ---- UPDATE EMPLOYEE ----
    public void updateEmployee() {
        System.out.print("  Enter Employee ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("  Enter New Name: ");
        String name = sc.nextLine();

        System.out.print("  Enter New Department: ");
        String dept = sc.nextLine();

        if (DataStore.updateEmployee(id, name, dept)) {
            System.out.println("✅ Employee updated successfully!");
        } else {
            System.out.println("❌ Employee ID not found.");
        }
    }

    // ---- DELETE EMPLOYEE ----
    public void deleteEmployee() {
        System.out.print("  Enter Employee ID to delete: ");
        int id = sc.nextInt();

        if (DataStore.deleteEmployee(id)) {
            System.out.println("✅ Employee deleted successfully!");
        } else {
            System.out.println("❌ Employee ID not found.");
        }
    }
}
