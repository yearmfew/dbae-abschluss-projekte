package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DatabaseStudent;
import database.DatabaseUser;
import dozent.Dozent;
import database.DatabaseBewertungen;
import database.DatabaseDozent;
import student.Student;
import user.User;

/**
 * Servlet welches die Logindaten des Besuchers auf Richtigkeit prüft
 * 
 * @author Anas Souseh
 */
@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();

		Boolean validLogin = false;
		try {
			User user = DatabaseUser.getUserByMail(email);
			// falls versucht wird mit mail einzuloggen welche nicht der datenbank ist...
			if (user != null) {
				if (user.getPassword().equals(password)) {
					validLogin = true;
					session.setAttribute("validLogin", validLogin);
					session.setAttribute("user", user);

				} else {
					request.setAttribute("fehlermeldung",
							"Nutzername oder Passwort falsch. Bitte überprüfen sie ihre Daten.");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
				// if teil student/ else dozent
				if (validLogin) { 
					if (user.getUserType().equals("student")) {
						// student und dozent bei login in session speicherun um in folgenden Seiten mit
						// richtigen Werten zu arbeiten
						Student student = DatabaseStudent.getStudentById(user.getId());
						int countOfBewertungen = DatabaseBewertungen.getCountOfBewertungenById(student.getId());
						int durchnittlicheNote = DatabaseBewertungen.getNoteVonBewertung(student.getId());
						student.setCountOfBewertungen(countOfBewertungen);
						session.setAttribute("student", student);
						request.getRequestDispatcher("initSeminaren").forward(request, response);
					} else if (user.getUserType().equals("dozent")) {
						Dozent dozent = DatabaseDozent.getDozentById(user.getId());
						session.setAttribute("dozent", dozent);
						request.getRequestDispatcher("initSeminaren").forward(request, response);
					}
				}
			} else { // ... wird eine warning message geworfen ohne das die seite down geht
				request.setAttribute("fehlermeldung", "Die Kombination aus E-Mail/Passwort ist nicht vorhanden.");
				request.getRequestDispatcher("login.jsp").forward(request, response);
				System.out.println("user ist null");

			}
		} catch (NullPointerException npe) {
			request.setAttribute("fehlermeldung", "Es ist ein Fehler aufgetreten. Haben Sie sich bereits registriert?");
			System.out.println("haben sie sich bereits registriert?");
		}
	}
}
