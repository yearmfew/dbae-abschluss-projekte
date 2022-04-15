package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DatabaseBewertungen;
import database.DatabaseStudent;
import student.Student;

/**
 *@author Birol Yilmaz 
 * Servlet implementation class toProfil
 */
@WebServlet("/toProfil")
public class toProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public toProfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int studentId = Integer.parseInt(request.getParameter("studentId"));  
		
		Student student = DatabaseStudent.getStudentById(studentId);
		
		
		int countOfBewertungen = DatabaseBewertungen.getCountOfBewertungenById(student.getId());
		int durchnittlicheNote = DatabaseBewertungen.getNoteVonBewertung(student.getId());
		student.setCountOfBewertungen(countOfBewertungen);
		student.setDurchnittlicheNote(durchnittlicheNote);
		session.setAttribute("student", student);
		request.getRequestDispatcher("profil.jsp").forward(request, response);
	}

}
