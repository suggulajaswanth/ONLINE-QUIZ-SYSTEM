package Cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Contacts
 */
@WebServlet("/Contacts")
public class Contacts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE="text/html; charset=UTF-8";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contacts() {
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
		// TODO Auto-generated method stub
		String uname=request.getParameter("uname");
		String email=request.getParameter("email");
		String sub=request.getParameter("sub");
		String msg=request.getParameter("msg");
		contact contact=new contact(uname,email,sub,msg);
		contactDao cDao = new contactDao();
		String result=cDao.insert(contact);
		response.setContentType(CONTENT_TYPE);
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>THANK-YOU</title>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"thank.css\">");
		out.println("</head>");
		out.println("<body bgcolor=\"grey \">");
		out.println("<div class=\"bgimage\">");
		out.println("<img src=\"img/thanks.png\" width=\"8%\">");
		response.getWriter().print(result);
		out.println("<button onclick=\"window.open('mainpage.html');\" class=\"cta\">CLICK TO GO TO MAIN PAGE</button>");
		out.println("</body></div></html>");
		
	}

}
