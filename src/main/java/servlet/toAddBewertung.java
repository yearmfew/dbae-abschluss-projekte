package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exceptions.seminarNotFoundException;
import seminar.Seminar;

/**
 * @author Birol Yilmaz
 * Servlet implementation class toAddBewertung
 */
@WebServlet("/toAddBewertung")
public class toAddBewertung extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public toAddBewertung() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Seminar seminar = null;
		try {
			seminar = database.DatabaseSeminaren.getSeminarById(Integer.parseInt(request.getParameter("seminarId")));
			//seminar = database.DatabaseSeminaren.getSeminarById(1234);
		} catch (seminarNotFoundException e) {
			request.getRequestDispatcher("initSeminaren").forward(request, response);
			session.setAttribute("seminarNotFound", e.getMessage());
			e.printStackTrace();
			return;
		}
		
		session.setAttribute("seminar", seminar);
		request.getRequestDispatcher("addBewertung.jsp").forward(request, response);

		
	}

	

}
