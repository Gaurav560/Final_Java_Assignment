package ineuron;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchUpdate {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/mydatabase";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "Lumia@540";
    private static final String INSERT_QUERY = "INSERT INTO student (sid, sname) VALUES (?, ?)";

    public static void main(String[] args) {
        String inputFile = "input.txt";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {

            // Read input data from file
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    String column1Value = data[0];
                    String column2Value = data[1];

                    // Set parameter values
                    statement.setString(1, column1Value);
                    statement.setString(2, column2Value);

                    // Add the statement to the batch
                    statement.addBatch();
                }
            }

            // Execute the batch update
            int[] updateCounts = statement.executeBatch();

            // Process the update counts
            for (int count : updateCounts) {
                System.out.println("Updated " + count + " rows.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

