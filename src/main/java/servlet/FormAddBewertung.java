package servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bewertung.Bewertung;
import database.DatabaseBewertungen;
import user.User;
import validierung.checkFormAddBewertung;
import dozent.Dozent;
import exceptions.addBewertungException;
import seminar.Seminar;

/**
 * Servlet implementation class FormAddBewertung
 */
@WebServlet("/FormAddBewertung")
public class FormAddBewertung extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormAddBewertung() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int foliengestaltung = Integer.parseInt(request.getParameter("foliengestaltung"));
		int spraclichePresentation = Integer.parseInt(request.getParameter("spraclichePresentation"));

		int presentationstil = Integer.parseInt(request.getParameter("presentationstil"));

		int zeitlicheGestaltung = Integer.parseInt(request.getParameter("zeitlicheGestaltung"));
		int verstandnis = Integer.parseInt(request.getParameter("verstandnis"));
		int inhaltlicheAufbereitung = Integer.parseInt(request.getParameter("inhaltlicheAufbereitung"));
		int verknuepfungMitAnderen = Integer.parseInt(request.getParameter("verknuepfungMitAnderen"));
		int diskassionFuehrung = Integer.parseInt(request.getParameter("diskassionFuehrung"));
		int beteiligungDiskassionen = Integer.parseInt(request.getParameter("beteiligungDiskassionen"));
		String kommentar = request.getParameter("kommentar");

		HttpSession session = request.getSession();
		Seminar seminar = (Seminar) session.getAttribute("seminar");
		User user = (User) session.getAttribute("user");
		int id = seminar.getZugewissenerStudent().getId();
		int bewerterId = user.getId();	
		int seminarId = seminar.getId();
		// FOR ANAS:::::
		if (!user.isUserStudent()) {
			// TODO hinzufüge hier extra details... mit set methoden..
//			 @param umfang
//			 * @param referenzen
//			 * @param sprachlicheGestaltung
//			 * @param schwerigkeitsgrad
		}

		Bewertung bewertung = new Bewertung(id, foliengestaltung, spraclichePresentation, presentationstil,
				zeitlicheGestaltung, verstandnis, inhaltlicheAufbereitung, verknuepfungMitAnderen, diskassionFuehrung,
				beteiligungDiskassionen, kommentar, bewerterId, seminarId);

		checkFormAddBewertung cf = new checkFormAddBewertung();
		Map result = cf.checkForm(kommentar);
		if (result.size() == 0) {

			try {
				DatabaseBewertungen.addBewertung(bewertung);
			} catch (addBewertungException e) {
				// TODO Auto-generated catch block
				request.getRequestDispatcher("toAddBewertung").forward(request, response);
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
			request.getRequestDispatcher("addBewertung.jsp").forward(request, response);
		}

//		System.out.println("foliengestaltung = "+foliengestaltung );
//		System.out.println("spraclichePresentation = "+spraclichePresentation );
//		System.out.println("presentationstil = "+presentationstil );
//		System.out.println("zeitlicheGestaltung = "+zeitlicheGestaltung );
//		System.out.println("verstandnis = "+verstandnis );
//		System.out.println("inhaltlicheAufbereitung = "+inhaltlicheAufbereitung );
//		System.out.println("verknuepfungMitAnderen = "+verknuepfungMitAnderen );
//		System.out.println("diskassionFuehrung = "+diskassionFuehrung );
//		System.out.println("beteiligungDiskassionen = "+beteiligungDiskassionen );
//		System.out.println("kommentar = "+kommentar );

	}

}
