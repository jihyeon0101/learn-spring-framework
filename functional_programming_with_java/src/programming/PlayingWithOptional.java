package programming;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class PlayingWithOptional {

	public static void main(String[] args) {
		List<String> fruits = List.of("apple", "banana", "mango");
		
		// b로 시작하는 첫번째 과일 찾기
		Predicate<? super String> predicate = fruit -> fruit.startsWith("c");
		Optional<String> optional = fruits.stream().filter(predicate).findFirst();
		// optional이 생성되는 이유: b로 시작하는 과일이 있을수도 있고 없을수도 있음
		// optional은 null이 아닌 값을 포함할수도, 포함하지 않을수도 있는 컨테이너 객체임
		
		System.out.println(optional);
		System.out.println(optional.isEmpty()); // false 비어있지 않음
		System.out.println(optional.isPresent()); // true
		System.out.println(optional.get()); // 해당하는 값 출력
		
		// 값이 없을 경우, null이 아니라 Optional.empty로 반환됨(optional클래스의 장점)
		// - Java8부터는 빈값에 null을 사용하지 않고, Optional을 사용하는 것을 권장함
		Optional<String> fruit = Optional.of("banana");
		Optional<String> empty = Optional.empty();
	}

}
