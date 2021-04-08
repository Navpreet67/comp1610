package javaservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BankAccountServlet
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1003L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String username = request.getParameter("username");  
	    String password = request.getParameter("password");  

	    String u = "ha07";
	    String p = "ha07";
	    
	    if(username.equals(u) && password.equals(p)){  
	    	// If user fill correct details
	        RequestDispatcher rd=request.getRequestDispatcher("main.jsp");  
	        rd.forward(request,response);  
	    }  
	    else{  
	    	// Invalid Credentials
	        out.print("You have enter wrong username or password, Please try again");  
	        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
	        rd.include(request,response);  
	    }  
	          
	    out.close(); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
