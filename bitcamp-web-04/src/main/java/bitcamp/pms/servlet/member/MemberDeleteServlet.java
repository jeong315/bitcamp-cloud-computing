package bitcamp.pms.servlet.member;

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

import bitcamp.pms.dao.MemberDao;


@SuppressWarnings("serial")
@WebServlet("/member/delete")
public class MemberDeleteServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
//        super.doGet(request, response);
        
        
        
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        
//        out.println("<!DOCTYPE html>");
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<meta charset='UTF-8'>");
//        out.println("<meta http-equiv='Refresh' content='1;url=list'>");
//        out.println("<title>게시물 삭제</title>");
//        out.println("</head>");
//        out.println("<body>");
//        out.println("<h1>게시물 삭제 결과</h1>");
        
        MemberDao memberDao = (MemberDao)getServletContext().getAttribute("memberDao");
        try {
            
           memberDao.delete(request.getParameter("id"));
           response.sendRedirect("list");
//                out.println("<p>해당 회원이 없습니다.</p>");
//            } else {
//                out.println("<p>삭제하였습니다.</p>");
//            }
    
        } catch (Exception e) {
//            out.println("<p>삭제 실패!</p>");
//            e.printStackTrace(out);
            request.setAttribute("error", e);          
            RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
//        out.println("</body>");
//        out.println("</html>");
    }

}
