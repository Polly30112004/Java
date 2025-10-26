package crudServlet;

import connection.ConnectionDB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        try (Connection conn = DriverManager.getConnection(ConnectionDB.DATA_BASE_URL)) {
            String sql = "UPDATE Students SET nickname=?, age=?, grade=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, req.getParameter("nickname")); // Изменено с name на nickname
            ps.setInt(2, Integer.parseInt(req.getParameter("age")));
            ps.setDouble(3, Double.parseDouble(req.getParameter("grade")));
            ps.setInt(4, Integer.parseInt(req.getParameter("id")));
            ps.executeUpdate();
            resp.sendRedirect("Success.jsp?msg=Update");
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendRedirect("Success.jsp?msg=Error");
        } catch (NumberFormatException e) {
            resp.sendRedirect("Success.jsp?msg=Error");
        }
    }
}