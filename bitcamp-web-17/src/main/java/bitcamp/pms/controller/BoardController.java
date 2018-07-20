 package bitcamp.pms.controller;

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

import bitcamp.pms.dao.BoardDao;
import bitcamp.pms.domain.Board;

@RequestMapping("/board")
@Controller
public class BoardController{
    
    @Autowired BoardDao boardDao;

//리스트☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★    
    @RequestMapping("list")
    public String list(@RequestParam(defaultValue="1")int page,
                        @RequestParam(defaultValue="10")int size,
                        Model model) throws Exception {
       
        HashMap<String, Object> params = new HashMap<>();
        
        if(page < 1) page = 1;
        if(size < 1 || size > 20) size = 10;
            
            params.put("startIndex", (page - 1) * size);
            params.put("pageSize", size);
        

            List<Board> list = boardDao.selectList(params);
            model.addAttribute("list", list);
            
//            System.out.println("어떤 글이야~~ : "+list.toString()+"~~!");
                 
        return "board/list";
    }
    
//보기☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★       
    @RequestMapping("view/{no}")
    public String view(@PathVariable int no, Model model) throws Exception {

        System.out.println(no + "번 글 보기");
        
        Board board = boardDao.selectOne(no);
        model.addAttribute("board", board);

        return "board/view";
    }
    
//작성☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★      
    @GetMapping("form")
    public void form(){      
        System.out.println("작성 폼 열기");
    }
    
//    @PostMapping("add")
    @RequestMapping(value="add", method=RequestMethod.POST)
    public String add(Board board) throws Exception {
            System.out.println("ㅎㅎㅎ");
            boardDao.insert(board);
            System.out.printf("번호 : %d\n제목 : %s\n내용 : %s",
                               board.getNo(),
                               board.getTitle(),
                               board.getContent());

            return "redirect:list";
    }
    
//수정☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★       
    @RequestMapping("update")
    public String update(Board board) throws Exception {
            
        System.out.printf("번호 : %d\n수정된 제목 : %s\n수정된 내용 : %s\n",
                board.getNo(),
                board.getTitle(),
                board.getContent());
          
            if (boardDao.update(board) == 0) {
                return "board/updatefail";
            } else {
                return "redirect: list";               
            }
   
    }
    
//삭제☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★      
    @RequestMapping("delete")
    public String delete(int no) throws Exception {

        boardDao.delete(no);
        System.out.println(no+"번 삭제되었습니다.");
        return "redirect: list";
    }


}
