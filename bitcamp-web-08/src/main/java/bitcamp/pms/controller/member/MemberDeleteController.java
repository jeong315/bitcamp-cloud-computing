package bitcamp.pms.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.annotation.RequestMapping;
import bitcamp.pms.dao.MemberDao;

public class MemberDeleteController {
    
    MemberDao memberDao;

    public MemberDeleteController(MemberDao memberDao) {
        super();
        this.memberDao = memberDao;
    }

    @RequestMapping
    public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
            memberDao.delete(request.getParameter("id"));
            return "redirect: list";
       
    }
}







