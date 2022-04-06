package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import seminar.Seminar;

public class DatabaseSeminaren {
	private static Connection con = null;
	
	public static ArrayList getSeminarsData() {
		ArrayList<Seminar> seminaren = new ArrayList<Seminar>();


		// try {
			try {
				con = DatabaseConnection.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(con);

			// PreparedStatement pstmt = con.prepareStatement("SELECT kontoid FROM konto WHERE kundenemail= ?");
			// pstmt.setString(1, email);
			// ResultSet rs = pstmt.executeQuery();

		/*	while (rs.next()) {
				kontoid = rs.getInt("kontoid");
			}
			System.out.println("unsere kontoid.. " + kontoid);

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
		} */
		
		return seminaren;
		
	}
	
}
