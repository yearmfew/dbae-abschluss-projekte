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

/**
 * Servlet implementation class initProfil
 */
@WebServlet("/initProfil")
public class initProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			HttpSession session = request.getSession();

			Student student = database.DatabaseProfilePage.getStudentData(0);
			session.setAttribute("student", student);

			request.getRequestDispatcher("profil.jsp").forward(request, response);

		}

	}