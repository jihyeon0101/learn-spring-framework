package com.springclass.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraGameQualifier")
// auto wiring 시 필드나 매개변수에서 후보 Bean에 대한 한정자로 쓰임
public class SuperContraGame implements GamingConsole{
	
	public void up() {
		System.out.println("up");
	}
	
	public void down() {
		System.out.println("Sit down");
	}
	
	public void left() {
		System.out.println("Go back");
	}
	
	public void right() {
		System.out.println("Shoot a bullet");
	}
}
