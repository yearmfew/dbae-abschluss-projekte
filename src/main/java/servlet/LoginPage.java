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
import database.DatabasePassword;
import student.Student;

//Servlet welches die Logindaten des Besuchers auf Richtigkeit prüft
@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Paramter werden übermittelt um mit denen zu arbeiten
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		session.setAttribute("validLogin", false);
		Boolean isLoginSuccessfull = false;

		// get studenten id
		int studentenId = DatabaseStudent.getId(email);
		if (studentenId != 0) {
			isLoginSuccessfull = DatabasePassword.checkPassword(studentenId, password);
		} else {
			// es gibt keinen student mit dieser email
			// redirect to login page with error code
			request.setAttribute("keineEmailFounded", "Es gibt keinen Nutzer mit dieser Mail.");
		}

		if (isLoginSuccessfull) {
			/*
			Student student = DatabaseKunde.getKundenData(email);
			ArrayList<Konto> konten = DatabaseKonto.getKontoData(email);
			session.setAttribute("kunde", kunde);
			session.setAttribute("konten", konten);
			request.getRequestDispatcher("konto.jsp").forward(request, response);
			*/
		} else {
			request.setAttribute("fehlermeldung", "Nutzername oder Passwort falsch. Bitte überprüfen sie ihre Daten.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}
