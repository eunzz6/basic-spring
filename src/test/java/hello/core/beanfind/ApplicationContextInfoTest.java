package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); //빈 정의된 이름
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + "object = "+bean); //컨테이너에 있는 모든 빈 출력
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); //빈 정의된 이름
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            //Role ROLE_APPLICATION : 직접 등록한 애플리케이션 빈
            //Role INFRASTRUCTURE : 스프링이 내부에서 사용하는
            if(beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + "object = "+bean); //컨테이너에 있는 모든 빈 출력
            }
        }
    }
}
