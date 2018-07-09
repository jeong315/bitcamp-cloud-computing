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
import bitcamp.pms.domain.Member;

@SuppressWarnings("serial")
@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
//        super.doPost(request, response);
//        request.setCharacterEncoding("UTF-8");
        
        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
//        
//        out.println("<!DOCTYPE html>");
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<meta charset='UTF-8'>");
//        out.println("<meta http-equiv='Refresh' content='1;url=list'>");
//        out.println("<title>회원 변경</title>");
//        out.println("</head>");
//        out.println("<body>");
//        out.println("<h1>회원 변경 결과</h1>");
        
        try {
            Member member = new Member();
            member.setId(request.getParameter("id"));
            member.setEmail(request.getParameter("email"));
            member.setPassword(request.getParameter("password"));
            
            MemberDao memberDao = (MemberDao)getServletContext().getAttribute("memberDao");
            
            if(memberDao.update(member) == 0) {
//                out.println("<p>해당 회원이 존재하지 않습니다.</p>");
//                throw new Exception("해당 회원이 존재하지 않습니다.");

                RequestDispatcher rd = request.getRequestDispatcher("/member/updatefail.jsp");
                rd.forward(request, response);
            }else {
//                out.println("<p>변경하였습니다.</p>");
                response.sendRedirect("list");
            }
            
//            int count = memberDao.update(member);
        } catch (Exception e) {
//            out.println("<p>변경 실패!</p>");
//            e.printStackTrace(out);
            request.setAttribute("error", e);          
            RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
//        out.println("</body>");
//        out.println("</html>");
    }

    
}
