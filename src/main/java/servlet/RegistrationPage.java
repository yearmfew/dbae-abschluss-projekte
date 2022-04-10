package servlet;

import java.io.IOException;
import java.util.ArrayList;
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
import student.RegEx;
import student.Student;

@WebServlet("/RegistrationPage")
public class RegistrationPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<Student> studenten = new ArrayList<Student>();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String vorname = request.getParameter("vorname");
		String nachname = request.getParameter("nachname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String error = "";
		String matrikelnummer = request.getParameter("matrikelnummer");
		String studiengang = (request.getParameter("studiengang"));
		String seminar = (request.getParameter("seminar"));
		String abschluss = (request.getParameter("abschluss"));
		String seminarthema = (request.getParameter("seminarthema")); // kann auch leer sein -> noch machen

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

		ArrayList<Student> sessionStudenten = (ArrayList<Student>) session.getAttribute("studenten");

		Student newStudent = new Student(vorname, nachname, email, password, matrikelnummer, studiengang, seminar, abschluss,
				seminarthema);
		studenten.add(newStudent);

		session.setAttribute("studenten", studenten);

		boolean isEmailExist = DatabaseStudent.isEmailExist(email);

		Map<String, String> result = new HashMap<String, String>();
		// prüfe im formular ob die formatbedingungen nach regex passen
		if (RegEx.pruefeEmail(email)) {// email prüfen else error
			if (RegEx.pruefeName(nachname) && RegEx.pruefeName(vorname)) { // name prüfen else error
				if (RegEx.pruefeMatrikelnummer(matrikelnummer)) {
					if (RegEx.pruefePasswort(password)) {
						if (!isEmailExist) { // checkt ob email schon einmal in datenbank gespeichert
							// DATABASE CONNECTION:

							if (DatabaseStudent.addStudent(newStudent)) {
								
								DatabasePassword.addPassword(newStudent); //könnte falsch sein
								
								session.setAttribute("DB add", "okay");
								request.getRequestDispatcher("login.jsp").forward(request, response);
								
								
								
								
							} else {
								session.setAttribute("DB add", "wrong");
								request.getRequestDispatcher("registration.jsp").forward(request, response);

							}
						} else {
							// resultset unnötig. noch rausnehmen
							result.put("emailAlreadyUsed", "Es gibt bereits einen Account mit dieser Email");
						}

					} else {
						error += "Passwort entspricht nicht dem Format! ";
					}
				} else {
					error += "Matrikelnummer entspricht nicht dem Format! ";
				}

			} else {
				error += "Name entspricht nicht dem Format! ";
			}

		} else {
			error += "Email entspricht nicht dem Format! ";
		}
		
		
		// fehlt noch das checkbox pflicht ist mache ich morgen

		request.setAttribute("error", error);

		request.getRequestDispatcher("registration.jsp").forward(request, response);
	}

}
