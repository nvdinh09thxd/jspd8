package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.News;
import dao.NewsDao;

public class PublicCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PublicCatController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idCat = 0;
		try {
			idCat = Integer.parseInt(request.getParameter("cid"));
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/cnews/PageNotFound.jsp");
			rd.forward(request, response);
			return;
		}
		ArrayList<News> listNewsByIdCat = NewsDao.getItemsByIdCat(idCat);
		request.setAttribute("listNewsByIdCat", listNewsByIdCat);
		RequestDispatcher rd = request.getRequestDispatcher("/cnews/cat.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
