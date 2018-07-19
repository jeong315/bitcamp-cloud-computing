package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam03_99")
public class Exam03_99 {

    @ResponseBody
    @GetMapping("m1")
    public String m1() {
        return "kkokko-get";
    }
    
    @ResponseBody
    @RequestMapping(value="/m2", method=RequestMethod.POST)
    public String m2() {
        return "bal-post";
    }
    
}
