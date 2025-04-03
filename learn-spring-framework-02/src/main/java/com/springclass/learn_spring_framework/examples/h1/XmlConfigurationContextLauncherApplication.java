package com.springclass.learn_spring_framework.examples.h1;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springclass.learn_spring_framework.game.GameRunner;

public class XmlConfigurationContextLauncherApplication {
	
	public static void main(String[] args) {
		// spring context
		try(var context = 
				new ClassPathXmlApplicationContext("contextConfiguration.xml")){
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println); // 모든 Bean 출력
			
			System.out.println(context.getBean("name"));
			
			System.out.println(context.getBean("age"));
			
			context.getBean(GameRunner.class).run();
		}
		
	}

}
