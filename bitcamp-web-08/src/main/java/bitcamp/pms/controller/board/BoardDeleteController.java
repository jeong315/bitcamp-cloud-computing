package bitcamp.pms.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.annotation.RequestMapping;
import bitcamp.pms.controller.PageController;
import bitcamp.pms.dao.BoardDao;

public class BoardDeleteController{

    BoardDao boardDao;

    public BoardDeleteController(BoardDao boardDao) {
        super();
        this.boardDao = boardDao;
    }
    @RequestMapping
    public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {

        boardDao.delete(Integer.parseInt(request.getParameter("no")));

        return "redirect: list";
    }

}
