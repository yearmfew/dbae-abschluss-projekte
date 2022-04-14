package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bewertung.Bewertung;
import dozent.Dozent;
import exceptions.addBewertungException;
import exceptions.getBewertungException;
import exceptions.seminarNotFoundException;
import seminar.Seminar;
import student.Student;
import user.User;

public class DatabaseBewertungen {
	private static Connection con = null;
	
	public static ArrayList<Bewertung> getBewertungen() throws getBewertungException {
		ArrayList<Bewertung> bewertungen = new ArrayList<Bewertung>();

		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM bewertungen");
			ResultSet rs = pstmt.executeQuery();
		
				while (rs.next()) {
					Bewertung bewertung = new Bewertung(rs.getInt("id"), rs.getInt("foliengestaltung"),
							rs.getInt("sprachliche_prasentation"),rs.getInt("prasentationstil"),rs.getInt("zeitliche_gestaltung"),
							rs.getInt("verstandnis"),rs.getInt("inhaltliche_aufbereitung"),
							rs.getInt("verknüpfung_mit_anderen"),rs.getInt("diskassionführung"),
							rs.getInt("beteiligung_diskussionen"), rs.getString("kommentar"), 
							rs.getInt("bewerter_id"),rs.getInt("umfang"),
							rs.getInt("referenzen"),rs.getInt("sprachlicheGestaltung"),rs.getInt("schwierigkeitsgrad"), rs.getInt("seminarId"));

					User bewerter = DatabaseUser.getUserById(rs.getInt("bewerter_id"));
					bewertung.setBewerterType(bewerter.getUserType());
					bewertungen.add(bewertung);
					
				}
			

		} catch (SQLException e) {
			System.err.println(e);
			System.err.println("SQL Fehler bei getBewertungen()" + e.toString());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("[SQL] Fehler bei getBewertungen() - Verbindung geschlossen");
			}
		}
		if(bewertungen.size() == 0) throw new getBewertungException();
		return bewertungen;

	}
	
	
	public static boolean addBewertung(Bewertung bewertung) throws addBewertungException {
			boolean erfolg = false;
			
			try {
				con = DatabaseConnection.getConnection();

				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO bewertungen (id, foliengestaltung, sprachliche_prasentation, prasentationstil, zeitliche_gestaltung, verstandnis, "
						+ "inhaltliche_aufbereitung, verknüpfung_mit_anderen, diskassionführung, beteiligung_diskussionen, kommentar, bewerter_id, umfang, "
						+ "referenzen, sprachlicheGestaltung,schwierigkeitsgrad  )  VALUES ("
								+ "?, " + // id - integer
								"?, " + // foliengestaltung - integer
								"?, " + // sprachliche_prasentation - integer
								"?, " + // prasentationstil - integer
								"?, " + // zeitliche_gestaltung - integer
								"?, " + // verstandnis - integer
								"?, " + // inhaltliche_aufbereitung - integer
								"?, " + // verknüpfung_mit_anderen - integer
								"?, " + // diskassionführung - integer
								"?, " + // beteiligung_diskussionen - integer
								"?, " + // kommentar - String
								"?, " + // bewerter_id - integer
								"?, " + // umfang - integer
								"?, " + // referenzen - integer
								"?, " + // sprachlicheGestaltung - integer
								"? " + // schwierigkeitsgrad - String
								")");

				pstmt.setInt(1, bewertung.getId());
				pstmt.setInt(2, bewertung.getFoliengestaltung());
				pstmt.setInt(3, bewertung.getSpraclichePresentation());
				pstmt.setInt(4, bewertung.getPresentationstil());
				pstmt.setInt(5, bewertung.getZeitlicheGestaltung());
				pstmt.setInt(6, bewertung.getVerstandnis());
				pstmt.setInt(7, bewertung.getInhaltlicheAufbereitung());
				pstmt.setInt(8, bewertung.getVerknuepfungMitAnderen());
				pstmt.setInt(9, bewertung.getDiskassionFuehrung());
				pstmt.setInt(10, bewertung.getBeteiligungDiskassionen());
				pstmt.setString(11, bewertung.getKommentar());
				pstmt.setInt(12, bewertung.getBewerterId());
				pstmt.setInt(13, bewertung.getUmfang());
				pstmt.setInt(14, bewertung.getReferenzen());
				pstmt.setInt(15, bewertung.getSprachlicheGestaltung());
				pstmt.setInt(16, bewertung.getSchwerigkeitsgrad());
				

				int zeilen = pstmt.executeUpdate();
				if (zeilen > 0) {
					erfolg = true;

				}

			} catch (SQLException e) {
				System.err.println(e);
				System.err.println("SQL Fehler bei addBewertung()" + e.toString());
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("[SQL] Fehler bei addBewertung() - Verbindung geschlossen");
				}
			}
			
			
			if(!erfolg) throw new addBewertungException("Diese Bewertung existiert nicht.");
			return erfolg;
	}
	
	
	public static int getCountOfBewertungenById(int id) {
		int count = 0;
		
		   try {
				con = DatabaseConnection.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT COUNT(*) FROM bewertungen WHERE id =?");
				pstmt.setInt(1, id);
			
				ResultSet rs = pstmt.executeQuery();
				rs.next();
				count = rs.getInt(1);	
				

			} catch (SQLException e) {
				System.err.println(e);
				System.err.println("SQL Fehler bei getBewertungen()" + e.toString());
			} finally {
				try {
					con.close();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("[SQL] Fehler bei getBewertungen() - Verbindung geschlossen");
				}
			}
		   
	
		return count;
	}
	
	
}
