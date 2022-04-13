package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class belegen
 */
@WebServlet("/belegen")
public class belegen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public belegen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int seminarId = Integer.parseInt(request.getParameter("seminarId"));
	    int studentId = 0; // wird von session holen
	    boolean result = database.DatabaseSeminaren.belegSeminar(seminarId, studentId);
	    if(result) request.getRequestDispatcher("initSeminaren").forward(request, response);	
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		// int seminarId = Integer.parseInt(request.getParameter("seminarId"));
		// System.out.println("hello.:  "+ seminarId);

	}

}
