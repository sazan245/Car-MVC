package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car.utils.SQLConnectionUtil;


@WebServlet("/photos")
public class ImageServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			Map<Integer, String> map=new LinkedHashMap<>();
			Connection  conn=SQLConnectionUtil.getConnection();
            // constructs SQL statement
            String sql = "select pid,name from image_tbl";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()) {
            	map.put(resultSet.getInt(1), resultSet.getString(2));
            }
            req.setAttribute("mapa", map);
            req.getRequestDispatcher("showPhotos.jsp").forward(req, resp);

        } catch (Exception ex) {
            ex.printStackTrace();
        } 

	}
}
