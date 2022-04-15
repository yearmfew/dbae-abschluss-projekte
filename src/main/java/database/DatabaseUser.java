package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import student.Student;
import user.User;
/**
 * 
 * @author Anas Souseh, Birol Yilmaz
 *
 */
public class DatabaseUser {
	private static Connection con = null;

	/**
	 * Speichert das Passwort des Users in die Datenbank.
	 * 
	 * @param
	 * @return erfolg
	 */
	public static boolean addUser(Student student) {
		boolean erfolg = false;
		while (!erfolg) {
			try {
				con = DatabaseConnection.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("INSERT INTO users (passwort, email) VALUES (" + "?, " + "?" +
						// "?" +
								")");
				pstmt.setString(1, student.getPasswort());
				pstmt.setString(2, student.getEmail());
				int zeilen = pstmt.executeUpdate();
				if (zeilen > 0) {
					erfolg = true;
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

	
	public static User getUserById(int id) {
		User user = null;
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users WHERE id= ?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs == null) {
				System.out.println("Es gibt keinen User mit diesem Id in db.");
			} else {
				while ( rs.next()) {
					User myUser = new User(rs.getInt("userid"), rs.getString("user_type"), rs.getString("email"), rs.getString("passwort"));
					user = myUser;
				}
			}

		} catch (SQLException e) {
			System.err.println(e);
			System.err.println("SQL Fehler bei getStudentid" + e.toString());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("[SQL] Fehler bei getStudentId - Verbindung geschlossen");
			}
		}
				
		return user;
	}
	public static User getUserByMail(String email) {
		User user = null;
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users WHERE email = ?");
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			if (rs == null) {
				System.out.println("Es gibt keinen User mit diesem email in db.");
			} else {
			

				while ( rs.next()) {
					User myUser = new User(rs.getInt("id"), rs.getString("user_type"), rs.getString("email"), rs.getString("passwort"));
					user = myUser;
				}
			}

		} catch (SQLException e) {
			System.err.println(e);
			System.err.println("SQL Fehler bei getUserByMail...." + e.toString());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("[SQL] Fehler bei getUserByMail - Verbindung geschlossen");
			}
		}
		return user;
	}

	/**
	 * Holt Passwort aus Datenbank und prüft ob die eingegebenen Passwörter
	 * übereinstimmen.
	 * 
	 * @param kundenid des Users, Passwort des Users
	 * @return erfolg
	 */
	

	public static int getUserId(String email) {
		System.out.println("Hello");
		int userid = 0;
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT id FROM users WHERE email= ?");
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			if (rs == null) {
				System.out.println("Es gibt keinen Student mit diesem Id in db.");
			} else {
				while (rs.next()) {
					userid = (rs.getInt("id"));
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

	
	public static String getPasswort(int id) {

		String passwort = "0";
		try {
			con = DatabaseConnection.getConnection();

			PreparedStatement pstmt = con.prepareStatement("SELECT passwort FROM users WHERE id = ?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				passwort = rs.getString("passwort");

			}

		} catch (SQLException e) {
			System.err.println(e);
			System.err.println("SQL Fehler bei getPasswort()" + e.toString());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("[SQL] Fehler bei getPasswort() - Verbindung geschlossen");
			}
		}

		return passwort;
	}
	
}
