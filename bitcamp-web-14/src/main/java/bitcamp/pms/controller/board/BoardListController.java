 package bitcamp.pms.controller.board;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bitcamp.pms.dao.BoardDao;
import bitcamp.pms.domain.Board;

@Controller
public class BoardListController{
    
    BoardDao boardDao;
    public BoardListController() {}
    
    public BoardListController(BoardDao boardDao) {
        this.boardDao = boardDao;
    }
    
    @Autowired
    public void setBoardDao(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    @RequestMapping("/board/list")
    public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
       
        HashMap<String, Object> params = new HashMap<>();
        
        if(request.getParameter("page") != null && request.getParameter("size") != null) {
            int page = Integer.parseInt(request.getParameter("page"));
            int size = Integer.parseInt(request.getParameter("size"));
            
            params.put("startIndex", (page - 1) * size);
            params.put("pageSize", size);
        }
        
//        response.setContentType("text/html;charset=UTF-8");
            
            List<Board> list = boardDao.selectList(params);
            request.setAttribute("list", list);
            
            System.out.println("어떤 글이야~~ : "+list.toString()+"~~!");
                 
        return "/board/list";
    }
}
