package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import student.Student;
import user.User;

public class DatabaseUser {
	private static Connection con = null;

//	public static boolean adduser(User user) {
//		boolean erfolg = false;
//		try {
//			con = DatabaseConnection.getConnection();
//			/* ) */
//			PreparedStatement pstmt = con.prepareStatement(
//					"INSERT INTO user VALUES ("
//							+ "?, " + // id - int
//							"? " + // type - String
//							")");
//			pstmt.setInt(1, user.getId());
//			pstmt.setString(2, user.getType());
//			int zeilen = pstmt.executeUpdate();
//			if (zeilen > 0) {
//				erfolg = true;
//
//			}
//
//		} catch (SQLException e) {
//			System.err.println("SQL Fehler bei adduser()" + e.toString());
//		} finally {
//			try {
//				con.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				System.out.println("[SQL] Fehler bei adduser() - Verbindung geschlossen");
//			}
//		}
//
//		return erfolg;
//	}

	
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
}
