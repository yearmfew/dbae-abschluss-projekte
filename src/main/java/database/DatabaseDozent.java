package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dozent.Dozent;
/**
 * Klasse welche Daten des Dozente aus der Datenbanktabelle dozent holt.
 * @author Birol Yilmaz, Anas Souseh
 *
 */
public class DatabaseDozent {

	private static Connection con = null;

	public static Dozent getDozentById(int id) {
		
		Dozent dozent = null;
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM dozent WHERE id= ?");
			pstmt.setInt(1, id);			
			ResultSet rs = pstmt.executeQuery();
			if (rs == null) {
				System.out.println("Es gibt keinen Dozent mit dieser id in db.");
			} else {
				while (rs.next()) {
					Dozent myDozent = new Dozent(rs.getInt("id"), rs.getString("vorname"), rs.getString("nachname"), rs.getString("titel"), rs.getString("email"));
					dozent = myDozent;
				}
			}

		} catch (SQLException e) {
			System.err.println(e);
			System.err.println("SQL Fehler bei getKontoId" + e.toString());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("[SQL] Fehler bei getKontoId - Verbindung geschlossen");
			}
		}
		
		return dozent;

	}
	
	public static ArrayList<Dozent> getAllDozenten() {
		ArrayList<Dozent> dozenten = new ArrayList <Dozent>();
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM dozent");
					
			ResultSet rs = pstmt.executeQuery();
			if (rs == null) {
				System.out.println("Es gibt keinen Dozent mit diesem Id in db.");
			} else {
				while (rs.next()) {
					Dozent dozent = new Dozent(rs.getInt("id"), rs.getString("vorname"), rs.getString("nachname"), rs.getString("titel"), rs.getString("email"));
					dozenten.add(dozent);
				}
			}

		} catch (SQLException e) {
			System.err.println(e);
			System.err.println("SQL Fehler bei getAllDozenten" + e.toString());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("[SQL] Fehler bei getAllDozenten - Verbindung geschlossen");
			}
		}
		
		return dozenten;
	}
	
	public static int getId(String email) {
		int id = 0;

		try {
			con = DatabaseConnection.getConnection();

			PreparedStatement pstmt = con.prepareStatement("SELECT id FROM dozent WHERE email = ?");
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				id = rs.getInt("id");
			}
			System.out.println(id);

		} catch (SQLException e) {
			System.err.println(e);
			System.err.println("SQL Fehler bei getId()" + e.toString());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("[SQL] Fehler bei getId() - Verbindung geschlossen");
			}
		}

		return id;
	}
}
