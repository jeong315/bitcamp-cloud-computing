package bitcamp.pms.dao;

import bitcamp.pms.domain.Member;

public interface MemberDao {
    
    Member selectOne(String email);
    int delete(String email);
    int insert(Member member);
}
