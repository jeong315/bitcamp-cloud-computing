package bitcamp.pms.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import bitcamp.pms.annotation.RequestMapping;
import bitcamp.pms.dao.BoardDao;
import bitcamp.pms.domain.Board;

@Controller("/board/add")
public class BoardAddController {
    
    BoardDao boardDao;
    public BoardAddController() {}
    
    public BoardAddController(BoardDao boardDao) {
        super();
        this.boardDao = boardDao;
    }
    @Autowired
    public void setBoardDao(BoardDao boardDao) {
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
