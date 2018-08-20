package bitcamp.assignment.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    //임시 페이지 컨트롤러 만들기
    @RequestMapping("/hello")
    public void hello(Model model) {
        model.addAttribute("name","홍길동");
    }
    
}