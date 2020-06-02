package Cookie;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class RegisterDao {
	private String dburl="jdbc:mysql://localhost/userdb";
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
    public String insert(Member member) {
    	loadDriver(dbdriver);
    	Connection con=getConnection();
    	String result="REGISTRATION SUCCESSFULL";
    	String sql="insert into userdb.member values(?,?,?,?,?,?)";
    	try {
    	PreparedStatement ps=con.prepareStatement(sql);
    	ps.setString(1,member.getFname());
    	ps.setString(2,member.getLname());
    	ps.setString(3,member.getUname());
    	ps.setString(4,member.getPass());
    	ps.setString(5,member.getEmail());
    	ps.setString(6,member.getMno());
    	ps.executeUpdate();
    	}
    	catch(SQLException e){
    		e.printStackTrace();
    		result="NOT REGISTERED";
    	}
    	
    	
    	return result;
    }
}
