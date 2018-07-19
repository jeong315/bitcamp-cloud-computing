package bitcamp.pms.controller;

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

import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberDao memberDao;

//    public MemberListController() {}     

//    public MemberListController(MemberDao memberDao) {
//        this.memberDao = memberDao;
//    }   
//    @Autowired
//    public void setMemberDao(MemberDao memberDao) {
//        this.memberDao = memberDao;
//    }
//리스트☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
    @RequestMapping("list")
    public String list(@RequestParam(defaultValue = "1") int page,
                       @RequestParam(defaultValue = "3") int size,
                          Model model) throws Exception {

        // DB에서 가져올 데이터의 페이지 정보
        HashMap<String, Object> params = new HashMap<>();

//        if(page > 0 && size >0) {           
//            params.put("startIndex", (page - 1)* size);//페이지의 첫번째 리스트원
//            params.put("pageSize", size);
//        } 이게 기본이지만

        if (page < 1) page = 1;
        if (size < 1 || size > 20) size = 3;

        params.put("startIndex", (page - 1) * size);// 페이지의 첫번째 리스트원
        params.put("pageSize", size);

//        response.setContentType("text/html;charset=UTF-8");

        List<Member> list = memberDao.selectList(params);
        model.addAttribute("list", list);

        // view url을 리턴
        return "member/list";

    }

//add☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★    
    @GetMapping("form")
    public void form() {
//        return "member/form"; 이름이 같을 땐 굳이 리턴하지 않아도 된다. void:현재 path를 기준으로 그대로 리턴한다. 
    }

//    @PostMapping("add")
    @RequestMapping(value="add", method=RequestMethod.POST)
    public String add(Member member) throws Exception {

        System.out.println("ddd");
        memberDao.insert(member);
        return "redirect:list";
    }

//삭제☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
    @RequestMapping("delete")
    public String delete(String id) throws Exception {

        memberDao.delete(id);
        return "redirect: list";

    }
//수정☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
    @RequestMapping("update")
    public String update(Member member) throws Exception {

//                    (MemberDao) getServletContext().getAttribute("memberDao");               
        if (memberDao.update(member) == 0) {
            return "member/updatefail";
        } else {
            return "redirect:list";
        }

    }

//조회☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
    @RequestMapping("view/{id}")
    public String view(@PathVariable String id, Model model) throws Exception {
        // 조회할 때 @PathVariable 를 자주 쓴다.
//            MemberDao memberDao = 
//                    (MemberDao) getServletContext().getAttribute("memberDao");

        Member member = memberDao.selectOne(id);
        model.addAttribute("member", member);
        return "member/view";

    }
}