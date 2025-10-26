package crudServlet;

import connection.ConnectionDB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;

@WebServlet("/select")
public class SelectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        try (Connection conn = DriverManager.getConnection(ConnectionDB.DATA_BASE_URL)) {
            String sql = "SELECT * FROM Students WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(req.getParameter("id")));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                resp.sendRedirect("Result.jsp?id=" + rs.getInt("id") +
                        "&nickname=" + java.net.URLEncoder.encode(rs.getString("nickname"), "UTF-8") +
                        "&age=" + rs.getInt("age") +
                        "&grade=" + rs.getDouble("grade"));
            } else {
                resp.sendRedirect("Success.jsp?msg=NotFound");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resp.sendRedirect("Success.jsp?msg=Error");
        } catch (NumberFormatException e) {
            resp.sendRedirect("Success.jsp?msg=Error");
        }
    }
}