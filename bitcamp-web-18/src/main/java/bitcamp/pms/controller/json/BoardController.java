 package bitcamp.pms.controller.json;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.pms.dao.BoardDao;
import bitcamp.pms.domain.Board;
import bitcamp.pms.service.BoardService;

@RequestMapping("/board")
@RestController
public class BoardController{
    
    @Autowired BoardService boardService;

//리스트☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★    
    @RequestMapping("list")
    public Object list(@RequestParam(defaultValue="1")int page,
                        @RequestParam(defaultValue="10")int size) throws Exception {
        
        if(page < 1) page = 1;
        if(size < 1 || size > 20) size = 10;

        List<Board> list = boardService.list(page, size);
        HashMap<String, Object> data = new HashMap<>();
        data.put("list", list);
        data.put("page", page);
        data.put("size", size);
        data.put("totalPage", boardService.getTotalCount(size));
            
//            System.out.println("어떤 글이야~~ : "+list.toString()+"~~!");
                 
        return data;
    }
    
//보기☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★       
    @RequestMapping("view/{no}")
    public Object view(@PathVariable int no) throws Exception {

        System.out.println(no + "번 글 보기");
        
        HashMap<String, Object> data = new HashMap<>();
        
        data.put("board", boardService.get(no));

        return data;
    }
    
//작성☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★      
    @GetMapping("form")
    public void form(){      
        System.out.println("작성 폼 열기");
    }
    
//    @PostMapping("add")
    @RequestMapping(value="add", method=RequestMethod.POST)
    public Object add(Board board) throws Exception {
            
        HashMap<String, Object> result = new HashMap<>();
   
        System.out.println("글 작성 성공");
        boardService.add(board);
        result.put("status", "success");
        System.out.printf("번호 : %d\n제목 : %s\n내용 : %s",
                             board.getNo(),
                             board.getTitle(),
                             board.getContent());

            return result;
    }
    
//수정☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★       
    @RequestMapping("update")
    public Object update(Board board) throws Exception {
        HashMap<String, Object> result = new HashMap<>();    
        if (boardService.update(board) == 0) {
            result.put("status","fail");
            result.put("error","해당 아이디가 없습니다.");
        } else {
            result.put("status", "success");
        }
        System.out.printf("번호 : %d\n수정된 제목 : %s\n수정된 내용 : %s\n",
                board.getNo(),
                board.getTitle(),
                board.getContent());
        return result;
   
    }
    
//삭제☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★      
    @RequestMapping("delete")
    public Object delete(int no) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        
        if (boardService.delete(no) == 0) {
            result.put("status","fail");
            result.put("error","해당 아이디가 없습니다.");
        } else {
            result.put("status", "success");
        }
        System.out.println(no+"번 삭제되었습니다.");
        return result;

    }


}
