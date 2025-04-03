package com.springclass.learn_spring_framework.examples.c1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository //@Component 대신에 @Repository 사용
public class MySQLDataService implements DataService {
	
	public int [] retrieveData() {
		return new int [] {1, 2, 3, 4, 5};
	}
	

}
