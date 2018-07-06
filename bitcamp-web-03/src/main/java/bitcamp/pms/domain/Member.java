package bitcamp.pms.domain;

public class Member {   
    //자식 클래스도 접근 가능하게 하려면 protected
    protected String id;
    protected String email;
    protected String password;
       
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
//    public Member() {}
    
    
}
