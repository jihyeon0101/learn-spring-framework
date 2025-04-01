package com.springclass.learn_spring_framework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.springclass.learn_spring_framework.game") // 패키지명 - 패키지 분리되었을때.. 강의듣다가 같이패키지로 합쳐짐
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
// spring에 빈을 생성해달라고 요청할 수 있음
// 특정 클래스의 인스턴스 생성을 spring에 요청하려면 어노테이션을 추가해야함
// spring에게 검색할 패키지를 어떻게 알려줄 수 있을지 - @componentScan
// 컴포넌트를 어디섯 찾아야할지 알려줘야 찾을 수 있음(패키지가 달려졌기 때문?)
// spring이 pacmangame의 인스턴스르 생성하고,	이 인스턴스가 이곳에 자동연결됨

// spring은 객체를 관리하고, 자동 연결을 수행할 뿐만 아니라 우리에게 객체를 생성해줌
// - @Component를 바탕으로 또 @ComponentScan을 사용해서
// spring은 올바른 패키지를 스캔하고, 컴포넌트를 찾고, 인스턴스를 생성하고 이를 자동으로 추가하며 전체 애플리케이션을 제대로 작동시ㅕㅋ줌
// 패키지 이름이 다를 경우 어떻게해야하지(Pacmangame과 GameRunner의)
