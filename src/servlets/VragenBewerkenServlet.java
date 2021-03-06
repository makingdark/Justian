package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Text;

import domein.Vraag;
import DAO.VraagDAO;

@SuppressWarnings("serial")
public class VragenBewerkenServlet extends HttpServlet{
	
	private Vraag v = new Vraag();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String blob = "";
		String msgs = "";
		RequestDispatcher rd = null;
		
		v = (Vraag) req.getSession().getAttribute("vraagbewerk");
		
		String y = "";
		y = y + req.getParameter("rekenmachine");
	
		if (y.equals("true")){
			v.setRekenmachine(true);
		}
		
		v.setNummer(Integer.parseInt(req.getSession().getAttribute("vraagNummer").toString()));		
		v.setType(req.getSession().getAttribute("categorie").toString());
		v.setContext(req.getParameter("context"));
		v.setVraagstelling(req.getParameter("opgave"));
		v.setAntwoord(req.getParameter("antwoord"));
		
		//blob = iets parse van de afbeelding??? TODO
		//v.setBlobAfbeelding(blob);
		
		VraagDAO.updateVraag(v);
		
		msgs = "Vraag is aangepast";
		req.setAttribute("msgs", msgs);
		rd = req.getRequestDispatcher("/vraag-overzicht.jsp");
		
		rd.forward(req, resp);
		
	}
}
