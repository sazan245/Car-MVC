package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import car.utils.SQLConnectionUtil;


@WebServlet("/uploadPhoto")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)   // 50MB
public class UploadPhotoServlet extends HttpServlet {

	/**
     * Name of the directory where uploaded files will be saved, relative to
     * the web application directory.
     */
    private static final String SAVE_DIR = "uploadFiles";

        protected void doPost(HttpServletRequest request,
                HttpServletResponse response) throws ServletException, IOException {
            // gets values of text fields
            String name = request.getParameter("name");
            InputStream inputStream = null; // input stream of the upload file

            // obtains the upload file part in this multipart request
            Part filePart = request.getPart("photo");
            if (filePart != null) {
                // prints out some information for debugging
                System.out.println(filePart.getName());
                System.out.println(filePart.getSize());
                System.out.println(filePart.getContentType());
                // obtains input stream of the upload file
                inputStream = filePart.getInputStream();
            }
            Connection conn = null; // connection to the database
            String message = null;  // message will be sent back to client
            try {
                conn=SQLConnectionUtil.getConnection();
                // constructs SQL statement
                String sql = "INSERT INTO image_tbl (name, photo) values (?, ?)";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, name);

                if (inputStream != null) {
                    // fetches input stream of the upload file for the blob column
                    statement.setBlob(2, inputStream);
                }
                // sends the statement to the database server
                int row = statement.executeUpdate();
                if (row > 0) {
                    message = "File uploaded and saved into database";
                }
            } catch (Exception ex) {
                message = "ERROR: " + ex.getMessage();
                ex.printStackTrace();
            } finally {
                if (conn != null) {
                    // closes the database connection
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }

            // sets the message in request scope
            request.setAttribute("message", message);
            // forwards to the message page
            getServletContext().getRequestDispatcher("/upload.jsp").forward(request, response);
        }
    } 
