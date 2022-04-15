package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DatabaseBewertungen;
import student.Student;

/**
 * Servlet implementation class toProfileDetails
 * @author Anas Souseh
 */
@WebServlet("/toProfileDetails")
public class toProfileDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public toProfileDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());	
		
		// Student student = database.DatabaseSeminaren.getSeminarById(Integer.parseInt(request.getParameter("seminarId")));
		Student student = database.DatabaseStudent.getStudentById(Integer.parseInt(request.getParameter("studentId")));
		HttpSession session = request.getSession();
		// ka ob das klappt
		int note = database.DatabaseBewertungen.getNoteVonBewertung(student.getId());
		int countOfBewertungen = DatabaseBewertungen.getCountOfBewertungenById(student.getId());
		student.setDurchnittlicheNote(note);
		student.setCountOfBewertungen(countOfBewertungen);
		session.setAttribute("student", student);
		request.getRequestDispatcher("profil.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
