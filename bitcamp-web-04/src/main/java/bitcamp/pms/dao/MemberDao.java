package bitcamp.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bitcamp.pms.domain.Member;

public class MemberDao {
   /*static는 클래스가 로딩될 때 한번만 만들어진다. 
    * 혹시나 인스턴스를 각각 구분할 필요가 있을 수도 있으니까 그냥 인스턴스로 
    * 인스턴스 : 객체마다 따로따로 갖고 있는 메모리 
    * */
    static {        
        try {
            //class가 로딩하는 것 
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        String jdbcUrl;
        String username;
        String password;
        
        public MemberDao(String jdbcUrl, String username, String password) {
            this.jdbcUrl = jdbcUrl;
            this.username = username;
            this.password = password;
        
    }
    /*'커넥션'을 공유하면 안되는 이유 
     * 커넥션을 공유하면 Rollback이 동시에 발생한다.
     * Rollback은 커넥션 단위로 이루어진다.
     * 즉, 커넥션은 공유하면 안된다.
     * */
    public List<Member> selectList() throws Exception{

        try (
            Connection con = DriverManager.getConnection(
                jdbcUrl, username, password);
            PreparedStatement stmt = con.prepareStatement(
                "select mid, email from pms2_member");
            ResultSet rs = stmt.executeQuery();) {
            
            ArrayList<Member> list = new ArrayList<>();
            
            while (rs.next()) {
                Member member = new Member();
                
                member.setId(rs.getString("mid"));
                member.setEmail(rs.getString("email"));
                
                list.add(member);
            }
            return list;
        }
    }
    
    public Member selectOne(String id) throws Exception{ 
        //static: 인스턴스를 쓸 일이 없으니까 써줌

        try (
            Connection con = DriverManager.getConnection(
                    jdbcUrl, username, password);
            PreparedStatement stmt = con.prepareStatement(
                "select mid,email from pms2_member where mid=?");) {
            
            stmt.setString(1, id);
            System.out.println(id);
            
            
            try (ResultSet rs = stmt.executeQuery();) {
                if (!rs.next()) {
//                    throw new Exception("유효하지 않은 멤버 아이디입니다.");
                    return null;
            }
            Member member = new Member();
            member.setId(rs.getString("mid"));
            member.setEmail(rs.getString("email"));
            
//                 email = rs.getString("email");
            //stmt.executeQuery();
            return member;
       
            }
        }
    }
    
    public int update(Member member) throws Exception{
        try (
                Connection con = DriverManager.getConnection(
                        jdbcUrl, username, password);
                PreparedStatement stmt = con.prepareStatement(
                    "update pms2_member set email=?, pwd=password(?) where mid=?");) {
                
                stmt.setString(1, member.getEmail());
                stmt.setString(2, member.getPassword());
                stmt.setString(3, member.getId());   
                
                return stmt.executeUpdate();
                
            }
    }
    public int delete(String id) throws Exception{
    
        try (
            Connection con = DriverManager.getConnection(
                    jdbcUrl, username, password);
            PreparedStatement stmt = con.prepareStatement(
                "delete from pms2_member where mid=?");) {
            
            stmt.setString(1, id);
            
            return stmt.executeUpdate();
           

        } 
    }
    public void insert(Member member) throws Exception{
      
        try (
                Connection con = DriverManager.getConnection(
                        jdbcUrl, username, password);
                PreparedStatement stmt = con.prepareStatement(
                        "insert into pms2_member(mid,email,pwd) values(?,?,password(?))");) {
            
            stmt.setString(1, member.getId());
            stmt.setString(2, member.getEmail());
            stmt.setString(3, member.getPassword());
            
            stmt.execute();
//            return stmt.executeUpdate();
        }
    }
}
