package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import car.utils.SQLConnectionUtil;




@SuppressWarnings("serial")
@WebServlet("/unlockBlockTime")
public class TimeBlocker  extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  String id=req.getParameter("pid");
		  try {
			  
			    Connection conn = SQLConnectionUtil.getConnection();
				String sql="update time_blocker_tbl set active='Yes' where pid = "+Integer.parseInt(id);
				//compiling the query
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.executeUpdate();
				
				String nosql="update time_blocker_tbl set active='No' where pid <> "+Integer.parseInt(id);
				pstmt=conn.prepareStatement(nosql);
				pstmt.executeUpdate();
				//Here I say go to users servlet
				//Now Forward request to blockTime Servlet to show fresh data from the data 
				 req.getRequestDispatcher("time").forward(req,resp);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		
	}

}
