package com.springclass.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
	
//	private SuperContraGame game;
	private GamingConsole game; // 클래스를 직접 사용하는 대신 인터페이스(GamingConsole)를 사용함
	
//	GameRunner 클래스는 특정 게임에 강하게 결합되어 있었음
//	게임을 변경해서 실행하고자 할 때는 GameRunner 클래스 코드를 변경해야함
//	GamingConsole 인터페이스를 도입함으로써 GameRunner 클래스가 특정 게임에서 분리되었음
//	특정 인터페이스와만 결합되어 있기 때문에 GameRunner 클래스를 변경하지 않아도 플레이 게임을 변경할 수 있음
	
	public GameRunner(@Qualifier("SuperContraGameQualifier") GamingConsole game) { // 특정 빈을 직접 지정-> 생성자 주입 -> 자동연결
		this.game = game; // 생성자
	}
	// @Qualifier가 @Primary보다 더 높은 우선순위를 갖고 있음
	
	public void run() {
		System.out.println("Running game" + game); // sysout보다 로깅 프레임워크를 사용하는 것이 좋음
		game.up();
		game.down();
		game.left();
		game.right();
	}
}
