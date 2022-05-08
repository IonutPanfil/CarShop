package interogari;

import connectionDB.*;
import reprezentanta.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.time.LocalDate;


public class TranzactiiManager {
	
	public static List<Tranzactii> getAllTranzactii() throws SQLException, ClassNotFoundException {
		List<Tranzactii> listaTranzactii = new LinkedList();
		
		try {
			Connection con = new ConnectionDB().getConnection();
			String sql = "SELECT tranzactii.id, idClient , conturi.username as numeClient, auto.id, auto.denumire, pret, data FROM tranzactii,conturi,auto WHERE tranzactii.idClient = conturi.id  AND tranzactii.idAuto = auto.id";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Tranzactii tranzactii = new Tranzactii();
				tranzactii.setId(rs.getInt("tranzactii.id"));
				tranzactii.setIdClient(rs.getInt("idClient"));
				tranzactii.setNumeClient(rs.getString("numeClient"));
				tranzactii.setPret(rs.getInt("pret"));
				tranzactii.setData(rs.getString("data"));
				tranzactii.setIdAuto(rs.getInt("auto.id"));
				tranzactii.setNumeAuto(rs.getNString("auto.denumire"));
				
				listaTranzactii.add(tranzactii);
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
		
		return listaTranzactii;
	}
	
	
	
	public static List<Tranzactii> getAllTranzactiiByClient(String numeClient) throws SQLException, ClassNotFoundException {
		List<Tranzactii> listaTranzactii = new LinkedList();
		
		try {
			Connection con = new ConnectionDB().getConnection();
			String sql = "SELECT tranzactii.id, idClient , conturi.username as numeClient, auto.id, auto.denumire, pret, data FROM tranzactii,conturi,auto WHERE tranzactii.idClient = conturi.id  AND tranzactii.idAuto = auto.id AND conturi.username = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,numeClient);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Tranzactii tranzactii = new Tranzactii();
				tranzactii.setId(rs.getInt("tranzactii.id"));
				tranzactii.setIdClient(rs.getInt("idClient"));
				tranzactii.setNumeClient(rs.getString("numeClient"));
				tranzactii.setPret(rs.getInt("pret"));
				tranzactii.setData(rs.getString("data"));
				tranzactii.setIdAuto(rs.getInt("auto.id"));
				tranzactii.setNumeAuto(rs.getNString("auto.denumire"));
				
				listaTranzactii.add(tranzactii);
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
		
		return listaTranzactii;
	}
	
	public static List<Tranzactii> getAllTranzactiiByAuto(String numeAuto) throws SQLException, ClassNotFoundException {
		List<Tranzactii> listaTranzactii = new LinkedList();
		
		try {
			Connection con = new ConnectionDB().getConnection();
			String sql = "SELECT tranzactii.id, idClient , conturi.username as numeClient, auto.id, auto.denumire, pret, data FROM tranzactii,conturi,auto WHERE tranzactii.idClient = conturi.id  AND tranzactii.idAuto = auto.id AND auto.denumire = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,numeAuto);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Tranzactii tranzactii = new Tranzactii();
				tranzactii.setId(rs.getInt("tranzactii.id"));
				tranzactii.setIdClient(rs.getInt("idClient"));
				tranzactii.setNumeClient(rs.getString("numeClient"));
				tranzactii.setPret(rs.getInt("pret"));
				tranzactii.setData(rs.getString("data"));
				tranzactii.setIdAuto(rs.getInt("auto.id"));
				tranzactii.setNumeAuto(rs.getNString("auto.denumire"));
				
				listaTranzactii.add(tranzactii);
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
		
		return listaTranzactii;
	}
	
	public static Tranzactii insertTranzactie(int idAuto, int idClient, int pret)throws SQLException, ClassNotFoundException {
		LocalDate date = LocalDate.now();
		String dateS = date.toString();
		
		try {
			Connection con = new ConnectionDB().getConnection();
			String sql = "INSERT INTO tranzactii(idAuto, idClient, pret, data) VALUES(?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, idAuto);
			stmt.setInt(2, idClient);
			stmt.setInt(3, pret);
			stmt.setString(4, dateS);
			
			stmt.executeUpdate();
			System.out.println("S-a efectuat inserarea");
			
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
		
		return null;
	}
	
}
