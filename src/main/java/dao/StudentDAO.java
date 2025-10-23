package dao;

import Model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private String jdbcURL = "jdbc:ucanaccess://database/Students.accdb";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcURL);
    }

    // CREATE
    public void insertStudent(Student student) {
        String sql = "INSERT INTO Students (name, age, grade) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setDouble(3, student.getGrade());
            ps.executeUpdate();
            System.out.println("Студент добавлен: " + student.getName());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ (по ID)
    public Student getStudent(int id) {
        String sql = "SELECT * FROM Students WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getDouble("grade")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // READ ALL
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Students";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getDouble("grade")
                );
                students.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    // UPDATE
    public boolean updateStudent(Student student) {
        String sql = "UPDATE Students SET name = ?, age = ?, grade = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setDouble(3, student.getGrade());
            ps.setInt(4, student.getId());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Студент обновлён: ID=" + student.getId());
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // DELETE
    public boolean deleteStudent(int id) {
        String sql = "DELETE FROM Students WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Студент удалён: ID=" + id);
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}