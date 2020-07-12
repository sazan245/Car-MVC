package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CarDao;
import dao.CarDaoImpl;
import dao.entity.CarEntity;

@SuppressWarnings("serial")
@WebServlet("/car")
public class CarsServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CarDao carDao = new CarDaoImpl();
		List<CarEntity>carlist = carDao.findAll();
		req.setAttribute("carlist", carlist);
		req.getRequestDispatcher("showcar.jsp").forward(req, resp);
	}
}
