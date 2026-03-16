package auth;

import dao.DataStore;
import model.Employee;

public class AuthService {

    // ---- Admin Login (hardcoded credentials) ----
    public boolean adminLogin(String username, String password) {
        return username.equals("admin") && password.equals("123456789");
    }

    // ---- Employee Login (checks ArrayList) ----
    public Employee employeeLogin(int id, String password) {
        Employee emp = DataStore.findEmployeeById(id);
        if (emp != null && emp.getPassword().equals(password)) {
            return emp;
        }
        return null;
    }
}
