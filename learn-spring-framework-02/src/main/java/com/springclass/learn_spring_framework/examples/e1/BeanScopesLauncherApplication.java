package com.springclass.learn_spring_framework.examples.e1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // 기본적으로 스프링에서 생성되는 모든 Bean은 싱글톤임
class NormalClass{
	
}

@Scope(value=ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass{
	
}

@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {
	
	public static void main(String[] args) {
		// spring context
		try(var context = 
				new AnnotationConfigApplicationContext
					(BeanScopesLauncherApplication.class);
				){
			
			//해시코드 같음(Spring 컨테이너에 Bean을 여러번 요청하더라도 항상 같은 인스턴스를 반환)
			System.out.println(context.getBean(NormalClass.class));
			System.out.println(context.getBean(NormalClass.class));
			
			// 매번 이 Spring 컨텍스트에서 새로운 Bean를 가져옴(해시코드가 계속 바뀜) - Bean을 요청할 때마다 새로운 인스턴스를 생성
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
			System.out.println(context.getBean(PrototypeClass.class));
			
		}
		
	}

}
