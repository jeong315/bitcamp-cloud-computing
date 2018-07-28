package bitcamp.pms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bitcamp.pms.domain.Classroom;

public class ClassroomDao {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    String jdbcUrl;
    String username;
    String password;
    
    public ClassroomDao(String jdbcUrl, String username, String password) {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password; 
    }
    
    public List<Classroom> selectList() throws Exception{
        try(
            Connection con = DriverManager.getConnection(jdbcUrl, username, password);    
            PreparedStatement stmt = con.prepareStatement(
                    "select * from pms2_classroom");
            ResultSet rs = stmt.executeQuery();){
            
            ArrayList<Classroom> list = new ArrayList<>();
            
            while (rs.next()) {
                Classroom classroom = new Classroom();
                
                classroom.setCrno(rs.getInt("crno"));
                classroom.setTitle(rs.getString("title"));
                classroom.setStartDate(rs.getDate("startDate"));
                classroom.setEndDate(rs.getDate("endDate"));
                classroom.setRoom(rs.getString("room"));
                
                list.add(classroom);
                
            }
            return list;
        }
        
    }
    
    public int delete(int crno) throws Exception{
        
        try (
            Connection con = DriverManager.getConnection(
                    jdbcUrl, username, password);
            PreparedStatement stmt = con.prepareStatement(
                "delete from pms2_classroom where crno=?");) {
            
            stmt.setInt(1, crno);
            
            return stmt.executeUpdate();
           

        } 
    }
    
    public void insert(Classroom classroom) throws Exception{
        
        try (
                Connection con = DriverManager.getConnection(
                        jdbcUrl, username, password);
                PreparedStatement stmt = con.prepareStatement(
                        "insert into pms2_classroom values(?,?,?,?,?)");) {
            
            stmt.setInt(1, classroom.getCrno());
            stmt.setString(2, classroom.getTitle());
            stmt.setDate(3, (Date)classroom.getStartDate());
            stmt.setDate(4, (Date)classroom.getEndDate());
            stmt.setString(5, classroom.getRoom());
            
            stmt.execute();
        }
    }
    
}
