package bitcamp.pms.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.controller.PageController;
import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;

public class MemberAddController implements PageController {
    
    MemberDao memberDao;
   
    public MemberAddController(MemberDao memberDao) {
        super();
        this.memberDao = memberDao;
    }

    public String service(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(request.getMethod().equals("GET")) {            
            return "/member/form.jsp";
        }
    
    
            Member member = new Member();      
            member.setId(request.getParameter("id"));
            member.setEmail(request.getParameter("email"));
            member.setPassword(request.getParameter("password"));
            
//            MemberDao memberDao = 
//                    (MemberDao) getServletContext().getAttribute("memberDao");
                 
            memberDao.insert(member);
            return "redirect:list";
}
    
}
