package com.springclass.learn_spring_framework.examples.c1;

import java.util.Arrays;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service //@Component 대신에 @Service 사용
public class BusinessCalculationService {
	
	private DataService dataService; // 인터페이스 가져오기
	
	// 생성자 만들어서 의존성 주입
	public BusinessCalculationService(DataService dataService) {
		super();
		this.dataService = dataService;
	}

	public int findMax() {
		return Arrays.stream(dataService.retrieveData())
				.max().orElse(0);
	}
	

}
