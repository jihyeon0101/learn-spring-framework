package com.springclass.learn_spring_framework;

import com.springclass.learn_spring_framework.game.GameRunner;
import com.springclass.learn_spring_framework.game.MarioGame;
import com.springclass.learn_spring_framework.game.PacmanGame;
import com.springclass.learn_spring_framework.game.SuperContraGame;

public class App01GamingBasicJava {

	public static void main(String[] args) {
		
//		var game = new MarioGame();
//		var game = new SuperContraGame();
		var game = new PacmanGame(); // 1: Object Creation 객체 생성
		
		var gameRunner = new GameRunner(game); // 2: Object Creation + Wiring of Dependencies 객체 생성과 동시에 종속성을 연결하는 과정
		// Game is a Dependency of GameRunner
		gameRunner.run();
	}

}
