package com.student;
import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String name = req.getParameter("name");
        String dept = req.getParameter("dept");

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "insert into students(name, dept) values(?,?)"
            );

            ps.setString(1, name);
            ps.setString(2, dept);

            ps.executeUpdate();

            res.sendRedirect("viewStudents.jsp");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
