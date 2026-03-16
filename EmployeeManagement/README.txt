============================================
  Smart Employee Management System
  (No Database Version)
============================================

WHAT IS THIS?
-------------
This is a console-based Java mini project.
It manages Employees and Tasks using ArrayList (no MySQL/JDBC needed).
All data is stored in memory while the program runs.


PROJECT STRUCTURE
-----------------
src/
 ├── Main.java                  --> Entry point (all menus here)
 ├── model/
 │   ├── Employee.java          --> Employee data (id, name, dept, password)
 │   └── Task.java              --> Task data (id, title, desc, status, file)
 ├── auth/
 │   └── AuthService.java       --> Admin + Employee login logic
 ├── dao/
 │   └── DataStore.java         --> ⭐ Our "database" using ArrayList
 └── service/
     ├── EmployeeService.java   --> Add/View/Update/Delete employees
     └── TaskService.java       --> Assign/View/Submit/Update tasks


HOW TO RUN (IntelliJ IDEA)
--------------------------
1. Open IntelliJ IDEA
2. File → Open → select the EmployeeManagement folder
3. Right-click src/Main.java → Run 'Main'
4. No extra JAR files or MySQL needed!


HOW TO COMPILE & RUN (Command Line)
-------------------------------------
Step 1: Go into the src folder
  cd EmployeeManagement/src

Step 2: Compile all files
  javac -d ../out model/*.java auth/*.java dao/*.java service/*.java Main.java

Step 3: Run from out folder
  cd ../out
  java Main


LOGIN CREDENTIALS
-----------------
Admin:
  Username : admin
  Password : 123456789

Employee:
  ID       : (auto-generated when admin adds them)
  Password : (set by admin when adding)


FEATURES
--------
ADMIN can:
  ✅ Add Employee
  ✅ View All Employees
  ✅ Update Employee (name/department)
  ✅ Delete Employee
  ✅ Assign Task to Employee
  ✅ View All Tasks
  ✅ View Submitted Files

EMPLOYEE can:
  ✅ View My Tasks
  ✅ Submit Task File (enter file path)
  ✅ Update Task Status (Pending / In Progress / Completed)


NOTE: Data is lost when program stops (no file/database saving).
This is a mini project for learning Java OOP concepts.
============================================
