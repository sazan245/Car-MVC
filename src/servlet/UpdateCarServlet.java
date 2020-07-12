package servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.CarDao;
import dao.CarDaoImpl;

@WebServlet("/update")
@SuppressWarnings("serial")
public class UpdateCarServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = req.getParameter("userid");
		String name = req.getParameter("name");
		String model = req.getParameter("model");
		String color= req.getParameter("color");
		String vendor = req.getParameter("vendor");
		String price= req.getParameter("price");
		long prices = Long.parseLong(price);	
		CarDao carDao = new CarDaoImpl();
		carDao.update(userid, name, model, color, vendor, prices);
		req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
		
	}
	
}
