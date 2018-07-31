package bitcamp.pms.servlet.classroom;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/classroom/add")
public class ClassroomAddServlet extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Date classDate = new Date();
        
        request.setCharacterEncoding("UTF-8");
        
//        Classroom classroom = new Classroom();
//        classroom.setTitle(request.getParameter("title"));
//        classroom.setStartDate(Date.valueOf(request.getParameter("startDate")));
//        classroom.setEndDate(Date.valueOf(request.getParameter("endDate")));
//        classroom.setRoom(request.getParameter("room"));
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta http-equiv='Refresh' content='1;url=list'>");
        out.println("<title>강의 등록</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>강의 등록 결과</h1>");
        
        try {
//            classroomDao.insert(classroom);
            
            Class.forName("com.mysql.jdbc.Driver");
            try (
                Connection con = DriverManager.getConnection(
                    "jdbc:mysql://52.79.189.185:3306/studydb",
                    "study", "1111");
                PreparedStatement stmt = con.prepareStatement(
                    "insert into pms2_classroom(titl,sdt,edt,room) values(?,?,?,?)");) {
                
//                Calendar.getInstance(Locale.KOREAN)
                
                stmt.setString(1, request.getParameter("title"));
//                stmt.setDate(2, Date.valueOf(request.getParameter("startDate")),Calendar.getInstance(Locale.KOREAN));
//                stmt.setDate(3, Date.valueOf(request.getParameter("endDate")),Calendar.getInstance(Locale.KOREAN));
                stmt.setString(4, request.getParameter("room"));
                stmt.setDate(2, classDate.compareTo(request.getParameter("startDate")));
            
                stmt.executeUpdate();
            }
            
            out.println("<p>등록 성공!</p>");
        } catch (Exception e) {
            out.println("<p>등록 실패!</p>");
            e.printStackTrace(out);
        }
        out.println("</body>");
        out.println("</html>");
        
    }

}
