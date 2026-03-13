package com.student;
import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DeleteStudentServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "delete from students where id=?"
            );

            ps.setInt(1, id);
            ps.executeUpdate();

            res.sendRedirect("viewStudents.jsp");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
