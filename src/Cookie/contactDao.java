package Cookie;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class contactDao {
	private String dburl="jdbc:mysql://localhost/contact";
	private String dbuname="root";
	private String dbpassword ="jaswanth";
	private String dbdriver ="com.mysql.cj.jdbc.Driver";
	public void loadDriver(String dbDriver) {
		try {
		Class.forName(dbDriver);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			
		}
	}
	public Connection getConnection()
	{
		Connection con=null;
		try {
			
		    con=DriverManager.getConnection(dburl,dbuname,dbpassword);
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		return con;
		
		
	}
    public String insert(contact contact) {
    	loadDriver(dbdriver);
    	Connection con=getConnection();
    	String result="THANK YOU FOR CONTACTING US";
    	String sql="insert into contact.contact values(?,?,?,?)";
    	try {
    	PreparedStatement ps=con.prepareStatement(sql);
    	ps.setString(1,contact.getUname());
    	ps.setString(2,contact.getEmail());
    	ps.setString(3,contact.getSub());
    	ps.setString(4,contact.getMsg());
    	ps.executeUpdate();
    	}
    	catch(SQLException e){
    		e.printStackTrace();
    		result="YOUR CONTACT FORM IS NOT SUBMMITED";
    	}
    	
    	
    	return result;
    }
}
