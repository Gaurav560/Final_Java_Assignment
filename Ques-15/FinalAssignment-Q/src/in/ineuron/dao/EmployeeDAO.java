package in.ineuron.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.ineuron.dto.Employee;

public class EmployeeDAO {
    private static final String DB_URL = "jdbc:mysql:///oct_batch";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Lumia@540";
    private static final String SELECT_QUERY = "SELECT id, name, department FROM employe";

    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(SELECT_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");

                Employee employee = new Employee();
                employee.setId(id);
                employee.setName(name);
                employee.setDepartment(department);

                employees.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }
}
