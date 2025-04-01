package com.springclass.learn_spring_framework.game;

public class GameRunner {
	
//	private SuperContraGame game;
	private GamingConsole game; // 클래스를 직접 사용하는 대신 인터페이스(GamingConsole)를 사용함
	
//	GameRunner 클래스는 특정 게임에 강하게 결합되어 있었음
//	게임을 변경해서 실행하고자 할 때는 GameRunner 클래스 코드를 변경해야함
//	GamingConsole 인터페이스를 도입함으로써 GameRunner 클래스가 특정 게임에서 분리되었음
//	특정 인터페이스와만 결합되어 있기 때문에 GameRunner 클래스를 변경하지 않아도 플레이 게임을 변경할 수 있음
	
	public GameRunner(GamingConsole game) {
		this.game = game; // 생성자
	}
	
	public void run() {
		System.out.println("Running game" + game); // sysout보다 로깅 프레임워크를 사용하는 것이 좋음
		game.up();
		game.down();
		game.left();
		game.right();
	}
}
