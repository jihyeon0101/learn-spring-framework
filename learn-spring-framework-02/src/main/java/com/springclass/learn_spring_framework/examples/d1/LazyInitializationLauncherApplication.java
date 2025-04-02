package com.springclass.learn_spring_framework.examples.d1;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA{
	
}

@Component
@Lazy // 지연초기화 - ClassB Bean은 시작할 때 초기화 되지 않음
class ClassB{
	
	private ClassA classA;

	// @Lazy가 없을 경우, 자동으로 빈이 초기화됨
	public ClassB(ClassA classA) {
		System.out.println("Some Initialization logic"); 
		this.classA = classA;
	}

	public void doSomething() {
		System.out.println("Do Something");
	}
	
}

@Configuration 
@ComponentScan
public class LazyInitializationLauncherApplication {
	
	public static void main(String[] args) {
		// spring context
		try(var context = 
				new AnnotationConfigApplicationContext
					(LazyInitializationLauncherApplication.class);
				){

			System.out.println("Initialization of context is completed");
			
			context.getBean(ClassB.class).doSomething();
		}
		
	}

}
