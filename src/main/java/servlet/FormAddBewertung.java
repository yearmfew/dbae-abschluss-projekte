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
 * @author Birol Yilmaz, Anas Souseh Servlet implementation class
 *         FormAddBewertung
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

		Bewertung bewertung = new Bewertung(id, foliengestaltung, spraclichePresentation, presentationstil,
				zeitlicheGestaltung, verstandnis, inhaltlicheAufbereitung, verknuepfungMitAnderen, diskassionFuehrung,
				beteiligungDiskassionen, kommentar, bewerterId, seminarId);

		checkFormAddBewertung cf = new checkFormAddBewertung();

		// ANAS:::::
		if (!user.isUserStudent()) {

			// anforderung 8
			// ausarbeitungsbewertung durch dozent

			int umfang = Integer.parseInt(request.getParameter("umfang"));
			int referenzen = Integer.parseInt(request.getParameter("referenzen"));
			int sprachlicheGestaltung = Integer.parseInt(request.getParameter("sprachlicheGestaltung"));
			int schwierigkeitsgrad = Integer.parseInt(request.getParameter("schwierigkeitsgrad"));

			// methoden welche zur sp??ter zu datenbank geschickt werden
			bewertung.setUmfang(umfang);
			bewertung.setReferenzen(referenzen);
			bewertung.setSprachlicheGestaltung(sprachlicheGestaltung);
			bewertung.setSchwerigkeitsgrad(schwierigkeitsgrad);

			// berechne Note und gebe die auf profil des studenten aus

			// checkform welches pr??ft ob der user falsche daten f??r benotung eingibt
			Map ergebnis = cf.checkForm(foliengestaltung, spraclichePresentation, presentationstil, zeitlicheGestaltung,
					verstandnis, inhaltlicheAufbereitung, verknuepfungMitAnderen, diskassionFuehrung,
					beteiligungDiskassionen, umfang, referenzen, sprachlicheGestaltung, schwierigkeitsgrad);
			if (ergebnis.size() == 0) {
				System.out.println("keine fehler bei bewertung pr??fung");
			} else {
				// fehler erklarungen erstellung mit for loop
				for (Object i : ergebnis.keySet()) {
					request.setAttribute((String) i, (String) ergebnis.get(i));
				}
				System.out.println("es gibt fehler bei bewertungpr??fung");
				request.getRequestDispatcher("addBewertung.jsp").forward(request, response);
			}

		}

		Map result = cf.checkForm(kommentar);
		if (result.size() == 0) {

			try {
				DatabaseBewertungen.addBewertung(bewertung);

			} catch (addBewertungException e) {
				request.getRequestDispatcher("toAddBewertung").forward(request, response);
				e.printStackTrace();
				return;
			} finally {
				request.getRequestDispatcher("initSeminaren").forward(request, response);
			}
		} else {
			// warnhinweise ausgeben durch validierung for loop
			for (Object i : result.keySet()) {
				request.setAttribute((String) i, (String) result.get(i));
			}
			request.getRequestDispatcher("addBewertung.jsp").forward(request, response);
		}

	}

}
