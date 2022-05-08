package interogari;

import connectionDB.*;
import reprezentanta.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;


//CONTURI MANAGER
public class Interogari {
	public static List<Conturi> getAllConturiByTip(String tip) throws SQLException, ClassNotFoundException {
		List<Conturi> conturi = new LinkedList();
		try {
			Connection conn = new ConnectionDB().getConnection();
			String sqlCompetitii = "select id, username, passworD, email, tip from conturi where tip = ?";
			PreparedStatement stmt = conn.prepareStatement(sqlCompetitii);
			stmt.setString(1, tip);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Conturi cont = new Conturi();
				cont.setIdCont(rs.getInt("id"));
				cont.setUsername(rs.getString("username"));
				cont.setPassword(rs.getString("password"));
				cont.setEmail(rs.getString("email"));
				cont.setTip(rs.getString("tip"));
				conturi.add(cont);
			}
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
		return conturi;

	}
	
	
	public static Conturi getAllConturiByParameters(String user, String password) throws SQLException, ClassNotFoundException {
		Conturi cont = null;
		try {
			Connection conn = new ConnectionDB().getConnection();
			String sqlCompetitii = "select id, username, passworD, email, tip from conturi where username = ? and passworD = ?";
			PreparedStatement stmt = conn.prepareStatement(sqlCompetitii);
			stmt.setString(1, user);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				cont = new Conturi();
				cont.setIdCont(rs.getInt("id"));
				cont.setUsername(rs.getString("username"));
				cont.setPassword(rs.getString("password"));
				cont.setEmail(rs.getString("email"));
				cont.setTip(rs.getString("tip"));
			}
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
		return cont;

	}
	
	
	public static Conturi getAllConturiByUser(String user) throws SQLException, ClassNotFoundException {
		Conturi cont = null;
		try {
			Connection conn = new ConnectionDB().getConnection();
			String sqlCompetitii = "select id, username, passworD, email, tip from conturi where username = ?";
			PreparedStatement stmt = conn.prepareStatement(sqlCompetitii);
			stmt.setString(1, user);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				cont = new Conturi();
				cont.setIdCont(rs.getInt("id"));
				cont.setUsername(rs.getString("username"));
				cont.setPassword(rs.getString("password"));
				cont.setEmail(rs.getString("email"));
				cont.setTip(rs.getString("tip"));
			}
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
		return cont;

	}
	
	
	public static Conturi insertNewClient(String email, String user, String password, String tip) throws SQLException, ClassNotFoundException {
		Conturi cont = null;
		
		try {
			Connection conn = new ConnectionDB().getConnection();
			String sqlCompetitii = "INSERT INTO conturi(conturi.username, conturi.passworD, conturi.email, conturi.tip) VALUES(?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sqlCompetitii);
			stmt.setString(1, user);
			stmt.setString(2, password);
			stmt.setString(3, email);
			stmt.setString(4, tip);
			
			stmt.executeUpdate();
			
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
	
	public static Conturi updateParola(int idClient, String parolaNoua) throws SQLException, ClassNotFoundException {
		Conturi cont = null;
		
		try {
			Connection conn = new ConnectionDB().getConnection();
			String sqlCompetitii = "UPDATE conturi SET passworD = ? WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sqlCompetitii);
			stmt.setString(1, parolaNoua);
			stmt.setInt(2, idClient);
			
			stmt.executeUpdate();
			
			System.out.println("S-a efectuat modificarea");
			
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
	
	public static Conturi updateType(int idClient, String tipNou) throws SQLException, ClassNotFoundException {
		Conturi cont = null;
		
		try {
			Connection conn = new ConnectionDB().getConnection();
			String sqlCompetitii = "UPDATE conturi SET tip = ? WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sqlCompetitii);
			stmt.setString(1, tipNou);
			stmt.setInt(2, idClient);
			
			stmt.executeUpdate();
			
			System.out.println("S-a efectuat modificarea");
			
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
	
	public static Conturi stergeCont(int idClient) throws SQLException, ClassNotFoundException {
		Conturi cont = null;
		
		try {
			Connection conn = new ConnectionDB().getConnection();
			String sqlCompetitii = "DELETE FROM conturi WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sqlCompetitii);
			stmt.setInt(1, idClient);
			
			stmt.executeUpdate();
			
			System.out.println("S-a efectuat modificarea");
			
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
