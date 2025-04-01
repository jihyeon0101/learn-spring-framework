package com.springclass.learn_spring_framework.examples.a0;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // 빈이 생성됨
@ComponentScan// 패키지명 - 자동으로 컴포넌트 스캔을 수행함,, 같은 패키지에서 수행할 경우에는 명시적으로 지정할 필요없음
public class SimpleSpringContextLauncherApplication {
	
	public static void main(String[] args) {
		// spring context
		try(var context = 
				new AnnotationConfigApplicationContext
					(SimpleSpringContextLauncherApplication.class);
				){
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println); // 모든 Bean 출력
		}
		
	}

}
