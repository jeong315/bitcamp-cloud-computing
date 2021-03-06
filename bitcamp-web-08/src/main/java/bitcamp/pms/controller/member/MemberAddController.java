package bitcamp.pms.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.View;

import bitcamp.pms.annotation.RequestMapping;
import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;

public class MemberAddController {
    
    MemberDao memberDao;
   
    public MemberAddController(MemberDao memberDao) {
        super();
        this.memberDao = memberDao;
    }
    
    @RequestMapping
    public String add (HttpServletRequest request, HttpServletResponse response) throws Exception {
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
