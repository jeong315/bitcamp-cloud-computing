package bitcamp.pms.controller.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.pms.controller.PageController;
import bitcamp.pms.dao.BoardDao;
import bitcamp.pms.domain.Board;

public class BoardViewController implements PageController {

    BoardDao boardDao;

    public BoardViewController(BoardDao boardDao) {
        super();
        this.boardDao = boardDao;
    }

    @Override
    public String service(HttpServletRequest request, HttpServletResponse response) throws Exception {

        int no = Integer.parseInt(request.getParameter("no"));
        System.out.println(no + "번 글 보기");
        response.setContentType("text/html;charset=UTF-8");
        
        Board board = boardDao.selectOne(no);

        request.setAttribute("board", board);

        return "/board/view.jsp";
    }
}
