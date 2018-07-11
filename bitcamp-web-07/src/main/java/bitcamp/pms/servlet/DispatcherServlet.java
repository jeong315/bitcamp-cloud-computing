package bitcamp.pms.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.controller.PageController;

@SuppressWarnings("serial")
@WebServlet("/app/*")
public class DispatcherServlet extends HttpServlet{
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //클라이언트가 요청한 서비스 URL을 알아낸다.
        // 즉/app/* 에서 *에 해당하는 값을 추출한다.
        // 예) /app/member/list => /member/list를 추출한다.
            String pathInfo = request.getPathInfo();
            
            response.setContentType("text/html;charset=UTF-8");
            
            //ServletContext 보관소에 저장된 페이지 컨트롤러를 찾는다.
            PageController pageController = (PageController)request.getServletContext().getAttribute(pathInfo);
            

            
//            RequestDispatcher rd = request.getRequestDispatcher(pathInfo);
//            rd.include(request, response);
            //보내고 다시 돌아온다. 
            //페이지 컨트롤러를 실행한다.
            try {
                if (pageController == null) {
                    throw new Exception("해당 URL에 대해 처리할 수 없습니다. ");
                }
                
                String view = pageController.service(request, response);
                if(view.startsWith("redirect:")) {
                    response.sendRedirect(view.substring(9));
                }else {
                    RequestDispatcher rd = request.getRequestDispatcher(view); 
//                    rd = request.getRequestDispatcher(view);
                    rd.include(request, response);
                }
            } catch(Exception e) {
               request.setAttribute("error", e);
                RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
                rd.forward(request, response);
            }
            // 페이지 컨트롤러가 실행을 끝낸 후 view 이름으로 저장한 jsp를 실행한다.
//            System.out.println(view+"===========");
//           else {
//                rd = request.getRequestDispatcher("/error.jsp");
//                //얜 걍 보내버림
//            }
            
            
            
            
            
            
            
            

    }

}
