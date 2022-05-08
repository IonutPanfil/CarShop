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

import reprezentanta.*;
import interogari.*;

/**
 * Servlet implementation class SwitchToConsultant
 */
@WebServlet("/SwitchToConsultant")
public class SwitchToConsultant extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idCont = request.getParameter("idcont");
		String destPage = "adminpagelistaclienti.jsp";
		int idcont = Integer.parseInt(idCont);
		
		
		try {
			Conturi cont = Interogari.updateType(idcont, "consultant");
			
			destPage = "adminpagelistaconsultanti.jsp";
			
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