package com.springclass.learn_spring_framework.game;

import org.springframework.stereotype.Component;

@Component // 스프링이 관리할 컴포넌트
public class PacmanGame implements GamingConsole{
	
	public void up() {
		System.out.println("up");
	}
	
	public void down() {
		System.out.println("down");
	}
	
	public void left() {
		System.out.println("left");
	}
	
	public void right() {
		System.out.println("right");
	}
}
