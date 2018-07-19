package bitcamp.pms.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import bitcamp.pms.annotation.RequestMapping;
import bitcamp.pms.dao.BoardDao;
import bitcamp.pms.domain.Board;

@Controller("/board/update")
public class BoardUpdateController {

    BoardDao boardDao;
    public BoardUpdateController() {}
    
    public BoardUpdateController(BoardDao boardDao) {
        super();
        this.boardDao = boardDao;
    }
    
    @Autowired
    public void setBoardDao(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    @RequestMapping
    public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {

        
            Board board = new Board();
            
            board.setNo(Integer.parseInt(request.getParameter("no")));
            board.setTitle(request.getParameter("title"));
            board.setContent(request.getParameter("content"));
            
            System.out.println("기본 키인 번호 : " + Integer.parseInt(request.getParameter("no")));
            System.out.println("수정된 제목 : " + request.getParameter("title"));
            System.out.println("수정된 내용 : " + request.getParameter("content"));
          
            if (boardDao.update(board) == 0) {
                return "board/updatefail.jsp";
            } else {
                return "redirect: list";               
            }
   
    }

}
