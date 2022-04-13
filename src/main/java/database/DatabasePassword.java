package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import student.Student;
import java.util.UUID;

public class DatabasePassword {
	private static Connection con = null;

	/**
	 * Speichert das Passwort des Users in die Datenbank.
	 * 
	 * @param
	 * @return erfolg
	 */
	public static boolean addPassword(Student student) {
		boolean erfolg = false;
		while (!erfolg) {
			try {
				con = DatabaseConnection.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("INSERT INTO passwort (passwort, email) VALUES (" + "?, " + "?" +
						// "?" +
								")");
				// pstmt.setInt(1, student.getId());
				pstmt.setString(1, student.getPasswort());
				pstmt.setString(2, student.getEmail());
				int zeilen = pstmt.executeUpdate();
				if (zeilen > 0) {
					erfolg = true;
					// int studentid = 0;

					// abrufe die Id kundenid kunde auf der Datenbank
					// wir speichern es damit wir es beim password adding und wenn braucht nutzen
					// kann
					// PreparedStatement pstmtForStudentId = con.prepareStatement("SELECT userid
					// FROM passwort WHERE email = ?");
					// pstmtForStudentId.setString(1, student.getEmail());
					// ResultSet rs = pstmtForStudentId.executeQuery();
					// System.out.println("rs:::" + rs);

					// while (rs.next()) {
					// studentid = rs.getInt("userid");
					// }

					// student.setId(studentid);

				}

			} catch (SQLException e) {
				System.err.println("SQL Fehler bei addPassword()" + e.toString());
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("[SQL] Fehler bei addPassword() - Verbindung geschlossen");
				}
			}

		}
		return erfolg;
	}

	/**
	 * Holt Passwort aus Datenbank und prüft ob die eingegebenen Passwörter
	 * übereinstimmen.
	 * 
	 * @param kundenid des Users, Passwort des Users
	 * @return erfolg
	 */
	public static boolean checkPassword(int studentId, String password) {
		boolean loginSuccessfull = false;
		try {
			con = DatabaseConnection.getConnection();
			String passwordDB = null;

			PreparedStatement pstmt = con.prepareStatement("SELECT passwort FROM passwort WHERE userid= ?");
			pstmt.setInt(1, studentId);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				passwordDB = rs.getString("passwort");
			}
			System.out.println("pass DB Student: " + passwordDB);
			// falls kein student sich anmeldet kommt hier null also muss es ein dozent sein
			if (passwordDB == null) {
				loginSuccessfull = false;
				// falls es ein student ist und die daten richtig sind
			} else {
				if (passwordDB.equals(password)) {
					loginSuccessfull = true;
				}

			}
		} catch (SQLException e) {
			System.err.println(e);
			System.err.println("SQL Fehler bei checkPassword()" + e.toString());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("[SQL] Fehler bei checkPassword() - Verbindung geschlossen");
			}
		}
		return loginSuccessfull;
	}

	public static int getUserId(String email) {
		System.out.println("Hello");
		int userid = 0;
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT userid FROM passwort WHERE email= ?");
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			if (rs == null) {
				System.out.println("Es gibt keinen Student mit diesem Id in db.");
			} else {
				while (rs.next()) {
					userid = (rs.getInt("userid"));
				}
			}

		} catch (SQLException e) {
			System.err.println(e);
			System.err.println("SQL Fehler bei getUserIdBEFOREDATEBASEUPLOAD" + e.toString());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("[SQL] Fehler bei getStudentId - Verbindung geschlossen");
			}
		}
		System.out.println("id in email:" + userid);
		return userid;
	}

	public static boolean checkPasswordDozent(int dozentId, String password) {
		boolean loginSuccessfull = false;
		try {
			con = DatabaseConnection.getConnection();
			String passwordDB = null;

			PreparedStatement pstmt = con.prepareStatement("SELECT passwort FROM passwort WHERE userid= ?");
			pstmt.setInt(1, dozentId);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				passwordDB = rs.getString("passwort");
			}
			System.out.println("pass DB Dozent: " + passwordDB);
			// falls kein dozent sich anmeldet kommt hier null also muss es ein student sein
			if (passwordDB == null) {
				loginSuccessfull = false;
				// falls es ein dozent ist und die daten richtig sind
			} else {
				if (passwordDB.equals(password)) {
					loginSuccessfull = true;
				}
			}
		} catch (SQLException e) {
			System.err.println(e);
			System.err.println("SQL Fehler bei checkPasswordDozent()" + e.toString());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("[SQL] Fehler bei checkPasswordDozent() - Verbindung geschlossen");
			}
		}
		return loginSuccessfull;
	}
}