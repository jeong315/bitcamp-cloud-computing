package bitcamp.pms.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bitcamp.pms.servlet.domain.Member;

public class MemberDao {
    
    String jdbcUrl;
    String username;
    String password;
    
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public MemberDao(String jdbcUrl, String username, String password) {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
    }
    
    public void insert(Member member) throws Exception{
       
        try (
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://52.79.189.185:3306/studydb",
                        "study", "1111");
                PreparedStatement stmt = con.prepareStatement(
                        "insert into pms2_member(mid,email,pwd) values(?,?,password(?))");) {
            
            stmt.setString(1, member.getId());
            stmt.setString(2, member.getEmail());
            stmt.setString(3, member.getPassword());
            
            stmt.execute();
//            return stmt.executeUpdate();
        }
    }
    
    public int delete(String id) throws Exception{
       
        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://52.79.189.185:3306/studydb",
                "study", "1111");
            PreparedStatement stmt = con.prepareStatement(
                "delete from pms2_member where mid=?");) {
            
            stmt.setString(1, id);
            return stmt.executeUpdate();
    }
    }
    
    public List<Member> selectList() throws Exception{

        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://52.79.189.185:3306/studydb",
                "study", "1111");
            PreparedStatement stmt = con.prepareStatement(
                "select mid, email from pms2_member");
            ResultSet rs = stmt.executeQuery();) {

            List<Member> list = new ArrayList<>();
             
            
            while (rs.next()) {
                Member member = new Member();
                
                member.setId(rs.getString("mid"));
                member.setEmail(rs.getString("email"));
                list.add(member); 
            }
            
            
             
             
            return list;
        }
    }
    
    public int update(Member member) throws Exception{

        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://52.79.189.185:3306/studydb",
                "study", "1111");
            PreparedStatement stmt = con.prepareStatement(
                "update pms2_member set email=?, pwd=password(?) where mid=?");) {
            
            stmt.setString(1, member.getEmail());
            stmt.setString(2, member.getPassword());
            stmt.setString(3, member.getId());     
            
            return stmt.executeUpdate();
        }
    }
   
    public Member selectOne(String id) throws Exception{
        Member member = new Member();

        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://52.79.189.185:3306/studydb",
                "study", "1111");
            PreparedStatement stmt = con.prepareStatement(
                "select mid,email from pms2_member where mid=?");) {
            
            stmt.setString(1, id);
            System.out.println(id + "C");
            try (ResultSet rs = stmt.executeQuery();) {
                if (!rs.next()) 
                    throw new Exception("유효하지 않은 멤버 아이디입니다.");
               
//                    return null;
                else {
                member.setId(id);
                member.setEmail(rs.getString("email"));
                System.out.println(rs.getString("email")+"A");
//                email = rs.getString("email");
//                stmt.executeQuery();
                }
            }
    }System.out.println(member + "D");
        return member;
    }
    
}
