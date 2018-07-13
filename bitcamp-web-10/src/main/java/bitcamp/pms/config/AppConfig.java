package bitcamp.pms.config;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//벗 스프링 IoC에게 객체 자동생성 명령을 내리는 것이다.
@Configuration 
public class AppConfig {
    public AppConfig() {
        System.out.println("AppConfig() 호출이 된다면 이 문장이 콘솔에 등장함");
    }
 /*   
  //이 메소드 이름으로 저장해라~
    @Bean("sqlSessionFactory") 
    public SqlSessionFactory getSqlSessionFactory() throws Exception{
        System.out.println("@Bean으로 저장했다면 AppConfig.getSqlSessionFactory() 호출된다면 이 문장이 콘솔에 등장함");
        
       
    }*/
}
