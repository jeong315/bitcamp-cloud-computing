package bitcamp.pms.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//애노테이션의 유지정책
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
//    static Class class = ...;
    String value() default "";
} 