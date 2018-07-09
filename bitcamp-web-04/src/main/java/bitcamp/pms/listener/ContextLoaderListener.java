package bitcamp.pms.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import bitcamp.pms.dao.BoardDao;
import bitcamp.pms.dao.MemberDao;

//톰캣서버에 리스너라고 선언
@WebListener
public class ContextLoaderListener implements ServletContextListener{
    //서버에서 보고받을 놈은 규칙을 지켜야 한다. = implements ServletContextListener
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextLoaderListener 실행~");
        MemberDao memberDao = new MemberDao(
                "jdbc:mysql://52.79.189.185:3306/studydb",
                "study","1111");
        BoardDao boardDao = new BoardDao(
                "jdbc:mysql://52.79.189.185:3306/studydb",
                "study","1111");
        
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("memberDao", memberDao);
        sc.setAttribute("boardDao", boardDao);
    }
}
