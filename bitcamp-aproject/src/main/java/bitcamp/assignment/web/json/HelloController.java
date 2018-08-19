package bitcamp.assignment.web.json;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    //임시 페이지 컨트롤러 만들기
    @RequestMapping("/hello")
    public Object hello() {  //RestController와 Object는 짝꿍?
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", "길동");
        
        return result;
    }
}
