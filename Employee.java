import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Employee {
        
    private static final String URL = "jdbc:mysql://localhost:3306/employee";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "run@123Run";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
       try {
        
          Class.forName("com.mysql.cj.jdbc.Driver"); 
       } catch (Exception e) {
        System.out.println("error loading mysql driver"+e.getMessage());
       }
        
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Display all employees");
            System.out.println("2. Insert new Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 5) {
                System.out.println("Exiting the program...");
                break;
            }

            switch (choice) {
                case 1:
                    display(connection);
                    break;
                case 2:
                    insert(connection, sc);
                    break;
                case 3:
                    delete(connection, sc);
                    break;
                case 4:
                    update(connection, sc);
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

        sc.close();
        connection.close();
    }

    public static void display(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM  employees");
        ResultSet rs = ps.executeQuery();

        System.out.println("\n--- Employee List ---");
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
            String gender = rs.getString("gender");
            String address = rs.getString("address");

            System.out.println("[Id: " + id + ", Name: " + name + ", Email: " + email +
                    ", Gender: " + gender + ", Address: " + address + "]");
        }
        rs.close();
        ps.close();
    }

    public static void insert(Connection connection, Scanner sc) throws SQLException {
        System.out.print("Enter id: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter gender (male, female, other): ");
        String gender = sc.nextLine();

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        System.out.print("Enter address: ");
        String address = sc.nextLine();

        PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO employees(id, name, gender, email, address) VALUES (?, ?, ?, ?, ?)");
        ps.setInt(1, id);
        ps.setString(2, name);
        ps.setString(3, gender);
        ps.setString(4, email);
        ps.setString(5, address);

        int rowsInserted = ps.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("New employee added successfully!");
        } else {
            System.out.println("Error adding employee with id: " + id);
        }
        ps.close();
    }

    public static void delete(Connection connection, Scanner sc) throws SQLException {
        System.out.print("Enter id of employee to delete: ");
        int id = sc.nextInt();

        PreparedStatement ps = connection.prepareStatement("DELETE FROM employees WHERE id = ?");
        ps.setInt(1, id);

        int affectedRows = ps.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Employee with id " + id + " deleted successfully.");
        } else {
            System.out.println("Error deleting employee with id: " + id);
        }
        ps.close();
    }

    public static void update(Connection connection, Scanner sc) throws SQLException {
        System.out.print("Enter id of employee to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter new name: ");
        String name = sc.nextLine();

        System.out.print("Enter new Email: ");
        String email = sc.nextLine();

        System.out.print("Enter new address: ");
        String address = sc.nextLine();

        PreparedStatement ps = connection.prepareStatement(
                "UPDATE employees SET name = ?, email = ?, address = ? WHERE id = ?");
        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, address);
        ps.setInt(4, id);

        int rowsUpdated = ps.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Employee with id " + id + " updated successfully!");
        } else {
            System.out.println("Error updating employee with id: " + id);
        }
        ps.close();
    }
}
