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
 * Servlet implementation class link
 */
@WebServlet("/toSeminarDetails")
public class toSeminarDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public toSeminarDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		request.getRequestDispatcher("seminarDetails.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	


}
