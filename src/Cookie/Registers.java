package Cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registers
 */
@WebServlet("/Registers")
public class Registers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE="text/html; charset=UTF-8";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		String email=request.getParameter("email");
		String mno =request.getParameter("mno");
		Member member=new Member(fname,lname,uname,pass,email,mno);
		RegisterDao rDao = new RegisterDao();
		String result=rDao.insert(member);
		
		response.setContentType(CONTENT_TYPE);
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>SUCCESS</title>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"reg.css\">");
		out.println("</head>");
		out.println("<body bgcolor=\"#D5F5E3 \">");
		out.println("  <img class=\"wave\" src=\"img/wave.png\">");
		response.getWriter().print(result);
		out.println("<button onclick=\"window.open('login.html');\" class=\"cta\">CLICK TO LOGIN</button>");
		out.println("</body></div></html>");
	}

}
