package servleturi;

import java.io.IOException;
import java.sql.SQLException;

import javax.el.PropertyNotFoundException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import interogari.*;
import reprezentanta.*;
import connectionDB.*;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String confirm = request.getParameter("confirm");
		
		String destPage = "signup.jsp";
		
		try {
			
			if(password.toString().equals(confirm.toString())) {
				Conturi cont = Interogari.insertNewClient(email.toString(), user.toString(), password.toString(), "client");
				destPage="login.jsp";
			} else {
				destPage="regfail.jsp";
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
			dispatcher.forward(request, response);
			
		} catch(ClassNotFoundException ex) {
			ex.printStackTrace();
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		} catch(NullPointerException ex) {
			ex.printStackTrace();
			destPage = "logfail.jsp";
		} catch(IllegalStateException ex) {
			ex.printStackTrace();
		} catch(PropertyNotFoundException ex) {
			ex.printStackTrace();
		}
		
	}
		
}


