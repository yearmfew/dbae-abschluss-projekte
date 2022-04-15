package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DatabasePassword;
import database.DatabaseStudent;
import database.DatabaseUser;
import student.Student;
import user.User;
import validierung.checkFormEditSeminarData;
import validierung.checkFormStudentData;
/**
 * 
 * @author Anas Souseh
 *
 */
@WebServlet("/RegistrationPage")
public class RegistrationPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String vorname = request.getParameter("vorname");
		String nachname = request.getParameter("nachname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String matrikelnummer = request.getParameter("matrikelnummer");
		String studiengang = (request.getParameter("studiengang"));
		String seminar = (request.getParameter("seminar"));
		String abschluss = (request.getParameter("abschluss"));
		String seminarthema = (request.getParameter("seminarthema"));

		request.setAttribute("vorname", vorname);
		request.setAttribute("nachname", nachname);
		request.setAttribute("email", email);
		request.setAttribute("password", password);
		request.setAttribute("matrikelnummer", matrikelnummer);
		request.setAttribute("studiengang", studiengang);
		request.setAttribute("seminar", seminar);
		request.setAttribute("abschluss", abschluss);
		request.setAttribute("seminarthema", seminarthema);
		HttpSession session = request.getSession();

		Student student = new Student(vorname, nachname, email, password, matrikelnummer, studiengang, seminar,
				abschluss, seminarthema);

		// muss alles in checkforma data weil ich das auch bei profil bearbeiten brauche
		
		Map<String, String> result = new HashMap<String, String>();
		checkFormStudentData cF = new checkFormStudentData();

		result = cF.checkForm(vorname, nachname, email, password, studiengang, matrikelnummer, seminar, abschluss, seminarthema);
		
		if (result.size() == 0) {
		// DATABASE PASSWORT WRITE DATA
		// füg bei password einen usertype hinzu
		DatabasePassword.addPassword(student);
		// id holen von db
		int id = DatabasePassword.getUserId(student.getEmail());

		student.setId(id);
		// DATABASE STUDENT WRITE DATA
		DatabaseStudent.addStudent(student);

		session.setAttribute("DB add", "okay");
		request.getRequestDispatcher("login.jsp").forward(request, response);
		}  else {
			// fehler erklarungen erstellung mit for loop
			for (Object i : result.keySet()) {
				request.setAttribute((String) i, (String) result.get(i));
			 }
			request.getRequestDispatcher("registration.jsp").forward(request, response);
		}
		// check form test ende

		/*
		 * // prüfe im formular ob die formatbedingungen nach regex passen if
		 * (RegEx.pruefeEmail(email)) {// email prüfen else error if
		 * (RegEx.pruefeName(nachname) && RegEx.pruefeName(vorname)) { // name prüfen
		 * else error if (RegEx.pruefeMatrikelnummer(matrikelnummer)) { if
		 * (RegEx.pruefePasswort(password)) { if (!isEmailExist) { // checkt ob email
		 * schon einmal in datenbank gespeichert // DATABASE CONNECTION:
		 * 
		 * if (DatabaseStudent.addStudent(newStudent)) {
		 * 
		 * DatabasePassword.addPassword(newStudent); //könnte falsch sein
		 * 
		 * session.setAttribute("DB add", "okay");
		 * request.getRequestDispatcher("login.jsp").forward(request, response);
		 * 
		 * 
		 * 
		 * 
		 * } else { session.setAttribute("DB add", "wrong");
		 * request.getRequestDispatcher("registration.jsp").forward(request, response);
		 * 
		 * } } else { // resultset unnötig. noch rausnehmen
		 * result.put("emailAlreadyUsed",
		 * "Es gibt bereits einen Account mit dieser Email"); }
		 * 
		 * } else { error += "Passwort entspricht nicht dem Format! "; } } else { error
		 * += "Matrikelnummer entspricht nicht dem Format! "; }
		 * 
		 * } else { error += "Name entspricht nicht dem Format! "; }
		 * 
		 * } else { error += "Email entspricht nicht dem Format! "; }
		 */

		// fehlt noch das checkbox pflicht ist mache ich morgen

		// request.setAttribute("error", error);

	 
	}

}
