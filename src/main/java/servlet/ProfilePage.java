package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import student.Student;

@WebServlet("/ProfilePage")
public class ProfilePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// zeigt die daten des users die er bei registration angegeben hat (editierbar)
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		// int id = student.getId();
		Student student = database.DatabaseProfilePage.getStudentData(0); // erstmal null
	    
		session.setAttribute("student", student);

		String vorname = student.getVorname();
		String nachname = student.getNachname();
		String email = student.getEmail();
		String matrikelnummer = student.getMatrikelnummer();
		String studiengang = student.getStudiengang();
		String seminar = student.getSeminar();
		String abschluss = student.getAbschluss();
		String seminarthema = student.getSeminarthema();
		
		session = request.getSession();
		
		request.setAttribute("vorname", vorname);
		request.setAttribute("nachname", nachname);
		request.setAttribute("email", email);
		request.setAttribute("matrikelnummer", matrikelnummer);
		request.setAttribute("studiengang", studiengang);
		request.setAttribute("seminar", seminar);
		request.setAttribute("abschluss", abschluss);
		request.setAttribute("seminarthema", seminarthema);
		
		request.getRequestDispatcher("profil.jsp").forward(request, response);
		
		// databaseprofile get student data mit id welche ich nutze bei login
		// bekomme alle profilwerte von dem eigenlogten user gerade
		// lasse die dann auf jsp anzeigen
		
		String passwort = request.getParameter("passwort");
		// kann auch leer sein -> noch machen

		request.setAttribute("passwort", passwort);
		
		
		ArrayList<Student> sessionStudenten = (ArrayList<Student>) session.getAttribute("studenten");

		if (passwort.equals(database.DatabaseProfilePage.getPasswort(0))) {
			
			request.getParameter("vorname");
			nachname = request.getParameter("nachname");
			email = request.getParameter("email");
			matrikelnummer = request.getParameter("matrikelnummer");
			studiengang = request.getParameter("studiengang");
			seminar = request.getParameter("seminar");
			abschluss = request.getParameter("abschluss");
			seminarthema = request.getParameter("seminarthema"); // kann auch leer sein -> noch machen
			
			Student updateStudent = new Student(vorname, nachname, email, matrikelnummer, studiengang, seminar,
					abschluss, seminarthema);
			database.DatabaseProfilePage.updateStudent(updateStudent);
			System.out.println("profiländerung ausgeführt");
			// request.getRequestDispatcher("profil.jsp").forward(request, response);
		} else {
			System.out.println("profil bearbeiten funktioniert nicht......esfsefds");
		} 
		// editierfunktion mit eingerichteter update methode
		// das gleiche für dozenten machen

	} 
}