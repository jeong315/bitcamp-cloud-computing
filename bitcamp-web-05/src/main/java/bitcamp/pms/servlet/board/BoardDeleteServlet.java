package bitcamp.pms.servlet.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.dao.BoardDao;

@SuppressWarnings("serial")
@WebServlet("/board/delete")
public class BoardDeleteServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
        
//        out.println("<!DOCTYPE html>");
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<meta charset='UTF-8'>");
//        out.println("<meta http-equiv='Refresh' content='1;url=list'>");
//        out.println("<title>게시물 삭제</title>");
//        out.println("</head>");
//        out.println("<body>");
//        out.println("<h1>게시물 삭제 결과</h1>");
        
        
        try {
            BoardDao boardDao = (BoardDao)this.getServletContext().getAttribute("boardDao");
//            int count = boardDao.delete(no);
           
            boardDao.delete(Integer.parseInt(request.getParameter("no")));
            response.sendRedirect("list");

            
        } catch (Exception e) {
            request.setAttribute("error", e);
            RequestDispatcher rd = 
                    request.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
//            e.printStackTrace(out);
        }
//        out.println("</body>");
//        out.println("</html>");
        
    }

}
