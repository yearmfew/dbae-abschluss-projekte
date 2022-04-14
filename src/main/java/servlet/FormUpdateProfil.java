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

import database.DatabaseStudent;
import seminar.Seminar;
import student.Student;
import validierung.checkFormEditSeminarData;
import validierung.checkFormStudentData;

@WebServlet("/FormUpdateProfil")
public class FormUpdateProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// zeigt die daten des users die er bei registration angegeben hat (editierbar)
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Student student = (Student) session.getAttribute("student");

		String vorname = student.getVorname();
		String nachname = student.getNachname();
		String email = student.getEmail();
		String matrikelnummer = student.getMatrikelnummer();
		String studiengang = student.getStudiengang();
		String seminar = student.getSeminar();
		String abschluss = student.getAbschluss();
		String seminarthema = student.getSeminarthema();

		String passwort = request.getParameter("passwort");

		if (passwort.equals(database.DatabaseProfilePage.getPasswort(student.getId()))) {

			if (request.getParameter("vorname") != "")
				vorname = request.getParameter("vorname");
			if (request.getParameter("nachname") != "")
				nachname = request.getParameter("nachname");
			if (request.getParameter("email") != "")
				email = request.getParameter("email");
			if (request.getParameter("matrikelnummer") != "")
				matrikelnummer = request.getParameter("matrikelnummer");
			if (request.getParameter("studiengang") != "")
				studiengang = request.getParameter("studiengang");
			if (request.getParameter("seminar") != "")
				seminar = request.getParameter("seminar");
			if (request.getParameter("abschluss") != "")
				abschluss = request.getParameter("abschluss");
			if (request.getParameter("seminarthema") != "")
				seminarthema = request.getParameter("seminarthema");

			Map<String, String> result = new HashMap<String, String>();
			checkFormStudentData cF = new checkFormStudentData();

			result = cF.checkForm(vorname, nachname, email, passwort, studiengang, matrikelnummer, seminar, abschluss,
					seminarthema);

			if (result.size() == 0) {
				Student updatedStudent = new Student(student.getId(), vorname, nachname, email, matrikelnummer,
						studiengang, seminar, abschluss, seminarthema);
				boolean erfolg = database.DatabaseStudent.updateStudent(updatedStudent);
				if (erfolg) {
					// weiterleitung auf richtige page muss ich mir noch überlegen....
					session.setAttribute("student", updatedStudent);
					request.getRequestDispatcher("profil.jsp").forward(request, response);
				} else {
					System.out.println("Problem");
				}
			}

		} else {
			System.out.println("profil bearbeiten funktioniert nicht......esfsefds");
			request.getRequestDispatcher("profil.jsp").forward(request, response);
		}

	}
}
