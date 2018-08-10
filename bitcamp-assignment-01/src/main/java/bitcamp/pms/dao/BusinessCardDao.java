package bitcamp.pms.dao;

import java.util.List;
import java.util.Map;

import bitcamp.pms.domain.BusinessCard;

public interface BusinessCardDao {
    List<BusinessCard> selectList(Map<String, Object> params) ;  
    BusinessCard selectOne(int cardno); 
    int insert(BusinessCard businessCard);
    int update(BusinessCard businessCard) ;
    int delete(int cardno) ;
//    int countAll();
}
