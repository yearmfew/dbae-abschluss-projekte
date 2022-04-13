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
import database.DatabaseUserType;
import dozent.Dozent;
import database.DatabaseDozent;
import database.DatabasePassword;
import student.Student;
import user.UserType;

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
		Boolean isDozentLoginSuccessfull = false;

		// get studenten id
		int studentenId = DatabaseStudent.getId(email);
		
		int dozentenId = DatabaseDozent.getId(email);
		System.out.println("dozentid ist" + dozentenId);
		if (studentenId != 0 || dozentenId != 0) { 
			
			isLoginSuccessfull = DatabasePassword.checkPassword(studentenId, password);
			System.out.println("ivh bin schonmal richtig");
			isDozentLoginSuccessfull = DatabasePassword.checkPasswordDozent(dozentenId, password);
		} else {
			// redirect to login page with error code
			request.setAttribute("keineEmailFounded", "Es gibt keinen Nutzer mit dieser Mail.");
		}

		if (isLoginSuccessfull) {
			
			Student student = DatabaseStudent.getStudentById(studentenId);
			session.setAttribute("student", student);
			request.getRequestDispatcher("profil.jsp").forward(request, response);
			System.out.println("Der Student Login ist erfolgreich");
			
			
			// klappt das 
			UserType usertype = (UserType) session.getAttribute("usertype");
			System.out.println("Der usertype ist in der session: " + usertype.getId()); 
			// 
			
			
			
		} else if (isDozentLoginSuccessfull) {
			Dozent dozent = DatabaseDozent.getDozentById(dozentenId);
			
			session.setAttribute("dozent", dozent);
			String type = ("dozent");
			UserType usertype = new UserType (dozentenId, "type");
			usertype.setId(dozentenId);
			usertype.setType(type);
			DatabaseUserType.addUsertype(usertype);
			
			session.setAttribute(type, usertype);
			
			
			request.getRequestDispatcher("studentenprofile.jsp").forward(request, response);
			
			System.out.println("Der Dozent Login ist erfolgreich");
		} else  {
			request.setAttribute("fehlermeldung", "Nutzername oder Passwort falsch. Bitte überprüfen sie ihre Daten.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
