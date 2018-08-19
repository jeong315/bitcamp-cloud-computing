package bitcamp.assignment.repository;

import java.util.Map;

import bitcamp.assignment.domain.Member;

public interface MemberRepository {
//mybatis에서 관리를 하기 때문에 
    int insert(Member member);
    Member findByEmailAndPassword(Map<String, Object> params);
    
}
