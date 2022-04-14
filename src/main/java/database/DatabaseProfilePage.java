package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import student.Student;

public class DatabaseProfilePage {
	private static Connection con = null;

	public static boolean updateStudent(Student student) {
		boolean erfolg = false;

		try {
			con = DatabaseConnection.getConnection();

			PreparedStatement pstmt = con.prepareStatement("UPDATE student SET vorname = ?, nachname = ? , email = ?, "
					+ " matrikelnummer = ?, seminar = ?, studiengang = ?, abschluss = ?, seminarthema = ? WHERE id = ? ");
			pstmt.setString(1, student.getVorname());
			pstmt.setString(2, student.getNachname());
			pstmt.setString(3, student.getMail());
			pstmt.setString(4, student.getMatrikelnummer());
			pstmt.setString(5, student.getSeminar());
			pstmt.setString(6, student.getStudiengang());
			pstmt.setString(7, student.getAbschluss());
			pstmt.setString(8, student.getSeminarthema());
			pstmt.setInt(9, student.getId()); // sollte so gehen kann aber falsch sein
			int zeilen = pstmt.executeUpdate();
			if (zeilen > 0) {
				erfolg = true;
				// student.setId(zeilen); // ach ka man
			}

		} catch (SQLException e) {
			System.err.println("SQL Fehler bei updateStudent()" + e.toString());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("[SQL] Fehler bei updateStudent() - Verbindung geschlossen");
			}
		}

		return erfolg;
	}
	// die methode kannst du löschen
	public static Student getStudentData(int id) {
		// syntax von datasebase kunde viel verändert prüfen"""
		Student student = null;
		try {
			con = DatabaseConnection.getConnection();

			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM student WHERE id = ?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String vorname = rs.getString("vorname");
				String nachname = rs.getString("nachname");
				String email = rs.getString("email");
				String matrikelnummer = rs.getString("matrikelnummer");
				String seminar = rs.getString("seminar");
				String studiengang = rs.getString("studiengang");
				String abschluss = rs.getString("abschluss");
				String seminarthema = rs.getString("seminarthema");
				
				student = new Student(vorname, nachname, email, matrikelnummer, seminar, studiengang, abschluss,
						seminarthema);

				student.setVorname(vorname);
				student.setNachname(nachname);
				student.setEmail(email);
				student.setMatrikelnummer(matrikelnummer);
				student.setSeminar(seminar);
				student.setStudiengang(studiengang);
				student.setAbschluss(abschluss);
				student.setSeminarthema(seminarthema);

				// alle sachen aus database in session gespeichert
				// egal mit welcher login wir uns anmelden (user id) die session hat nun
				// aktuelle daten
			}

		} catch (SQLException e) {
			System.err.println(e);
			System.err.println("SQL Fehler bei getStudentData()" + e.toString());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("[SQL] Fehler bei getStudentData() - Verbindung geschlossen");
			}
		}

		return student;
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
