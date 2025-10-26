package crudServlet;

import connection.ConnectionDB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("Lab13/insert")
public class InsertServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        try (Connection conn = DriverManager.getConnection(ConnectionDB.DATA_BASE_URL)) {
            String sql = "INSERT INTO Students (nickname, age, grade) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, req.getParameter("nickname"));
            ps.setInt(2, Integer.parseInt(req.getParameter("age")));
            ps.setDouble(3, Double.parseDouble(req.getParameter("grade")));
            ps.executeUpdate();
            resp.sendRedirect("Success.jsp?msg=Insert");
        } catch (SQLException e) {
            e.printStackTrace(); // Для логов, можно убрать в продакшене
            resp.sendRedirect("Success.jsp?msg=Error");
        } catch (NumberFormatException e) {
            resp.sendRedirect("Success.jsp?msg=Error");
        }
    }
}