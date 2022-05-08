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


/**
 * Servlet implementation class Cumpara
 */
@WebServlet("/Cumpara")
public class Cumpara extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("idBuy");
		String nume = request.getParameter("name");
		int idauto = Integer.parseInt(id);
		String destPage = "clientpageproducts.jsp";
		
		try {
			Conturi cont = Interogari.getAllConturiByUser(nume);
			int idCont = cont.getIdCont();
			Tranzactii tranz = TranzactiiManager.insertTranzactie(idauto, idCont, 10000);
			destPage = "clientpageproducts.jsp";
			
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
