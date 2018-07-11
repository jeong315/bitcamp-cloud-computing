package bitcamp.pms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;


public class MemberViewController implements PageController{
    
    MemberDao memberDao;
    

    
    public MemberViewController(MemberDao memberDao) {
        super();
        this.memberDao = memberDao;
    }

    public String service (
            HttpServletRequest request, 
            HttpServletResponse response) throws Exception {

        String id = request.getParameter("id");
        response.setContentType("text/html;charset=UTF-8");
//            MemberDao memberDao = 
//                    (MemberDao) getServletContext().getAttribute("memberDao");
                 
            Member member = memberDao.selectOne(id);
            request.setAttribute("member", member);         
           return "/member/view.jsp";

    }
}








