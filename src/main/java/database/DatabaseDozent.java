package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dozent.Dozent;
import seminar.Seminar;

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
				System.out.println("Es gibt keinen Dozent mit diesem Id in db.");
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

}
