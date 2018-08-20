package bitcamp.pms.domain;

public class Member {
    protected String email;
    protected String name;
    protected String password;
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "Member [email=" + email + ", name=" + name + ", password=" + password + "]";
    }
    
    
 
    
    
}
