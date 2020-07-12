package servlet;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CarDao;
import dao.CarDaoImpl;
import dao.entity.CarEntity;

@SuppressWarnings("serial")
@WebServlet("/auth")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = req.getParameter("userid");
		String password = req.getParameter("password");
		CarDao carDao = new CarDaoImpl();
		Optional<CarEntity> optional = carDao.findLoginUser(userid, password);
		if (optional.isPresent()) {
			req.setAttribute("userData", optional.get());
			HttpSession session=req.getSession();
		    session.setAttribute("userData", optional.get());
			req.getRequestDispatcher("dashboard.jsp").forward(req, resp);
		} else {
			req.setAttribute("message", "Sorry username and password are not valid!");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
