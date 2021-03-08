package java_chobo2.ch14;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamConditionEx {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();

		list.add(new Student("이자바", 1, 300));
		list.add(new Student("김자바", 1, 200));
		list.add(new Student("사공자바", 1, 290));
		list.add(new Student("제갈자바", 2, 280));
		list.add(new Student("박자바", 2, 270));
		list.add(new Student("최자바", 2, 260));
		list.add(new Student("정자바", 3, 250));
		list.add(new Student("피자바", 3, 240));
		list.add(new Student("윤자바", 3, 230));
		list.add(new Student("임자바", 3, 220));

		findEx(list);
		matchEx(list);
	}

	List<Student> list = new ArrayList<Student>();

	private static void findEx(List<Student> list) {
			Stream<Student> stdStream = list.stream();
			Optional<Student> result = stdStream.filter(s->s.getTotalscore() <= 100).findFirst();
			System.out.println(result);
			
			result = list.parallelStream().filter(s->s.getTotalscore() <=100).findAny();
		
		
		

		

		

	}

	private static void matchEx(List<Student> list) {
		Stream<Student> stdStream = list.stream();

		boolean hasRes = stdStream.anyMatch(new Predicate<Student>() {

			@Override
			public boolean test(Student t) {
				return t.getTotalscore() <= 100;
			}
		});
		System.out.printf("hasRes => %s%n", hasRes);

		stdStream = list.stream();
		hasRes = stdStream.allMatch(s -> s.getTotalscore() >= 80);
		System.out.printf("gettotalScore >= 80 : %s%n", hasRes);
	}
}
