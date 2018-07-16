package bitcamp.pms.dao;

import java.util.List;
import java.util.Map;

import bitcamp.pms.domain.Member;

public interface MemberDao {
    //이제 구현체가 사라짐
     List<Member> selectList(Map<String, Object> params);
     Member selectOne(String id);
     int update(Member member);
     int delete(String id);
     int insert(Member member);

}