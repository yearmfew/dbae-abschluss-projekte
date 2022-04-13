package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import user.UserType;

public class DatabaseUserType {
	private static Connection con = null;

	public static boolean addUsertype(UserType usertype) {
		boolean erfolg = false;
		System.out.println("usertypeid: " + usertype.getId());

		try {
			con = DatabaseConnection.getConnection();
			/* ) */
			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO usertype VALUES ("
							+ "?, " + // id - int
							"? " + // type - String
							")");
			pstmt.setInt(1, usertype.getId());
			pstmt.setString(2, usertype.getType());
			int zeilen = pstmt.executeUpdate();
			if (zeilen > 0) {
				erfolg = true;

			}

		} catch (SQLException e) {
			System.err.println("SQL Fehler bei addUserType()" + e.toString());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("[SQL] Fehler bei addUserType() - Verbindung geschlossen");
			}
		}

		return erfolg;
	}

}
