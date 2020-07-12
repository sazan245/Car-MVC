package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CarDao;
import dao.CarDaoImpl;

@SuppressWarnings("serial")
@WebServlet("/deleteCar")
public class DeleteCarServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userid = req.getParameter("userid");
		CarDao carDao = new CarDaoImpl();
		carDao.deleteByEmailId(userid);
		req.setAttribute("list", new ArrayList<>());
		req.getRequestDispatcher("showcar.jsp").forward(req, resp);
	}
}
