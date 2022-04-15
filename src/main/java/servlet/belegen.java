package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.User;

/**
 * 
 * @author Birol Yilmaz
 *
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
		HttpSession session = request.getSession();
		int seminarId = Integer.parseInt(request.getParameter("seminarId"));
	    User user = (User) session.getAttribute("user");
	    int studentId = user.getId();
	    try {
	    	
	    	database.DatabaseSeminaren.belegSeminar(seminarId, studentId);
	    }catch(Exception e) {
	    	session.setAttribute("schonBelegtFehler", "Sie sind schon in einem Seminer Belegt..");
	    	request.getRequestDispatcher("initSeminaren").forward(request, response);
	    }
	    	request.getRequestDispatcher("initSeminaren").forward(request, response);	
	    
	    
	    
	    
	}


}
