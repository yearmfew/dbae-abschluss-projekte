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
import database.DatabaseDozent;
import database.DatabasePassword;
import student.Student;
import user.User;

//Servlet welches die Logindaten des Besuchers auf Richtigkeit prüft
@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();

		Boolean validLogin = false;

		User user = DatabaseUser.getUserByMail(email);
		if (user.getPassword().equals(password)) {
			validLogin = true;
			session.setAttribute("validLogin", validLogin);
			session.setAttribute("user", user);

		}else {
			System.out.println("what the fick are you doing here!!!");
			request.setAttribute("fehlermeldung", "Nutzername oder Passwort falsch. Bitte überprüfen sie ihre Daten.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

		
		if (validLogin) {
			if (user.getUserType().equals("student")) {

				Student student = DatabaseStudent.getStudentById(user.getId());
				session.setAttribute("student", student);
				request.getRequestDispatcher("initSeminaren").forward(request, response);
			} else if (user.getUserType().equals("dozent")) {
				Dozent dozent = DatabaseDozent.getDozentById(user.getId());
				session.setAttribute("dozent", dozent);
				request.getRequestDispatcher("initSeminaren").forward(request, response);
			}

		} 
		
	}
}
