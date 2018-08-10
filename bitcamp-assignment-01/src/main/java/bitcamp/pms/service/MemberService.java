package bitcamp.pms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bitcamp.pms.dao.MemberDao;
import bitcamp.pms.domain.Member;

@Service
public class MemberService {
    
    @Autowired MemberDao memberDao;
    
    public Member get(String email) {
        return memberDao.selectOne(email);
    }
    
    public int delete(String email) {
        return memberDao.delete(email);
    }
    
    public void add(Member member) {
        memberDao.insert(member); 
    }
}
