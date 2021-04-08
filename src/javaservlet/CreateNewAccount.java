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
@WebServlet("/create-account")
public class CreateNewAccount extends HttpServlet {
	private static final long serialVersionUID = 1002L;
	private final BankAccountBean account = new BankAccountBean();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewAccount() {
        super();
        account.setBalance(0);
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();
	    
		String account_type = request.getParameter("account_type");
		String amount = request.getParameter("amount");
		
		if(account_type.isEmpty()) {
			out.print("Account type is required fieled");  
	        RequestDispatcher rd=request.getRequestDispatcher("main.jsp");  
	        rd.include(request,response); 
		} else if(amount.isEmpty()) {
			out.print("Amount is required fieled");  
	        RequestDispatcher rd=request.getRequestDispatcher("main.jsp");  
	        rd.include(request,response);
		} else {
			account.setAccountType(account_type);
			account.setBalance(Integer.parseInt(amount));
			
			// functioanlity to add account details to db
			// [Pending] - getting some issue on connection 
			
			out.print("New Account Created");  
	        RequestDispatcher rd=request.getRequestDispatcher("main.jsp");  
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

