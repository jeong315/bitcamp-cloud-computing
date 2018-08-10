package bitcamp.pms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.pms.dao.BusinessCardDao;
import bitcamp.pms.domain.BusinessCard;

@Service
public class BusinessCardService {
    
    @Autowired BusinessCardDao businessCardDao;
    
    public List<BusinessCard> list(Map<String, Object> params){
        return businessCardDao.selectList(params);
    }
    
    public BusinessCard get(int cardno) {
        return businessCardDao.selectOne(cardno);
    }
    
    public int update(BusinessCard businessCard) {
        int count = businessCardDao.update(businessCard);
//        if(count != 100) throw new RuntimeException("일부러 예외 발생");
        return count;
    }
    
    public int delete(int cardno) {
        return businessCardDao.delete(cardno);
    }
    
    public void add(BusinessCard businessCard) {
        businessCardDao.insert(businessCard);
    }

}
