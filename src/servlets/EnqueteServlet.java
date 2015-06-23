package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.StudentDAO;
import domein.Student;

@SuppressWarnings("serial")
public class EnqueteServlet extends HttpServlet {
	private Student s = new Student();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Student stud = (Student) req.getSession().getAttribute("student");
		System.out.println("stud " + stud.getCode());
		s.setCode(stud.getCode());
		s.setSchool(req.getParameter("school"));
		s.setJaar(req.getParameter("lesjaar"));
		s.setProfiel(req.getParameter("profiel"));
		s.setNiveau(req.getParameter("niveau"));
		s.setGeslacht(req.getParameter("geslacht"));
		s.setGemCijfer(req.getParameter("gemWisCijfer"));
		String datum = req.getParameter("blijvenZitten");
		s.setIsBlijvenZitten(datum);
		req.getSession().setAttribute("huidigeStudent", s);
		RequestDispatcher rd = null;
		rd = req.getRequestDispatcher("enquete-inzicht.jsp");
		rd.forward(req, resp);
	}
}
