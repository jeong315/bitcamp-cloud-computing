package bitcamp.pms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bitcamp.pms.domain.BusinessCard;
import bitcamp.pms.service.BusinessCardService;

@RestController
@RequestMapping("/businessCard")
public class BusinessCardController {

    @Autowired BusinessCardService businessCardService;
    
    @RequestMapping("list")
    public Object list(Map<String, Object> params) throws Exception {
        List<BusinessCard> list = businessCardService.list(params);
        
        HashMap<String, Object> data = new HashMap<>();
        
        data.put("list", list);
        // view url을 리턴
        return data;
    }
    
    @RequestMapping("view/{cardno}")
    public Object view(@PathVariable int cardno) throws Exception {
           
        HashMap<String,Object> data = new HashMap<>();
        data.put("businessCardService", businessCardService.get(cardno));
        return data;
    } 
    
    @GetMapping("form")
    public void form() { 
    }
    @PostMapping("add")
    public Object add(BusinessCard businessCard) throws Exception {
      HashMap<String, Object> result = new HashMap<>();
      businessCardService.add(businessCard);
      result.put("status", "success");
      
      return result;
  }
    
    @RequestMapping("update")
    public Object update(BusinessCard businessCard) throws Exception {
        HashMap<String, Object> result = new HashMap<>();             
        if (businessCardService.update(businessCard) == 0) {
            result.put("status","fail");
            result.put("error","해당 아이디가 없습니다.");
        } else {
            result.put("status", "success");
        }
        return result;
    }  
    
    @RequestMapping("delete")
    public Object delete(int cardno) throws Exception {
        HashMap<String, Object> result = new HashMap<>();
        
        if (businessCardService.delete(cardno) == 0) {
            result.put("status","fail");
            result.put("error","해당 아이디가 없습니다.");
        } else {
            result.put("status", "success");
        }
        return result;
    }
    
}
