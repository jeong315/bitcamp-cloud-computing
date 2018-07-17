package bitcamp.mvc.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener{
    
    //Tomcat 서버가 시작,종료했을 때 알림을 받고 싶으면 ServletContextListener라는 규칙에 따라서 만들어라
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //시작
       System.out.println("contextInitialized()............");
    }
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //종료
        System.out.println("contextDestroyed().............");
    };
}
