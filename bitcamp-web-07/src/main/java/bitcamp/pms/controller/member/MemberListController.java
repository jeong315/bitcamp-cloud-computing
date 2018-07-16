package bitcamp.pms.controller.member;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.controller.PageController;
import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;

public class MemberListController implements PageController{

    MemberDao memberDao;
    
    public MemberListController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
    
    public String service(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
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