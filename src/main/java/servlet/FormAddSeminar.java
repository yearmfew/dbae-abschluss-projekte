package servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dozent.Dozent;
import exceptions.addSeminarException;
import seminar.Seminar;
import validierung.checkFormAddSeminar;
import validierung.checkFormEditSeminarData;

/**
 * @author Birol Yilmaz
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Dozent dozent = (Dozent) session.getAttribute("dozent");

		int dozentId = dozent.getId();
		String titel = request.getParameter("titel");
		String thema = request.getParameter("thema");
		String oberbegriff = request.getParameter("oberbegriff");
		String beschreibung = request.getParameter("beschreibung");
		String semester = request.getParameter("semester");

		checkFormAddSeminar cF = new checkFormAddSeminar();

		Map result = cF.checkForm(titel, thema, oberbegriff, beschreibung);

		if (result.size() == 0) {

			Seminar seminar = new Seminar(titel, dozentId, oberbegriff, beschreibung, thema, semester, false);

			try {
				database.DatabaseSeminaren.addSeminar(seminar);
			} catch (addSeminarException e) {
				request.getRequestDispatcher("initSeminaren").forward(request, response);
				e.printStackTrace();
				return;

			} finally {
				request.getRequestDispatcher("initSeminaren").forward(request, response);
			}
		} else {
			// fehler erklarungen erstellung mit for loop
			for (Object i : result.keySet()) {
				request.setAttribute((String) i, (String) result.get(i));
			}
			request.getRequestDispatcher("addSeminar.jsp").forward(request, response);
		}

	}

}
