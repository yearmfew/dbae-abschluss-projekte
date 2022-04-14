package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import student.Student;
import java.sql.SQLException;
import student.Student;

import java.util.ArrayList;

import dozent.Dozent;
import seminar.Seminar;

public class DatabaseStudent {
	private static Connection con = null;

	public static Student addStudent(Student student) {
		// boolean erfolg = false;
		System.out.println("id: " + student.getId());

		try {
			con = DatabaseConnection.getConnection();
			/* ) */
			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO student (id, vorname, nachname, email, matrikelnummer, seminar, studiengang, abschluss, seminarthema) VALUES ("
							+ "?, " + /// vorname - String
							"?, " + // nachname - String
							"?, " + // nachname - String
							"?, " + // mail - String
							"?, " + // Matrikelnummer - String
							"?, " + // Studiengang - String
							"?, " + // belegtes Seminar - String
							"?, " + // Abschluss - String
							"?" + // Semniarthema - String
							")");
			pstmt.setInt(1, student.getId());
			pstmt.setString(2, student.getVorname());
			pstmt.setString(3, student.getNachname());
			pstmt.setString(4, student.getMail());
			pstmt.setString(5, student.getMatrikelnummer());
			pstmt.setString(6, student.getSeminar());
			pstmt.setString(7, student.getStudiengang());
			pstmt.setString(8, student.getAbschluss());
			pstmt.setString(9, student.getSeminarthema());
			int zeilen = pstmt.executeUpdate();
			if (zeilen > 0) {
				// erfolg = true;

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

		return student;
	}

	
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
		Student habile = null;
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM student WHERE id= ?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs == null) {
				System.out.println("Es gibt keinen Student mit diesem Id in db.");
			} else {
				while ( rs.next()) {
					Student myStudent = new Student(rs.getInt("id"), 
							rs.getString("vorname"), rs.getString("nachname"), rs.getString("email"),
							rs.getString("matrikelnummer"), rs.getString("studiengang"), 
							rs.getString("seminar"), rs.getString("abschluss"), 
							rs.getString("seminarThema"));
					return myStudent;
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
		
		
		
		
		return habile;

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
		System.out.println("id in email:"+ id);
		return id;
	}

	public static ArrayList getStudentData() {
		ArrayList<Student> studenten = new ArrayList<Student>();

		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM student");
			ResultSet rs = pstmt.executeQuery();
			if (rs == null) {
				System.out.println("Es gibt keinen Studenten in der Datenbank.");
			} else {
				while (rs.next()) {
					Student student = new Student(rs.getInt("id"), rs.getString("vorname"), rs.getString("nachname"),
							rs.getString("email"), rs.getString("matrikelnummer"), rs.getString("seminar"),
							rs.getString("studiengang"), rs.getString("abschluss"), rs.getString("seminarthema"));

					// Dozent dozent = DatabaseDozent.getDozentById(rs.getInt("dozent_id"));

					// int studentId = rs.getInt("zugewissenerStudentId");
					// student = DatabaseStudent.getStudentById(studentId);

					// seminar.setZugewissenerStudent(student);
					// seminar.setDozent(dozent);
					studenten.add(student);
				}
			}

		} catch (SQLException e) {
			System.err.println(e);
			System.err.println("SQL Fehler bei getStudentenData" + e.toString());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("[SQL] Fehler bei getStudenData - Verbindung geschlossen");
			}
		}
		return studenten;

	}
}