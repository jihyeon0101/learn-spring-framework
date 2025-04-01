package programming;

import java.util.List;

public class FP01Functional {

	public static void main(String[] args) {

		List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
		// printAllNumbersInListFunctional(numbers);
		// printEvenNumbersInListFunctional(numbers);
		printSquaresOfEvenNumbersInListFunctional(numbers);

	}
	
//	private static void print(int number) {
//		System.out.println(number);
//	}
	
//	private static boolean isEven(int number) {
//		return number%2 == 0;
//	}
	
	private static void printAllNumbersInListFunctional(List<Integer> numbers) {
		// [12,9,13,4,6,2,4,12,15]
		// 12
		// 9
		// 13
		// ....
		
		// What to do?
		// 숫자 리스트를 숫자 스트림으로 변환한 후, 각 요소에 대해 출력을 실행 
		// - 숫자 각각에 print메소드 호출
//		numbers.stream()
//			.forEach(FP01Functional::print); // 메소드 참조 구문 - 클래스이름::메서드 이름 입력
		
		// System.out에 println이라는 스태틱 메서드가 포함되어 있음. 새 메서드를 생성하는 것보다 이렇게 사용하는게 더 간편함
		numbers.stream()
			.forEach(System.out::println); // 메소드 참조 구문 - 클래스이름::메서드 이름 입력(각 요소에 적용)
	}
	
	// number -> number%2 == 0 (파라미터인 number를 가져다가 짝수인지 확인해주는 것) 
	private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
		numbers.stream()
			//Filter - Only Allow Even Numbers
			.filter(number -> number%2 == 0) // Lambda Expression - 람다식은 메서드를 더 간단하게 정의하는법(람다식은 메서드다)
			.forEach(System.out::println); // 메소드 참조 구문 - 클래스이름::메서드 이름 입력

			// .filter(FP01Functional::isEven) // 각각의 숫자를 호출할 메서드이고 true를 반환하면 다음 코드 라인으로 진행함
	}
	
	private static void printSquaresOfEvenNumbersInListFunctional(List<Integer> numbers) {
		numbers.stream()
		//Filter - Only Allow Even Numbers
		.filter(number -> number%2 == 0) // Lambda Expression - 람다식은 메서드를 더 간단하게 정의하는법(람다식은 메서드다)
		// 매핑(mapping) - x -> x * x
		.map(number -> number * number) // 각 요소(숫자)를 매핑
		.forEach(System.out::println); // 메소드 참조 구문 - 클래스이름::메서드 이름 입력
		
		// .filter(FP01Functional::isEven) // 각각의 숫자를 호출할 메서드이고 true를 반환하면 다음 코드 라인으로 진행함
	}

}
