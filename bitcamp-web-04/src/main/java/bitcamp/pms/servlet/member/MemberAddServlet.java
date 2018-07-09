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
@WebServlet("/member/add")
public class MemberAddServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
//        request.setCharacterEncoding("UTF-8");
        
//        Member member = new Member();
//        member.setId(request.getParameter("id"));
//        member.setEmail(request.getParameter("email"));
//        member.setPassword(request.getParameter("password"));

        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();
        
        //버퍼에 저장 된 후 출력된다. 
//        out.println("<!DOCTYPE html>");
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<meta charset='UTF-8'>");
//        out.println("<meta http-equiv='Refresh' content='1;url=list'>");
//        
//        out.println("<title>회원 등록</title>");
//        out.println("</head>");
//        out.println("<body>");
//        out.println("<h1>회원 등록 결과</h1>");
        
        try {
            MemberDao memberDao = (MemberDao)this.getServletContext().getAttribute("memberDao");
            Member member = new Member();
            member.setId(request.getParameter("id"));
            member.setEmail(request.getParameter("email"));
            member.setPassword(request.getParameter("password"));
            
            memberDao.insert(member);
            response.sendRedirect("list");
            
//            out.println("<p>등록 성공!</p>");
    
        } catch (Exception e) {
//            out.println("<p>등록 실패!</p>");
//            e.printStackTrace(out);
            request.setAttribute("error", e);          
            RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
            rd.forward(request, response);
        }
//        out.println("</body>");
//        out.println("</html>");

//        response.sendRedirect("list");
    }


}
