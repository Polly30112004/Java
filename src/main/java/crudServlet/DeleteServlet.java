package crudServlet;

import connection.ConnectionDB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        try (Connection conn = DriverManager.getConnection(ConnectionDB.DATA_BASE_URL)) {
            String sql = "DELETE FROM Students WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(req.getParameter("id")));
            ps.executeUpdate();
            resp.sendRedirect("Success.jsp?msg=Delete");
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendRedirect("Success.jsp?msg=Error");
        } catch (NumberFormatException e) {
            resp.sendRedirect("Success.jsp?msg=Error");
        }
    }
}