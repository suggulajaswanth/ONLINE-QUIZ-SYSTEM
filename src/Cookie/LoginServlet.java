package Cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class LoginServlet extends HttpServlet{
private static final String CONTENT_TYPE="text/html; charset=UTF-8";
private static Connection conn;
private String name;
private String password;
	private static final  String dburl="jdbc:mysql://localhost/userdb";
	private static final String dbuname="root";
	private static final String dbpassword ="jaswanth";
public void init(ServletConfig config)throws ServletException{
	super.init(config);
}
public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
	response.setContentType(CONTENT_TYPE);
	PrintWriter out=response.getWriter();
	
	name=request.getParameter("name");
	password=request.getParameter("password");
	boolean result=checkPassword(name,password);
	out.println("<html>");
	out.println("<body>");
	if (result==true) {
		out.println("LOGIN SUCCESSFULL");
		response.sendRedirect("/ONLINE_QUIZ_/mainpage.html");
		
	}
	else {
		out.println("PLEASE CHECK YOUR LOGIN DETAILS");
	}
	out.println("</body></html>");
	out.close();
	
}
protected boolean checkPassword(String user,String password) {
	String correctPassword=null;
	try {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(dburl,dbuname,dbpassword);
			conn.setAutoCommit(true);
		}
		catch (Exception e) {
			System.out.println("Connection failed:" +e.toString());
			
		}
		Statement statement=conn.createStatement();
		statement.executeQuery("select pass from member where uname='"+user+"'");
		ResultSet rs=statement.getResultSet();
		if(rs.next()) {
			correctPassword=rs.getString(1);
			
		}
		statement.close();
		if(correctPassword.equals(password)) {
			return true;
		}
		else {
			return false;
		}
	}
	catch(Exception e) {
		System.out.println("Exception in verifyPassword()="+e.toString());
		return false;
	}
}

}
 