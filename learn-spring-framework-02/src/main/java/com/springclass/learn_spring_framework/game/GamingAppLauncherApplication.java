package com.springclass.learn_spring_framework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.springclass.learn_spring_framework.game") // 같은 패키지 내에 Component가 있을 경우 패키지는 안써도 됨
// 찾아야하는 Component가 다른 패키지에 있을 때 명시해주기(강의듣다가 같이패키지로 합쳐짐)
public class GamingAppLauncherApplication {

	
//	@Bean
//	public GameRunner gameRunner(GamingConsole game) {
//		System.out.println(game);// pacmangame 파라미터로 자동연결됨
//		var gameRunner = new GameRunner(game); 
//		return gameRunner;
//	}
	
	public static void main(String[] args) {
		// spring context
		try(var context = 
				new AnnotationConfigApplicationContext
					(GamingAppLauncherApplication.class);
				){
			
			context.getBean(GamingConsole.class).up();
			
			context.getBean(GameRunner.class).run();
		}
		
	}

}

// spring은 객체를 관리하고, 자동 연결을 수행할 뿐만 아니라 우리에게 객체를 생성해줌
// - Bean을 생성해달라고 요청하려면 어노테이션 @Component를 추가해야함
// - 검색할 컴포넌트를 찾기 위해서 @componentScan를 추가해야함
// spring은 올바른 패키지를 스캔하고, 컴포넌트를 찾고, 인스턴스를 생성하고 이를 자동으로 연결(auto-wiring)하며 전체 애플리케이션을 제대로 작동시켜줌
