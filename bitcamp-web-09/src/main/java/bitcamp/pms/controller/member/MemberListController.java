package bitcamp.pms.controller.member;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.annotation.AutoWired;
import bitcamp.pms.annotation.Controller;
import bitcamp.pms.annotation.RequestMapping;
import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;

@Controller("/member/list")
public class MemberListController {

    MemberDao memberDao;   
    public MemberListController() {} 
    
    public MemberListController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
    
    @AutoWired
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
    
    @RequestMapping
    public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        //DB에서 가져올 데이터의 페이지 정보
        HashMap<String, Object> params = new HashMap<>();
        
        if(request.getParameter("page") != null && request.getParameter("size") != null) {
            int page = Integer.parseInt(request.getParameter("page"));
            int size = Integer.parseInt(request.getParameter("size"));
            
            params.put("startIndex", (page - 1)* size);//페이지의 첫번째 리스트원
            params.put("pageSize", size);
        }
                
        response.setContentType("text/html;charset=UTF-8");
       
            List<Member> list = memberDao.selectList(params);
            request.setAttribute("list", list);
            
            //view url을 리턴
            return "/member/list.jsp";

    }   
}