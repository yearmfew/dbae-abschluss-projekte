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

import java.util.ArrayList;
/**
 * @author Birol Yilmaz
 * Servlet implementation class seminar
 */
@WebServlet("/initSeminaren")
public class initSeminaren extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public initSeminaren() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ArrayList <Seminar> seminaren = null;
		try {	
		seminaren = database.DatabaseSeminaren.getSeminarsData();
		}catch (seminarNotFoundException e){
			session.setAttribute("keinSeminarInDB", e.getMessage());
			e.printStackTrace();
			return;
		}
		session.setAttribute("seminaren", seminaren);
		request.getRequestDispatcher("seminaren.jsp").forward(request, response);

	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
