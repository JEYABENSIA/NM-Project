<%@ page import="java.sql.*" %>
<%@ page import="com.student.DBConnection" %>

<html>
<body>

<h2>Student List</h2>

<table border="1">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Department</th>
    <th>Delete</th>
</tr>

<%
Connection con = DBConnection.getConnection();
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("select * from students");

while(rs.next()) {
%>

<tr>
    <td><%= rs.getInt("id") %></td>
    <td><%= rs.getString("name") %></td>
    <td><%= rs.getString("dept") %></td>
    <td>
        <a href="DeleteStudentServlet?id=<%= rs.getInt("id") %>">Delete</a>
    </td>
</tr>

<%
}
%>

</table>

</body>
</html>
