package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import student.Student;
import java.sql.SQLException;
import student.Student;
public class DatabaseStudent {
	private static Connection con = null;

	public static boolean addStudent(Student student) {
		boolean erfolg = false;

		try {
			con = DatabaseConnection.getConnection();

			PreparedStatement pstmt = con.prepareStatement("INSERT INTO student (vorname, nachname, email, matrikelnummer, seminar, studiengang, abschluss, seminarthema) VALUES (" + "?, " + /// vorname - String
					"?, " + // nachname - String
					"?, " + // mail - String
					"?, " + // Matrikelnummer - String
					"?, " + // Studiengang - String
					"?, " + // belegtes Seminar - String
					"?, " + // Abschluss - String
					"?" + // Semniarthema - String
					")");
			
			pstmt.setString(1, student.getVorname());
			pstmt.setString(2, student.getNachname());
			pstmt.setString(3, student.getMail());
			pstmt.setString(4, student.getMatrikelnummer());
			pstmt.setString(5, student.getSeminar());
			pstmt.setString(6, student.getStudiengang());
			pstmt.setString(7, student.getAbschluss());
			pstmt.setString(8, student.getSeminarthema());
			int zeilen = pstmt.executeUpdate();
			if (zeilen > 0) {
				erfolg = true;

			}

		} catch (SQLException e) {
			System.err.println("SQL Fehler bei addStudent()" + e.toString());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("[SQL] Fehler bei addStudent() - Verbindung geschlossen");
			}
		}

		return erfolg;
	}

	/**
	 * Prüft ob Studentmail bereits in der Datenbank existiert.
	 * 
	 * @param email
	 * @return erfolg
	 */
	public static boolean isEmailExist(String email) {
		boolean isExist = false;
		try {
			con = DatabaseConnection.getConnection();

			PreparedStatement pstmt = con
					.prepareStatement("SELECT COUNT('email') as result FROM student WHERE email = ?");

			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				int returnInt = rs.getInt("result");
				if (returnInt == 1) {
					isExist = true;
				}
			}
		} catch (SQLException e) {
			System.err.println(e);
			System.err.println("SQL Fehler bei addStudent()" + e.toString());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("[SQL] Fehler bei addStudent() - Verbindung geschlossen");
			}
		}
		return isExist;
	}

	public static Student getStudentById(int id) {
		Student student = null;
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM student WHERE id= ?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs == null) {
				System.out.println("Es gibt keinen Student mit diesem Id in db.");
			} else {
				while ( rs.next()) {
					Student myStudent = new Student(rs.getInt("id"), rs.getString("vorname"), rs.getString("nachname"));
					student = myStudent;
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
				System.out.println("[SQL] Fehler bei getStudentId - Verbindung geschlossen");
			}
		}

		return student;

	}

	/**
	 * Die StudentId wird aus der Datenbank zur Session gesendet.
	 * 
	 * @param email
	 * @return erfolg
	 */
	public static int getId(String email) {
		int id = 0;

		try {
			con = DatabaseConnection.getConnection();

			PreparedStatement pstmt = con.prepareStatement("SELECT id FROM student WHERE email = ?");
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