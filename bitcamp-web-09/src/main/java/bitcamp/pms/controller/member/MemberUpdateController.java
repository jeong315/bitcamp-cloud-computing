package bitcamp.pms.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.annotation.AutoWired;
import bitcamp.pms.annotation.Controller;
import bitcamp.pms.annotation.RequestMapping;
import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;

@Controller("/member/update")
public class MemberUpdateController {
   
    MemberDao memberDao;
    public MemberUpdateController() {}
    
    public MemberUpdateController(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @AutoWired
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }
    
    @RequestMapping
    public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {
           
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