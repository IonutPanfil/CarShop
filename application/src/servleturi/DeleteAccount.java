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

import interogari.Interogari;
import reprezentanta.Conturi;

/**
 * Servlet implementation class DeleteAccount
 */
@WebServlet("/DeleteAccount")
public class DeleteAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idCont = request.getParameter("idcont-stergere");
		String destPage = "adminpagelistaclienti.jsp";
		int idcont = Integer.parseInt(idCont);
		
		try {
			Conturi cont = Interogari.stergeCont(idcont);
			
			destPage = "adminpagelistaclienti.jsp";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
			dispatcher.forward(request, response);
			
			
		} catch(ClassNotFoundException ex) {
			ex.printStackTrace();
			
		} catch(SQLException ex) {
			ex.printStackTrace();
		} catch(NullPointerException ex) {
			ex.printStackTrace();
		} catch(IllegalStateException ex) {
			ex.printStackTrace();
		} catch(PropertyNotFoundException ex) {
			ex.printStackTrace();
		}
		
		
	}

}
