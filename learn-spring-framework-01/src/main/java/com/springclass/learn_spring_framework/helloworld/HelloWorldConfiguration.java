package com.springclass.learn_spring_framework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Address address) {}; // record 에러 - JDK 17, 이클립스 버전업 해서 해결
record Address(String firstLine, String city) {}; // record는 getter, setter 만들 필요 없음. 자동생성 되기 때문

@Configuration
public class HelloWorldConfiguration {
	// 스프링 설정 클래스 @Configuration
	// - 하나 이상의 Bean 메서드를 선언하는 것을 나타냄
	// - Spring Bean(Spring에서 관리하는 것들)을 정의할 수 있음
	// - 방법: 설정 클래스에서 메서드를 정의하여 Spring Bean을 생성할 수 있음
	// 참고) Spring Bean: 스프링이 관리하는 모든 자바 객체 
	
	@Bean // Bean은 Spring Container가 관리함
	public String name() {
		return "Ranga";
	}
	
	@Bean 
	public int age() {
		return 15;
	}
	
	@Bean
	public Person person() {
		return new Person("Ravi",20, new Address("Main Street","London")); // var person = new Person("Ravi",20);
	}
	
	@Bean // spring에서 관리하는 기존 Bean을 사용(재활용)하여 새 Bean을 만들 수 있음
	public Person person2MethodCall() {
		return new Person(name(), age(), address()); // 직접호출 방식
	}
	
	@Bean 
	public Person person3Parameters(String name, int age, Address address3) { // 매개변수
		return new Person(name, age, address3);
	}
	
	@Bean 
	@Primary
	public Person person4Parameters(String name, int age, Address address) {
		return new Person(name, age, address);
	}
	
	@Bean 
	public Person person5Qualifier(String name, int age, @Qualifier("address3qualifier") Address address) {
		return new Person(name, age, address);
	}
	
	@Bean(name = "address2") // Bean의 이름은 사용자의 지정에 따라 변경할 수 있음
	@Primary // 어떤 후ㄱ보가 가장 중요한지 나타냄
	public Address address() {
		return new Address("Baker Street","London");
	}
	
	@Bean(name = "address3") 
	@Qualifier("address3qualifier") // 한정자 (@Qualifier를 추가하여 Bean 간에 자동연결 가능)
	public Address address3() { 
		return new Address("Motinagar","Hyderabad");
	}
	
}
