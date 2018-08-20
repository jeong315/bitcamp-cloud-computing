package bitcamp.pms.dao;

import bitcamp.pms.domain.Member;

public interface MemberDao {
    
/*    Member user(Member member);
    int login(Member member);
    int delete(String email);*/
    int insert(Member member);
}
