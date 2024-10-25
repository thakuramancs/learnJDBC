import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc{
    public static void main(String[] args)
    {
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc";
        String user="root";
        String password="aman@123";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
    
        try{
        conn = DriverManager.getConnection(url, user, password);

        stmt = conn.createStatement();

        String query = "INSERT INTO students (id,name,marks) VALUES(11,'Ram',50)";
   
        int rowsAffected = stmt.executeUpdate(query);

        if (rowsAffected > 0) {
            System.out.println("Record inserted successfully! Rows affected: " + rowsAffected);
        } else {
            System.out.println("No rows were inserted.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }finally {
        // Close resources
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

            /* while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int marks = rs.getInt("marks");

                System.out.println("ID: " + id + ", Name: " + name + ", marks " + marks);
            }
        }*/
        /* finally {
            // Step 6: Close resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
    }
}