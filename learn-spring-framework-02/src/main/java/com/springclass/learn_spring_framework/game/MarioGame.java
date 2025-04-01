package com.springclass.learn_spring_framework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary // 여러 후보 중 @Primary가 적용된 Bean에 우선권 부여 
// 없을경우, 마리오게임의 GamingConsole인지 팩맨의 GamingConsole인지 어떤 인터페이스를 구현해야할지 몰라서 에러남(UnsatisfiedDependencyException)
public class MarioGame implements GamingConsole{
	public void up() {
		System.out.println("Jump");
	}
	
	public void down() {
		System.out.println("Go into a hole");
	}
	
	public void left() {
		System.out.println("Go back");
	}
	
	public void right() {
		System.out.println("Accelerate");
	}
	
}
