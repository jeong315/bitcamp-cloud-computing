package bitcamp.pms.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bitcamp.pms.dao.BoardDao;
import bitcamp.pms.domain.Board;

@Controller
public class BoardViewController {

    BoardDao boardDao;
    public BoardViewController() {}
    
    public BoardViewController(BoardDao boardDao) {
        super();
        this.boardDao = boardDao;
    }
    @Autowired
    public void setBoardDao(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    @RequestMapping("/board/view")
    public String view(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int no = Integer.parseInt(request.getParameter("no"));
        System.out.println(no + "번 글 보기");
        response.setContentType("text/html;charset=UTF-8");
        
        Board board = boardDao.selectOne(no);

        request.setAttribute("board", board);

        return "/board/view.jsp";
    }
}
