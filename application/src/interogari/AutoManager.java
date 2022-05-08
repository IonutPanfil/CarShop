package interogari;

import connectionDB.*;
import reprezentanta.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AutoManager {
	
	
	public static List<Auto> getAllAuto() throws SQLException, ClassNotFoundException {
		List<Auto> listaMasini = new LinkedList();
		
		try {
			Connection con = new ConnectionDB().getConnection();
			String sql = "SELECT id, denumire, anFab, capacitateMotor FROM auto";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Auto masina = new Auto();
				masina.setId(rs.getInt("id"));
				masina.setDenumire(rs.getString("denumire"));
				masina.setAnFab(rs.getString("anFab"));
				masina.setCapacitateMotor(rs.getString("capacitateMotor"));
				listaMasini.add(masina);
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
		
		return listaMasini;
	}
	
	public static List<Auto> getAllAutoByDenumire(String den) throws SQLException, ClassNotFoundException {
		List<Auto> listaMasini = new LinkedList();
		
		try {
			Connection con = new ConnectionDB().getConnection();
			String sql = "SELECT id, denumire, anFab, capacitateMotor FROM auto  WHERE denumire = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, den);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Auto masina = new Auto();
				masina.setId(rs.getInt("id"));
				masina.setDenumire(rs.getString("denumire"));
				masina.setAnFab(rs.getString("anFab"));
				masina.setCapacitateMotor(rs.getString("capacitateMotor"));
				listaMasini.add(masina);
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
		
		return listaMasini;
	}
	
	public static List<Auto> getAllAutoByAnFab(String an) throws SQLException, ClassNotFoundException {
		List<Auto> listaMasini = new LinkedList();
		
		try {
			Connection con = new ConnectionDB().getConnection();
			String sql = "SELECT id, denumire, anFab, capacitateMotor FROM auto  WHERE anFab = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, an);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Auto masina = new Auto();
				masina.setId(rs.getInt("id"));
				masina.setDenumire(rs.getString("denumire"));
				masina.setAnFab(rs.getString("anFab"));
				masina.setCapacitateMotor(rs.getString("capacitateMotor"));
				listaMasini.add(masina);
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
		
		return listaMasini;
	}
	
	public static List<Auto> getAllAutoByCapacitate(String capacitate) throws SQLException, ClassNotFoundException {
		List<Auto> listaMasini = new LinkedList();
		
		try {
			Connection con = new ConnectionDB().getConnection();
			String sql = "SELECT id, denumire, anFab, capacitateMotor FROM auto  WHERE capacitateMotor = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, capacitate);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Auto masina = new Auto();
				masina.setId(rs.getInt("id"));
				masina.setDenumire(rs.getString("denumire"));
				masina.setAnFab(rs.getString("anFab"));
				masina.setCapacitateMotor(rs.getString("capacitateMotor"));
				listaMasini.add(masina);
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
		
		return listaMasini;
	}
	
	public static Auto insertNewAuto(String denumire, String an, String capacitate) throws SQLException, ClassNotFoundException {
		Conturi cont = null;
		
		try {
			Connection conn = new ConnectionDB().getConnection();
			String sqlCompetitii = "INSERT INTO auto(auto.denumire, auto.anFab, auto.capacitateMotor) VALUES(?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sqlCompetitii);
			stmt.setString(1, denumire);
			stmt.setString(2, an);
			stmt.setString(3, capacitate);
			
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
	
	public static Auto updateAutoDenumire(String denumireVeche, String denumireNoua) throws SQLException, ClassNotFoundException {
		Conturi cont = null;
		
		try {
			Connection conn = new ConnectionDB().getConnection();
			String sqlCompetitii = "UPDATE auto SET denumire = ? WHERE denumire = ?";
			PreparedStatement stmt = conn.prepareStatement(sqlCompetitii);
			stmt.setString(1, denumireNoua);
			stmt.setString(2, denumireVeche);
			
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
	
	public static Auto updateAutoAn(String denumire, String anNou) throws SQLException, ClassNotFoundException {
		Conturi cont = null;
		
		try {
			Connection conn = new ConnectionDB().getConnection();
			String sqlCompetitii = "UPDATE auto SET anFab = ? WHERE denumire = ?";
			PreparedStatement stmt = conn.prepareStatement(sqlCompetitii);
			stmt.setString(1, anNou);
			stmt.setString(2, denumire);
			
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
	
	public static Auto deleteAuto(int idAuto) throws SQLException, ClassNotFoundException {
		Conturi cont = null;
		
		try {
			Connection conn = new ConnectionDB().getConnection();
			String sqlCompetitii = "DELETE FROM auto WHERE ID = ?";
			PreparedStatement stmt = conn.prepareStatement(sqlCompetitii);
			stmt.setInt(1, idAuto);
			
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
