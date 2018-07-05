package bitcamp.pms.servlet.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/member/list")
public class MemberListServlet extends HttpServlet{
    //ctrl+shift+o 자동완성
    /*
     * Servlet 클래스를 만들려면 서비스 인터페이스를 직접 구현 
     * 귀찮다면? 서블릿을 미리 구현한 제네릭서블릿을 상속받는다.
     * 벗 제네릭서블릿은 http 프로토콜에 관련된 기능을 다루는 메소드가 없다 
     * 그래서 상속받아서 http 클래스를 만들었고 제네릭을 상속받은 클래스를 상속 받을 것이다.
     * */

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>멤버 목록</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>멤버 목록</h1>");
        
        out.println("<p><a href='/bitcamp-web-02/memberForm.html'>새 회원</a></p>");
        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("    <th>아이디</th><th>이메일</th>");
        out.println("</tr>");
        
        try {
            Class.forName("com.mysql.jdbc.Driver");

            try (
                Connection con = DriverManager.getConnection(
                    "jdbc:mysql://52.79.189.185:3306/studydb",
                    "study", "1111");
                PreparedStatement stmt = con.prepareStatement(
                    "select mid, email from pms2_member");
                ResultSet rs = stmt.executeQuery();) {
                
                
                while (rs.next()) {
                    out.println("<tr>");
                    out.printf("    <td><a href='view?id=%s'>%s</a></td><td>%s</td>\n",
                            rs.getString("mid"),
                            rs.getString("mid"),
                            rs.getString("email"));
                    out.println("</tr>");
                    
                }
            }

        } catch (Exception e) {
            out.println("<tr><td>목록 가져오기 실패!</td></tr>");
            e.printStackTrace(out);
        }
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");

    }

}
