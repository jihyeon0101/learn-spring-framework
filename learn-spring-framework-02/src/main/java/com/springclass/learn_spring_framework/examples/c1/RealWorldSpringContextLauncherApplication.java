package com.springclass.learn_spring_framework.examples.c1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class RealWorldSpringContextLauncherApplication {

	public static void main(String[] args) {
		try(var context =
				new AnnotationConfigApplicationContext
					(RealWorldSpringContextLauncherApplication.class)) { // 인풋으로 들어오는 클래스명 꼭 주의하기!! (에러: UnsatisfiedDependencyException)
			
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
			
			System.out.println(
					context.getBean(BusinessCalculationService.class).findMax());
		}
		
	}

}
