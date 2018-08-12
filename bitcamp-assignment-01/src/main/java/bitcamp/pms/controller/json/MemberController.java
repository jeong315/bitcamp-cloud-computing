package bitcamp.pms.controller.json;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.pms.domain.Member;
import bitcamp.pms.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {
    
    @Autowired MemberService memberService;
    
  /*  @PostMapping("login")
    public Object login(Member member) throws Exception{
        HashMap<String, Object> result = new HashMap<>();
        
        if(memberService.login(member)==1) {
            result.put("status", "success");
        }else {
            result.put("status", "fail");
            result.put("error","해당 아이디가 없습니다.");
        }
        return null;
    }
    */
//    @GetMapping("joinform")
//    public void joinform() {
//    }
    @PostMapping("join")
    public Object add(Member member) throws Exception{
        HashMap<String, Object> result = new HashMap<>();
        System.out.println(member.getEmail()+":email");
        System.out.println(member.getName()+":email1");
        System.out.println(member.getPassword()+":email2");
        memberService.add(member);
        result.put("status", "success");
        return result;
    }
    
  /*  @RequestMapping("delete")
    public Object delete(String email) throws Exception{
        HashMap<String, Object> result = new HashMap<>();
        
        if(memberService.delete(email) == 0) {
            result.put("status", "fail");
            result.put("error","해당 아이디가 없습니다.");
        }else {
            result.put("status","success");
        }
        return result;
    }
    */
}
