package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

import dozent.Dozent;
import exceptions.addSeminarException;
import exceptions.seminarNotFoundException;
import seminar.Seminar;
import student.Student;
/**
 * 
 * @author Birol Yilmaz
 *
 */
public class DatabaseSeminaren {

	private static Connection con = null;

	// GET METHODS
	public static ArrayList<Seminar> getSeminarsData() throws seminarNotFoundException{
		ArrayList<Seminar> seminaren = new ArrayList<Seminar>();

		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM seminar");
			ResultSet rs = pstmt.executeQuery();
			
				while (rs.next()) {
					Seminar seminar = new Seminar(rs.getInt("id"), rs.getString("titel"), rs.getString("oberbegriff"),
							rs.getString("beschreibung"), rs.getString("thema"), rs.getString("semester"),
							rs.getBoolean("status"));

					Dozent dozent = DatabaseDozent.getDozentById(rs.getInt("dozent_id"));
					Student student = DatabaseStudent.getStudentById(rs.getInt("student_id"));
					seminar.setZugewissenerStudent(student);
					seminar.setDozent(dozent);
					seminaren.add(seminar);
				}
			

		} catch (SQLException e) {
			System.err.println(e);
			System.err.println("SQL Fehler bei getSeminarsData()" + e.toString());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("[SQL] Fehler bei getSeminarsData() - Verbindung geschlossen");
			}
		}
		if(seminaren.size() == 0) throw new seminarNotFoundException("Es gibt keinen Seminar in Datenbank");
		return seminaren;

	}

	public static Seminar getSeminarById(int id) throws seminarNotFoundException {
		

		Seminar seminar = null;
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM seminar WHERE id= ?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					Seminar mySeminar = new Seminar(rs.getInt("id"), rs.getString("titel"), rs.getString("oberbegriff"),
							rs.getString("beschreibung"), rs.getString("thema"), rs.getString("semester"),
							rs.getBoolean("status"));

					Dozent dozent = DatabaseDozent.getDozentById(rs.getInt("dozent_id"));
					Student student = DatabaseStudent.getStudentById(rs.getInt("student_id"));
					mySeminar.setZugewissenerStudent(student);
					mySeminar.setDozent(dozent);
					seminar = mySeminar;
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
		if(seminar == null) throw new seminarNotFoundException("seminar with id " + id + " not found");
		return seminar;

	}

	// ADD METHODS

	public static boolean addSeminar (Seminar seminar) throws addSeminarException {
		boolean erfolg = false;

		try {
			con = DatabaseConnection.getConnection();

			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO seminar (titel, dozent_id, oberbegriff, beschreibung, semester, thema)  VALUES ("
							+ "?, " + // titel - String
							"?, " + // dozentId - Integer
							"?, " + // oberbegriff - String
							"?, " + // beschreibung - String
							"?, " + // semester - String
							"? " + // thema - String
							")");

			pstmt.setString(1, seminar.getTitel());
			pstmt.setInt(2, seminar.getDozentId());
			pstmt.setString(3, seminar.getOberbegriff());
			pstmt.setString(4, seminar.getBeschreibung());
			pstmt.setString(5, seminar.getSemester());
			pstmt.setString(6, seminar.getThema());

			int zeilen = pstmt.executeUpdate();
			if (zeilen > 0) {
				erfolg = true;

			}

		} catch (SQLException e) {
			System.err.println(e);
			System.err.println("SQL Fehler bei addSeminar()" + e.toString());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("[SQL] Fehler bei addSeminar() - Verbindung geschlossen");
			}
		}
		if(!erfolg) throw new addSeminarException();
		return erfolg;

	}

	// UPDATE METHODS
	public static boolean updateSeminar(Seminar seminar) {
		boolean erfolg = false;
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"UPDATE seminar SET id = ?, titel = ?, dozent_id = ?, thema = ?, oberbegriff = ?, beschreibung = ?, semester = ? WHERE id = ? ");
			pstmt.setInt(1, seminar.getId());
			pstmt.setString(2, seminar.getTitel());
			pstmt.setInt(3, seminar.getDozentId());
			pstmt.setString(4, seminar.getThema());
			pstmt.setString(5, seminar.getOberbegriff());
			pstmt.setString(6, seminar.getBeschreibung());
			pstmt.setString(7, seminar.getSemester());
			pstmt.setInt(8, seminar.getId());
			int zeilen = pstmt.executeUpdate();

			if (zeilen > 0) {
				erfolg = true;
			}

		} catch (SQLException e) {
			System.err.println(e);
			System.err.println("SQL Fehler bei updataSeminar()" + e.toString());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("[SQL] Fehler bei updateSeminar() - Verbindung geschlossen");
			}
		}
		return erfolg;
	}

	public static boolean belegSeminar(int seminarId, int studentId) {
		boolean erfolg = false;
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con
					.prepareStatement("UPDATE seminar SET status = true, student_id= ? WHERE id = ? ");
			pstmt.setInt(1, studentId);
			pstmt.setInt(2, seminarId);

			int zeilen = pstmt.executeUpdate();

			if (zeilen > 0) {
				erfolg = true;
			}

		} catch (SQLException e) {
			System.err.println(e);
			System.err.println("SQL Fehler bei updateSeminar()" + e.toString());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("[SQL] Fehler bei updateSeminar() - Verbindung geschlossen");
			}
		}
		return erfolg;
	}
}
