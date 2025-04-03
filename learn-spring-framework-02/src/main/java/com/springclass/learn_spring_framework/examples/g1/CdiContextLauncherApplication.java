package com.springclass.learn_spring_framework.examples.g1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import jakarta.inject.Inject;
import jakarta.inject.Named;

//@Component
@Named
class BusinessService{
	private DataService dataService;

	//@Autowired // setter 주입 방식
	@Inject //@Autowired 대신 @Inject
	public void setDataService(DataService dataService) {
		System.out.println("Setter Injection");
		this.dataService = dataService;
	}
	
	public DataService getDataService() {
		return dataService;
	}
	
}

//@Component
@Named //@Component 대신 @Named
class DataService{
	
}

@Configuration 
@ComponentScan
public class CdiContextLauncherApplication {
	
	public static void main(String[] args) {
		// spring context
		try(var context = 
				new AnnotationConfigApplicationContext
					(CdiContextLauncherApplication.class);
				){
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println); // 모든 Bean 출력
			
			System.out.println(context.getBean(BusinessService.class));
		}
		
	}

}
