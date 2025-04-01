package com.springclass.learn_spring_framework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springclass.learn_spring_framework.game.GameRunner;
import com.springclass.learn_spring_framework.game.GamingConsole;

public class App03GamingSpringBeans {

	public static void main(String[] args) {
		
		try(var context = 
				new AnnotationConfigApplicationContext
					(GamingConfiguration.class);
				){
			
			context.getBean(GamingConsole.class).up();
			
			context.getBean(GameRunner.class).run();
		}
		
	}

}
