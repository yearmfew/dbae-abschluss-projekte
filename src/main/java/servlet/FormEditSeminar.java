package servlet;

import java.io.IOException;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import seminar.Seminar;
import validierung.checkFormEditSeminarData;

/**
 * @author Birol Yilmaz
 * Servlet implementation class FormEditSeminar
 */
@WebServlet("/FormEditSeminar")
public class FormEditSeminar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormEditSeminar() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		HttpSession session = request.getSession();
		Seminar seminar = (Seminar) session.getAttribute("seminar");

		String titel = seminar.getTitel();
		String thema = seminar.getThema();
		String oberbegriff = seminar.getOberbegriff();
		String beschreibung = seminar.getBeschreibung();
		String semester = seminar.getSemester();
		int dozentId = seminar.getDozent().getId();
		
		if(request.getParameter("titel") !="") titel = request.getParameter("titel");
		if(request.getParameter("thema") !="") thema = request.getParameter("thema");
		if(request.getParameter("oberbegriff") !="") oberbegriff = request.getParameter("oberbegriff");
		if(request.getParameter("beschreibung") !="") beschreibung = request.getParameter("beschreibung");
		if(request.getParameter("semester") !="") semester = request.getParameter("semester");
		if(request.getParameter("dozentId") != null) dozentId = Integer.parseInt(request.getParameter("dozentId"));

		// check for anführung zeichnen usw...
		checkFormEditSeminarData cF = new checkFormEditSeminarData();

		Map result = cF.checkForm(titel, dozentId, thema, oberbegriff, beschreibung, semester);
		
		if (result.size() == 0) {
			// update here seminar table
			Seminar updatedSeminer = new Seminar(seminar.getId(), titel, dozentId, oberbegriff, beschreibung, thema, semester, seminar.getStatus());
			
			
			try {			
				database.DatabaseSeminaren.updateSeminar(updatedSeminer);
			}catch(Exception updateSeminarException){
				updateSeminarException.printStackTrace();
				request.getRequestDispatcher("initSeminaren").forward(request, response);
			}finally {
				
				session.setAttribute("seminar", updatedSeminer);
				request.getRequestDispatcher("initSeminaren").forward(request, response);	
			}
			
		} else {
			// fehler erklarungen erstellung mit for loop
			for (Object i : result.keySet()) {
				request.setAttribute((String) i, (String) result.get(i));
			 }
			request.getRequestDispatcher("editSeminar.jsp").forward(request, response);
		}
		

	}

}
