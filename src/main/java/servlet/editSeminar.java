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
import dozent.Dozent;
import exceptions.seminarNotFoundException;

/**
 * @author Birol Yilmaz Servlet implementation class editSeminar
 */
@WebServlet("/editSeminar")
public class editSeminar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editSeminar() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Seminar mySeminar = null;

		try {
			mySeminar = database.DatabaseSeminaren.getSeminarById(Integer.parseInt(request.getParameter("seminarId")));
			// mySeminar = database.DatabaseSeminaren.getSeminarById(1234);
		} catch (seminarNotFoundException e) {
			request.getRequestDispatcher("initSeminaren").forward(request, response);
			e.printStackTrace();
			return;
		}

		ArrayList<Dozent> dozenten = database.DatabaseDozent.getAllDozenten();

		HttpSession session = request.getSession();
		session.setAttribute("seminar", mySeminar);
		session.setAttribute("dozenten", dozenten);
		request.getRequestDispatcher("editSeminar.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
