package bitcamp.pms.controller.json;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;
import bitcamp.pms.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired MemberService memberService;

//리스트☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
    @RequestMapping("list")
    public Object list(@RequestParam(defaultValue = "1") int page,
                       @RequestParam(defaultValue = "3") int size) throws Exception {
        
//      if(page > 0 && size >0) {           
//      params.put("startIndex", (page - 1)* size);//페이지의 첫번째 리스트원
//      params.put("pageSize", size);
//  } 이게 기본이지만
        if (page < 1) page = 1;
        if (size < 1 || size > 20) size = 3;
        
        List<Member> list = memberService.list(page, size);
        
        HashMap<String, Object> data = new HashMap<>();
        
        data.put("list", list);
        data.put("page", page);
        data.put("size", size);
        data.put("totalPage", memberService.getTotalCount(size));
        // view url을 리턴
        return data;

    }

//add☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★    
    @GetMapping("form")
    public void form() {
//        return "member/form"; 이름이 같을 땐 굳이 리턴하지 않아도 된다. void:현재 path를 기준으로 그대로 리턴한다. 
    }

//  @PostMapping("add")
  @RequestMapping(value="add", method=RequestMethod.POST)
  public Object add(Member member) throws Exception {
      HashMap<String, Object> result = new HashMap<>();
      memberService.add(member);
      result.put("status", "success");
      
      return result;
  }

//삭제☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
  @RequestMapping("delete")
  public Object delete(String id) throws Exception {
      HashMap<String, Object> result = new HashMap<>();
      
      if (memberService.delete(id) == 0) {
          result.put("status","fail");
          result.put("error","해당 아이디가 없습니다.");
      } else {
          result.put("status", "success");
      }
      return result;
  }
//수정☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★

    @RequestMapping("update")
    public Object update(Member member) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
//                    (MemberDao) getServletContext().getAttribute("memberDao");               
        if (memberService.update(member) == 0) {
            result.put("status","fail");
            result.put("error","해당 아이디가 없습니다.");
        } else {
            result.put("status", "success");
        }
        return result;

    }  
    
        
//조회☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
    @RequestMapping("view/{id}")
    public Object view(@PathVariable String id) throws Exception {
        // 조회할 때 @PathVariable 를 자주 쓴다.
//            MemberDao memberDao = 
//                    (MemberDao) getServletContext().getAttribute("memberDao");   
        HashMap<String,Object> data = new HashMap<>();
//        Member member = memberService.get(id);
//        model.addAttribute("member", member);
        data.put("member", memberService.get(id));
        return data;

    }
}