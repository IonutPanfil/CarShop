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
import javax.servlet.http.HttpSession;

import reprezentanta.*;
import interogari.*;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		String destPage = "login.jsp";
		
		try {
		Conturi cont = Interogari.getAllConturiByParameters(user, password);
		
		
		
		if(cont == null) {
			destPage = "logfail.jsp";
			
		} else{
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setAttribute("email", cont.getEmail());
			session.setAttribute("tip", cont.getTip());
			if(cont.getTip().contains("admin")) {
				destPage = "adminpageindex.jsp";
			}
			
			if(cont.getTip().contains("client")) {
				destPage = "clientpageindex.jsp";
			}
			if(cont.getTip().contains("consultant")) {
				destPage = "consultantpageindex.jsp";
			}
			
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

