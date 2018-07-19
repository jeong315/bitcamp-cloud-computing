package bitcamp.mvc.web;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bitcamp.mvc.dao.BoardDao;

@Controller
@RequestMapping("/exam02_99")
public class Exam02_99 {
    
    BoardDao boardDao;  
    ServletContext servletContext;
    
   
    public Exam02_99(BoardDao boardDao, ServletContext servletContext){
        this.boardDao = boardDao;
        this.servletContext = servletContext;
    }
    
    @RequestMapping("/m2")
    @ResponseBody
    public String m2() {
        return servletContext.getContextPath();
    }
    
}
