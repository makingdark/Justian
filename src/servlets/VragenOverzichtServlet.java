package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Text;

import DAO.ToetsDAO;
import domein.Vraag;

public class VragenOverzichtServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
	int nummer = Integer.parseInt(req.getParameter("vraagnummer"));
	
	Vraag x = new Vraag();
	x = ToetsDAO.getVraagByNr(nummer);
	
	req.getSession().setAttribute("vraagbewerk", x);
	req.getSession().setAttribute("vraagNummer", nummer);
	req.getSession().setAttribute("context", x.getContext());
	req.getSession().setAttribute("antwoord", x.getAntwoord());
	req.getSession().setAttribute("opgave", x.getVraagstelling());
	req.getSession().setAttribute("rekenmachine", x.isRekenmachine());
	req.getSession().setAttribute("categorie", x.getType());
	if(x.getAfbeelding() == null||x.getAfbeelding().equals("NULL")){
		Text blob = new Text("iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAAYdEVYdFNvZnR3YXJlAHBhaW50Lm5ldCA0LjAuNWWFMmUAAAANSURBVBhXY/j//z8DAAj8Av6IXwbgAAAAAElFTkSuQmCC");
		x.setAfbeelding(blob);
	}
	System.out.println("afbeelding " + x.getAfbeelding());
	req.getSession().setAttribute("afbeelding", x.getAfbeelding());
		
	String s =(String) req.getSession().getAttribute("context");
	if(s.equals("NULL")){
		s = "";
	}
	
	req.getSession().setAttribute("context", s);
	
	
	RequestDispatcher rd = null;
	rd = req.getRequestDispatcher("/vraag-bewerken.jsp");
	rd.forward(req, resp);
	
	
	}
	
}
