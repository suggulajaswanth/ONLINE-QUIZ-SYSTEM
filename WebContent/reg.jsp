<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%
String fname=request.getParameter("fname");
session.putValue("fname",fname);
String lname=request.getParameter("lname");
String uname=request.getParameter("uname");
String pass=request.getParameter("pass");
String email=request.getParameter("email");
String mno=request.getParameter("mno");
String city=request.getParameter("ct");
Class.forName("com.mysql.cj.jdbc.Driver");
java.sql.Connection con=DriverManager.getConnection("jdbc:mysql://localhost/mysql","root","jaswanth");
Statement st=con.createStatement();
ResultSet rs;
int i=st.executeUpdate("insert into users values("+ fname +"," +lname +"," + lname +","+ uname+","+pass+","+email+","+mno+","+city+","+")");
out.println("Registered");
%>
</body>
</html>

