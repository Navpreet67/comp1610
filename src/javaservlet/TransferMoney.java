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
@WebServlet("/transfer-amount")
public class TransferMoney extends HttpServlet {
	private static final long serialVersionUID = 1004L;
	private final BankAccountBean from = new BankAccountBean();
	private final BankAccountBean to = new BankAccountBean();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransferMoney() {
        super();
        from.setBalance(0);
        to.setBalance(0);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();
	    
		String account_type = request.getParameter("account_type");
		String account_id = request.getParameter("account_number");
		String amount = request.getParameter("amount_to_transfer");
		
		if(account_type.isEmpty()) {
			out.print("Please selet account type");  
	        RequestDispatcher rd=request.getRequestDispatcher("main.jsp");  
	        rd.include(request,response); 
		} else if(amount.isEmpty()) {
			out.print("Please enter a specific amount to send");  
	        RequestDispatcher rd=request.getRequestDispatcher("main.jsp");  
	        rd.include(request,response);
		} else if(account_id.isEmpty()) {
			out.print("Please enter account number");  
	        RequestDispatcher rd=request.getRequestDispatcher("main.jsp");  
	        rd.include(request,response); 
		} else {
			from.withdraw(Integer.parseInt(amount));
			to.deposit(Integer.parseInt(amount));
			// functioanlity to add account details to db
			// [Pending] - getting some issue on connection 
			
			out.print("Amount Transfered");  
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

