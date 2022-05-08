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
 * Servlet implementation class InsertAuto
 */
@WebServlet("/InsertAuto")
public class InsertAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String model = request.getParameter("modelAdd");
		String year = request.getParameter("yearAdd");
		String capacity = request.getParameter("capacityAdd");

		String destPage = "adminpageindex.jsp";
		
		try {
			Auto autom = AutoManager.insertNewAuto(model, year, capacity);
			destPage = "adminpageindex.jsp";
			
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
