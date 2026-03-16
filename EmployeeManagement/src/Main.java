import auth.AuthService;
import model.Employee;
import service.EmployeeService;
import service.TaskService;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AuthService    authService    = new AuthService();
        EmployeeService employeeService = new EmployeeService();
        TaskService    taskService    = new TaskService();

        System.out.println("=========================================");
        System.out.println("  Smart Employee Management System");
        System.out.println("=========================================");

        while (true) {

            System.out.println("\n===== MAIN MENU =====");
            System.out.println("  1. Admin Login");
            System.out.println("  2. Employee Login");
            System.out.println("  3. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                // ==================== ADMIN LOGIN ====================
                case 1:
                    System.out.print("Username: ");
                    String uname = sc.next();
                    System.out.print("Password: ");
                    String upass = sc.next();

                    if (authService.adminLogin(uname, upass)) {
                        System.out.println("✅ Admin Login Successful!");

                        boolean adminRunning = true;
                        while (adminRunning) {

                            System.out.println("\n===== ADMIN MENU =====");
                            System.out.println("  1. Add Employee");
                            System.out.println("  2. View All Employees");
                            System.out.println("  3. Update Employee");
                            System.out.println("  4. Delete Employee");
                            System.out.println("  5. Assign Task to Employee");
                            System.out.println("  6. View All Tasks");
                            System.out.println("  7. View Submitted Files");
                            System.out.println("  8. Logout");
                            System.out.print("Enter Choice: ");

                            int adminChoice = sc.nextInt();

                            switch (adminChoice) {
                                case 1: employeeService.addEmployee();      break;
                                case 2: employeeService.viewEmployees();    break;
                                case 3: employeeService.updateEmployee();   break;
                                case 4: employeeService.deleteEmployee();   break;
                                case 5: taskService.assignTask();           break;
                                case 6: taskService.viewAllTasks();         break;
                                case 7: taskService.viewSubmittedFiles();   break;
                                case 8: adminRunning = false;
                                        System.out.println("  Logged out.");break;
                                default: System.out.println("❌ Invalid choice.");
                            }
                        }

                    } else {
                        System.out.println("❌ Invalid Admin Credentials!");
                    }
                    break;

                // ==================== EMPLOYEE LOGIN ====================
                case 2:
                    System.out.print("Employee ID: ");
                    int empId = sc.nextInt();
                    System.out.print("Password: ");
                    String empPass = sc.next();

                    Employee loggedEmp = authService.employeeLogin(empId, empPass);

                    if (loggedEmp != null) {
                        System.out.println("✅ Welcome, " + loggedEmp.getName() + "!");

                        boolean empRunning = true;
                        while (empRunning) {

                            System.out.println("\n===== EMPLOYEE MENU =====");
                            System.out.println("  1. View My Tasks");
                            System.out.println("  2. Submit Task File");
                            System.out.println("  3. Update Task Status");
                            System.out.println("  4. Logout");
                            System.out.print("Enter Choice: ");

                            int empChoice = sc.nextInt();

                            switch (empChoice) {
                                case 1: taskService.viewMyTasks(empId);          break;
                                case 2: taskService.submitTaskFile(empId);       break;
                                case 3: taskService.updateTaskStatus(empId);     break;
                                case 4: empRunning = false;
                                        System.out.println("  Logged out.");     break;
                                default: System.out.println("❌ Invalid choice.");
                            }
                        }

                    } else {
                        System.out.println("❌ Invalid Employee Credentials!");
                    }
                    break;

                // ==================== EXIT ====================
                case 3:
                    System.out.println("Goodbye! 👋");
                    System.exit(0);

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }
}
