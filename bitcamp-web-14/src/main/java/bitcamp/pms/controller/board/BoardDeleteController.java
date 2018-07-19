package bitcamp.pms.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bitcamp.pms.dao.BoardDao;

@Controller
public class BoardDeleteController{

    BoardDao boardDao;
    public BoardDeleteController() {}
    
    public BoardDeleteController(BoardDao boardDao) {
        super();
        this.boardDao = boardDao;
    }
    @Autowired
    public void setBoardDao(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    @RequestMapping("/board/delete")
    public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {

        boardDao.delete(Integer.parseInt(request.getParameter("no")));

        return "redirect: list";
    }

}
