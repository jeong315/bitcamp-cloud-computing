package bitcamp.mvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller 
@RequestMapping("/exam04_99") 
public class Exam04_99 {
    
    @RequestMapping(value="ok", params= {"num","who"}, method=RequestMethod.GET)
    @ResponseBody
    public String m6() {
        return "I hate you. go fuck up";
    }
}
