package bitcamp.pms.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AutoWired {
    String value() default "";
    //의존객체 주입 , Dependency Injection : DI
    
    
    
    
    
}
