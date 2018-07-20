package bitcamp.java106.step13.ex1;

import org.springframework.stereotype.Component;

//IoC 컨테이너가 생성하도록 
@Component 
public class X {
    public void m() {
        System.out.println("X.m()");
    }
}
