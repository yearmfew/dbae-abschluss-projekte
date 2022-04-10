package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dozent.Dozent;
import seminar.Seminar;
import student.Student;

public class DatabaseSeminaren {

	private static Connection con = null;

	public static ArrayList getSeminarsData() {
		ArrayList<Seminar> seminaren = new ArrayList<Seminar>();

		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM seminar");
			ResultSet rs = pstmt.executeQuery();
			if (rs == null) {
				System.out.println("Es gibt keinen Seminar in db.");
			} else {
				while (rs.next()) {
					Seminar seminar = new Seminar(rs.getInt("id"), rs.getString("titel"), rs.getString("oberbegriff"),
							rs.getString("beschreibung"), rs.getString("theme"), rs.getString("semester"), rs.getBoolean("status"));
					
					
					Dozent dozent = DatabaseDozent.getDozentById(rs.getInt("dozentId"));
					int studentId = rs.getInt("zugewissenerStudentId");
			
						Student student = DatabaseStudent.getStudentById(studentId);
						seminar.setZugewissenerStudent(student);
					
					seminar.setDozent(dozent);
					// System.out.println(dozent.getVorname());
					
					seminaren.add(seminar);
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
		return seminaren;

	}

}
