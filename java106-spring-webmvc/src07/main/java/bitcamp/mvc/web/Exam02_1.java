// 페이지 컨트롤러에 의존 객체 주입하기 - 생성자 이용
package bitcamp.mvc.web;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bitcamp.mvc.dao.BoardDao;

//페이지 컨트롤러에 의존객체를 주입하는 방법
@Controller 
@RequestMapping("/exam02_1") 
public class Exam02_1 {

    BoardDao boardDao;
    
    // ServletContext를 주입 받을 때도 인스턴스 변수로 주입받는다.
    ServletContext servletContext;
    //요청 핸들러에 파라미터로 못받는다. ServletContext는 주입받아야함
    
    public Exam02_1(BoardDao boardDao, ServletContext servletContext) {
        this.boardDao = boardDao;
        this.servletContext = servletContext;
    }
    
    
    @RequestMapping("m1")  
    @ResponseBody  
    public String m1() {
        return "getServletContextName : "+this.servletContext.getServletContextName()
                +"\n getContextPath : "+this.servletContext.getContextPath();
    }
    
}
