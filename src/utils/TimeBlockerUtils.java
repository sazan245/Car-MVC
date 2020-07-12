package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;

import javax.servlet.ServletContext;

import car.utils.SQLConnectionUtil;
import car.utils.SQLQuery;

public class TimeBlockerUtils {
	public static  void updateTimeBlocker(ServletContext servletContext) { 			
 			try (Connection conn =  SQLConnectionUtil.getConnection();
 					PreparedStatement pstmt = conn.prepareStatement(SQLQuery.TIME_SELECTED);
 					ResultSet rs = pstmt.executeQuery();) {
 				while (rs.next()) {				
 					Time startTime=rs.getTime(1);
 	 				Time endTime=rs.getTime(2);
 	 				long startTimeInMillis=startTime.getHours()*60*60*1000+startTime.getMinutes()*60*1000+startTime.getSeconds()*1000;
 	 				long endTimeInMillis=endTime.getHours()*60*60*1000+endTime.getMinutes()*60*1000+endTime.getSeconds()*1000;
 	 				servletContext.setAttribute("startTimeInMillis", startTimeInMillis);
 	 				servletContext.setAttribute("endTimeInMillis", endTimeInMillis);
 	 				servletContext.setAttribute("blockerTimeFlag",0);
 				}
 		
 		}catch(Exception e) {
 			e.printStackTrace();
 		}
	}


}
