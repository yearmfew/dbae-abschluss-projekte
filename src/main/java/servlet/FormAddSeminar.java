package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seminar.Seminar;

/**
 * Servlet implementation class FormAddSeminar
 */
@WebServlet("/FormAddSeminar")
public class FormAddSeminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormAddSeminar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int dozentId = 3; // von session bekommen wird
		
		String titel = request.getParameter("titel");
		String thema = request.getParameter("thema");
		String oberbegriff = request.getParameter("oberbegriff");
		String beschreibung = request.getParameter("beschreibung");
		String semester = request.getParameter("semester");
		
		Seminar seminar = new Seminar(titel, dozentId, oberbegriff, beschreibung, thema, semester, false );
		
		boolean result = database.DatabaseSeminaren.addSeminar(seminar);
		
		if(result) request.getRequestDispatcher("seminaren.jsp").forward(request, response);	
		
	}

}
