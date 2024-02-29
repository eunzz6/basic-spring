package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( //@Component애노테이션이 붙은 클래스를 스캔하여 스프링 빈으로 등록
       // basePackages = "hello.core.member" //탐색패키지 시작위치 설정
//        basePackageClasses = AutoAppConfig.class // AutoAppConfig클래스의 패키지로 위치 설정
        //미지정시, @ComponentScan이 붙은 패키지가 시작위치
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) //스캔대상 제외
)
public class AutoAppConfig {

//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
