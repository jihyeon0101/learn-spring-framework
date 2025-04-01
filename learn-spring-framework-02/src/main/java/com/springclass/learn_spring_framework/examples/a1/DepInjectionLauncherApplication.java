package com.springclass.learn_spring_framework.examples.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class YourBusinessClass{
	
	// @Autowired // 3.필드 주입
	Dependency1 dependency1;
	
	Dependency2 dependency2;
	
	// @Autowired // 1.생성자 주입
	public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		System.out.println("Constructor Injection - YourBusinessClass");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}
	
//	@Autowired // 2.setter를 사용한 주입
//	public void setDependency1(Dependency1 dependency1) {
//		System.out.println("Setter Injection - setDependency1");
//		this.dependency1 = dependency1;
//	}
//
//	@Autowired
//	public void setDependency2(Dependency2 dependency2) {
//		System.out.println("Setter Injection - setDependency2");
//		this.dependency2 = dependency2;
//	}

	public String toString() {
		return "Using " + dependency1 + " and " + dependency2;
	}
}

@Component
class Dependency1{
	
}

@Component
class Dependency2{
	
}

@Configuration // 빈이 생성됨
@ComponentScan // 자동으로 현재 패키지를 스캔하는 역할 - 같은 패키지에서 수행할 경우에는 패키지명을 명시적으로 지정할 필요없음
public class DepInjectionLauncherApplication {
	
	public static void main(String[] args) {
		// spring context
		try(var context = 
				new AnnotationConfigApplicationContext
					(DepInjectionLauncherApplication.class);
				){
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println); // 모든 Bean 출력
			
			System.out.println(context.getBean(YourBusinessClass.class));
			 // Bean의 이름보다 유형(ex.class명)을 사용하는 것이 좋음
		}
		
	}

}
