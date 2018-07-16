package bitcamp.pms.test;
import java.io.File;
import java.io.FileFilter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bitcamp.pms.annotation.Component;
import bitcamp.pms.annotation.Controller;
import bitcamp.pms.annotation.Repository;
import bitcamp.pms.context.ApplicationContext;

public class Test3 {  
    public static void main(String[] args) throws Exception {

        //Spring framework에 대해서 요약정리
        
        //Spring IoC 컨테이너 객체 생성하기      
        ClassPathXmlApplicationContext iocContainer = new ClassPathXmlApplicationContext("bitcamp/pms/test/application-context3.xml");
        
        
        System.out.println("몇개들었니?"+iocContainer.getBeanDefinitionCount()+"개요.");
        System.out.println("=-==-=-=-=-=-===-=-=-=-=-");
        
        String[] names = iocContainer.getBeanDefinitionNames();       
        for(String name : names) {
            System.out.printf("%s ==> %s\n",name,iocContainer.getBean(name).toString());
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}