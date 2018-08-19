package bitcamp.assignment.domain;

import java.io.Serializable;

public class Member implements Serializable{
                                //상징적인 용도로 쓴다.
    private static final long serialVersionUID = 1L;
    
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
