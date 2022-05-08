package interogari;

import connectionDB.*;
import reprezentanta.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConsultantManager {
	
	public static List<Consultant> getAllRaports() throws SQLException, ClassNotFoundException {
		List<Consultant> listaRapoarte = new LinkedList();
		
		try {
			Connection con = new ConnectionDB().getConnection();
			String sql = "SELECT consultant_raport.id, idConsultant, raport, conturi.username FROM consultant_raport, conturi WHERE conturi.id = consultant_raport.idConsultant";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Consultant raport = new Consultant();
				raport.setId(rs.getInt("consultant_raport.id"));
				raport.setIdConsultant(rs.getInt("idConsultant"));
				raport.setNumeConsultant(rs.getString("conturi.username"));
				raport.setRaport(rs.getNString("raport"));
				listaRapoarte.add(raport);
			}
			
		} catch(ClassNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(Interogari.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("A fost o problema cu driver-ul");
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(Interogari.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("A fost o problema cu sql");
        } finally {
            Connection conn = new ConnectionDB().closeConnection();
        }
		
		return listaRapoarte;
	}
	
	public static List<Consultant> getAllRaportsByCons(int idCons) throws SQLException, ClassNotFoundException {
		List<Consultant> listaRapoarte = new LinkedList();
		
		try {
			Connection con = new ConnectionDB().getConnection();
			String sql = "SELECT consultant_raport.id, idConsultant, raport, conturi.username FROM consultant_raport, conturi WHERE conturi.id = consultant_raport.idConsultant AND idConsultant = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, idCons);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Consultant raport = new Consultant();
				raport.setId(rs.getInt("consultant_raport.id"));
				raport.setIdConsultant(rs.getInt("idConsultant"));
				raport.setNumeConsultant(rs.getString("conturi.username"));
				raport.setRaport(rs.getNString("raport"));
				listaRapoarte.add(raport);
			}
			
		} catch(ClassNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(Interogari.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("A fost o problema cu driver-ul");
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(Interogari.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("A fost o problema cu sql");
        } finally {
            Connection conn = new ConnectionDB().closeConnection();
        }
		
		return listaRapoarte;
	}
	
	public static Consultant insertNewRaport(int idCons, String raport) throws SQLException, ClassNotFoundException {
		
		
		try {
			Connection conn = new ConnectionDB().getConnection();
			String sqlCompetitii = "INSERT INTO consultant_raport(idConsultant, raport) VALUES(?,?)";
			PreparedStatement stmt = conn.prepareStatement(sqlCompetitii);
			stmt.setInt(1, idCons);
			stmt.setString(2, raport);
			
			stmt.executeUpdate();
			
			System.out.println("S-a efectuat inserarea");
			
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			Logger.getLogger(Interogari.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("A fost o problema cu driver-ul");
		} catch (SQLException ex) {
			ex.printStackTrace();
			Logger.getLogger(Interogari.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("A fost o problema cu sql");
		} finally {
			Connection conn = new ConnectionDB().closeConnection();
		}
		
		return null;
	}
	
	
}
