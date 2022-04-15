package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import seminar.Seminar;
import student.Student;

/**
 * Servlet implementation class initProfil
 * @author Anas Souseh
 */
@WebServlet("/initProfil")
public class initProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			HttpSession session = request.getSession();

			ArrayList <Student> studenten = database.DatabaseStudent.getStudentData();
			session.setAttribute("studenten", studenten);
			
			request.getRequestDispatcher("studentenProfile.jsp").forward(request, response);

		}

	}