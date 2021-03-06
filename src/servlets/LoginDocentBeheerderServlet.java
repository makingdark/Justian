package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import DAO.DocentDAO;
import domein.Docent;

public class LoginDocentBeheerderServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1681310498024724512L;
	private Docent d = new Docent();
	RequestDispatcher rd = null;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String email = req.getParameter("email");
		String wachtwoord = req.getParameter("wachtwoord");
		d = DocentDAO.getDocent(email, wachtwoord);
		if (d != null) {
			req.getSession().setAttribute("docent", d);
			if(d.getEmail().equals("justianmind@gmail.com")){
				req.getSession().setAttribute("beheerder", "justian");
			}
			rd = req.getRequestDispatcher("vraag-overzicht.jsp");
		} else {
			rd = req.getRequestDispatcher("/login-docent.jsp");
			req.setAttribute("msgs", "Email of wachtwoord bestaat niet");
		}
		rd.forward(req, resp);
	}

}
