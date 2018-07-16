package bitcamp.pms.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.controller.PageController;
import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;

public class MemberUpdateController implements PageController{
   
    MemberDao memberDao;
 
    public MemberUpdateController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public String service(HttpServletRequest request, HttpServletResponse response) throws Exception {
           
            Member member = new Member();
            member.setId(request.getParameter("id"));
            member.setEmail(request.getParameter("email"));
            member.setPassword(request.getParameter("password"));
     
//                    (MemberDao) getServletContext().getAttribute("memberDao");               
            if (memberDao.update(member) == 0) {
                return "/member/updatefail.jsp";
            } else {
               return "redirect:list";
            }
  
    }
    
}