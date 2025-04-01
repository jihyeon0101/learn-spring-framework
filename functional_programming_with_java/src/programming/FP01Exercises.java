package programming;

import java.util.List;

public class FP01Exercises {

	public static void main(String[] args) {

		List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);

		printOddNumbersInListFunctional(numbers);
		
		List<String> courses = 
				List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
		
		printAllCourses(courses);
		printSpringCourses(courses);
		printFourLettersCourses(courses);
		
		printCubesOfOddNumbersInListFunctional(numbers);
		printLettersCountCourses(courses);
	}
		
	// 1. 홀수만 출력
	private static void printOddNumbersInListFunctional(List<Integer> numbers) {
		numbers.stream()
			.filter(number -> number%2 == 1)
			.forEach(System.out::println);
	}
	
	// 2. 전체 교육과정 출력
	private static void printAllCourses(List<String> courses) {
		courses.stream()
			.forEach(System.out::println);
	}

	// 3. "Spring"이 포함된 교육과정만 출력
	private static void printSpringCourses(List<String> courses) {
		courses.stream()
			.filter(course -> course.contains("Spring")) // contains: 
			.forEach(System.out::println);
	}
	
	// 4. 4글자 이상 교육과정만 출력
	private static void printFourLettersCourses(List<String> courses) {
		courses.stream()
			.filter(course -> course.length() >= 4)
			.forEach(System.out::println);
	}
	
	// 5. 홀수의 세제곱 출력
	private static void printCubesOfOddNumbersInListFunctional(List<Integer> numbers) {
		numbers.stream()
		.filter(number -> number % 2 == 1)
		.map(number -> number * number * number)
		.forEach(System.out::println);
	}
	
	// 6. 교육과정의 문자 길이 출력
	private static void printLettersCountCourses(List<String> courses) {
		courses.stream()
		.map(course -> course + " : " +course.length())
		.forEach(System.out::println);
	}
}
