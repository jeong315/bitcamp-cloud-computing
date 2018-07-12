package bitcamp.pms.context;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;

import org.apache.ibatis.io.Resources;

import bitcamp.pms.annotation.AutoWired;
import bitcamp.pms.annotation.Component;
import bitcamp.pms.annotation.Controller;
import bitcamp.pms.annotation.Repository;

public class ApplicationContext{
    //스프링 아이오씨 컨ㅌ케이너
    //생성된 객체에 대해서 필요한 .. 자동으로 주입해주는 기능이 중요하다.
    //이건 ContextLoaderListener에서 쓰려고 만드는 것이다. 
    static HashMap<String, Object> objPool = new HashMap<>();
    
    public ApplicationContext(String packageName) throws Exception {  
        
        String filePath = packageName.replace(".", "/");
        
//        ClassLoader defaultClassLoader = 
//                ClassLoader.getSystemClassLoader();
//
//        // 이 폴더를 뒤져서 ㄷ원하는 걸 알아낼 것이다.
//        URL url = ClassLoader.getSystemResource(filePath);
//        File dir = new File(url.toURI());
            
        File dir = Resources.getResourceAsFile(filePath);
        
        
        
        findClass(dir, packageName);
        injectDependency();
    }
    
    private void injectDependency() throws Exception {
       //objPool 보관소에 저장된 모든 객체를 꺼낸다.
        Collection<Object> objList = objPool.values();
        
        for(Object obj : objList) {
            //객체의 클래스 정보를 추출한다.
            Class<?> clazz = obj.getClass(); 
            
            //해당 클래스의 모든 메서드를 추출한다.
            Method[] methods = clazz.getMethods();
            
            for(Method m : methods) {
                //각 객체에 존재하는 메서드 중에서 @Autowired가 붙은 세터를 찾아낸다.
                
                //셋터가 아니면 무시
                if(!m.getName().startsWith("set")) continue; 
                
                //Autowired가 붙지 않았으면 무시
                if(m.getAnnotation(AutoWired.class) == null) continue;
                
                //파라미터 개수가 한개가 아니라면 무시
                if(m.getParameterTypes().length != 1) continue;
                
                //세터의 파라미터 타입을 알아낸다.
                Class<?> paramType = m.getParameterTypes()[0];
                
                //세터의 파리미터 타입에 해당하는 객체가를 objPool 보관소에서 꺼낸다.
                try{
                    Object dependency = getBean(paramType);
                    
                    m.invoke(obj, dependency);
                }catch(Exception e) {
                    System.out.println(("error : " + e.getMessage()));
                    //의존 객체가 없으면 세터를 호출하지 않는다.
                    //그냥 무시한다.
                }

                
                //세터를 호출하여 의존객체를 주입한다.
            }
            
            
        }
        
    }
    
    public void refresh() throws Exception{
        injectDependency();//의존객체를 다시 주입하라.
    }

    public Object getBean(Class<?> type) {
        Collection<Object> objList = objPool.values();
        for(Object obj : objList) {
//            if(obj.getClass() == type) return obj;
            if(type.isInstance(obj)) return obj;

        }
        throw new RuntimeException(type.getName() + "이 타입의 객체가 존재하지 않습니다.");
    }
    
    public Object getBean(String name) {
        //해당되지 않은 파일을 찾는 경우 널을 출력하지 않고 예외를 출력한다.
        Object obj = objPool.get(name); 
        
        if(obj == null) throw new RuntimeException(name + "이라는 이름을 가진 객체가 존재하지 않습니다.");
        
        return obj; 
    }
    
    public void addBean(String name, Object obj) {
        objPool.put(name, obj);
    }
    
   private void findClass(File path, String packageName) {

        File[] subFiles = path.listFiles((File pathname) -> {
            if (pathname.isDirectory())
                return true;
            if (pathname.isFile() && pathname.getName().endsWith(".class"))
                return true;
            return false;
        });

        for (File subFile : subFiles) {
            if (subFile.isFile()) {
                String className = packageName + "." + subFile.getName().replace(".class", "");
                createObject(className);
                
            } else {
                findClass(subFile, packageName + "." + subFile.getName());
            }
        }
    } 

    private void createObject(String className) {
      try{
          //클래스이름(패키지명 + 클래스명)으로, .class 파일을 찾아 로딩함
          Class<?> clazz = Class.forName(className);
          //제네릭 경고를 안뜨게 하려면 여러종류의 변수를 갖는 
          
          //@Component, @Controller, @Repository       
          //애노테이션이 붙은 클래스가 아니라면 객체를 생성하지 않는다.
          if(clazz.getAnnotation(Component.class) == null &&
             clazz.getAnnotation(Controller.class) == null &&
             clazz.getAnnotation(Repository.class) == null) 
              
          return;
          
        //객체를 저장할 때 사용할 이름을 알아낸다.
          String objName = getObjectName(clazz);
          
          //기본 클래스 정보를 보고 기본 생성자를 알아낸다.
          Constructor<?> constructor = clazz.getConstructor();
          
          //기본 생성자를 호출하여 객체를 생성한 후 객체 보관소에 저장한다.
          objPool.put(objName, constructor.newInstance());
              
          
      }catch(Exception e){//기본 생성자가 없거나 기본 프라이빗으로 막혀있으면 에러가 뜬다.
          System.out.println(e.getMessage());
      }
    }
    
    private String getObjectName(Class<?> clazz) throws Exception{
        //클래스 정보를 주면 컴컨레 로부터 이름을 알아낸 당므에 이름을 리턴하는데 
        //이름이 빈 문자열이면 그때는 클래스의 캐너니컬 이름을 리턴한다.
        
        String objName = null;
        
        Component compAnno = clazz.getAnnotation(Component.class);
        if(compAnno != null)
            objName = compAnno.value();
        
        Controller ctrlAnno = clazz.getAnnotation(Controller.class);
        if(ctrlAnno != null)
            objName = ctrlAnno.value();
        
        Repository repoAnno = clazz.getAnnotation(Repository.class);
        if(repoAnno != null)
            objName = repoAnno.value();
        
        if(objName.length() == 0) {
            return clazz.getCanonicalName();
        }else {
            return objName;
        }
    }
    
}
