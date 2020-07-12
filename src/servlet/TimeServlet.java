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
import dao.entity.TimeEntity;






@SuppressWarnings("serial")
@WebServlet("/time")
public class TimeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		    CarDao car =new CarDaoImpl();
		    List<TimeEntity>  timeList= car.findTime();
		  req.setAttribute("timeList", timeList);
		  req.getRequestDispatcher("TimeShow.jsp").forward(req, resp);
	}
}