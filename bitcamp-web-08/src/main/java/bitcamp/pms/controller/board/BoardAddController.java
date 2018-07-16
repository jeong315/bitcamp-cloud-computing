package bitcamp.pms.controller.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.annotation.RequestMapping;
import bitcamp.pms.controller.PageController;
import bitcamp.pms.dao.BoardDao;
import bitcamp.pms.domain.Board;

public class BoardAddController {
    
    BoardDao boardDao;
    
    public BoardAddController(BoardDao boardDao) {
        super();
        this.boardDao = boardDao;
    }


    @RequestMapping
    public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if(request.getMethod().equals("GET")) {
            return "/board/boardForm.jsp";
        }     
            Board board = new Board();
            
            board.setTitle(request.getParameter("title"));
            board.setContent(request.getParameter("content"));
            
            System.out.println("등록 제목 : "+request.getParameter("title"));
            System.out.println("등록 내용 : "+request.getParameter("content"));
            
            boardDao.insert(board);
       
            return "redirect:list";
    }
}
