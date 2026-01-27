import java.sql.*;

public class StudentDAO {

    public void addStudent(Student s) {
        String query = "INSERT INTO students(name, email, course) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getCourse());

            ps.executeUpdate();
            System.out.println("Student added successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewStudents() {
        String query = "SELECT * FROM students";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            System.out.println("\n--- Student Records ---");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getString("email") + " | " +
                    rs.getString("course")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(int id, String course) {
        String query = "UPDATE students SET course=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, course);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Student updated successfully!");
            else
                System.out.println("Student not found!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        String query = "DELETE FROM students WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Student deleted successfully!");
            else
                System.out.println("Student not found!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}