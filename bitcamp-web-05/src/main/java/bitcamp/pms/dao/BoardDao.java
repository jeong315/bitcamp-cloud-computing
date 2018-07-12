package bitcamp.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bitcamp.pms.domain.Board;
import bitcamp.pms.domain.Member;

public class BoardDao {
    
    SqlSessionFactory sqlSessionFactory;
    
    public BoardDao(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
    
    public List<Board> selectList(Map<String, Object> params) throws Exception{
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            System.out.println("!@#");
            return sqlSession.selectList("board.selectList", params);
        }
    }
    
    public Board selectOne(int no) throws Exception{
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            return sqlSession.selectOne("board.selectOne", no);
        }
    }
    
    public int insert(Board board) throws Exception{
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            int count = sqlSession.insert("board.insert", board);
            sqlSession.commit();
            return count;
        }
    }
    
    public int update(Board board) throws Exception{
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            int count = sqlSession.update("board.update", board);
            sqlSession.commit();
            return count;
        }
    }
    
    public int delete(int no) throws Exception{
        try(SqlSession sqlSession = sqlSessionFactory.openSession()){
            int count = sqlSession.delete("board.delete", no);
            sqlSession.commit();
            return count;
        }
    }
    
}
