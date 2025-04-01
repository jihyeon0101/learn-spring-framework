package com.springclass.learn_spring_framework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Primary;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
		// 1: Launch a Spring Context(Bean이 정의된 설정파일을 Spring Context에 input으로 전달함)
		try(var context = 
				new AnnotationConfigApplicationContext
					(HelloWorldConfiguration.class)){
			
			// 캐치 블록과 같이 배치하면 컨텍스트 닫을 수 있음. try-with-resource 코드 내에서 예외가 발생하면 상황별 단서가 자동으로 호출됨
			
			// 2: Configure the things that we want Spring to manage (스프링 프레임워크가 관리하도록 설정) - @Configuration
			// 여기서 설정 클래스를 만들고 이름,나이 등 모든 객체를 정의할 수 있음. 그리고 설정 클래스를 사용해 Spring Context를 시작할 수 있음
			
			// 3: Retrieving Beans managed by Spring
			
			System.out.println(context.getBean("name")); // 빈 이름 사용
			
			System.out.println(context.getBean("age"));
			
			System.out.println(context.getBean("person"));
			
			System.out.println(context.getBean("person2MethodCall"));	
			
			System.out.println(context.getBean("person3Parameters"));		
			
			System.out.println(context.getBean("address2"));
			
			System.out.println(context.getBean("person5Qualifier"));
			
//			System.out.println(context.getBean(Address.class)); // 클래스 이름의 형식을 사용할 수 있음. 클래스가 같은 이름으로 여러개 있을 경우 오류 발생
			// 동일한 클래스의 여러 객채가 발견되어 오류남
			// 그 중에 하나의 우선순위를 부여하도록 한다면 - @Primary 여러개 중 하나를 기본을 만드는 의미
			
			//System.out.println 메서드 참조
			//Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println); // 배열로 스트림 만들고, forEach사용해 스트림에 있는 모든 요소에 대해 prinln 실행
			//설정파일도 Bean 관리
			
		};
		 
	}
}
