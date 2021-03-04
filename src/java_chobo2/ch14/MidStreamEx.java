package java_chobo2.ch14;

import java.util.Comparator;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MidStreamEx {

	public static void main(String[] args) {
//		extracted01();
		
		
//		extracted02();
		
		Stream<Student> stdStream = Stream.of(
				new Student("김자바",3,300),
				new Student("이자바",3,200),
				new Student("박자바",1,100),
				new Student("최자바",2,150),
				new Student("정자바",2,100),
				new Student("임자바",1,290),
				new Student("사공자바",3,300),
				new Student("제갈자바",3,120)
				);
		
//		stdStream
//		.sorted(Comparator.comparing(Student::getBan)
//				.thenComparing(Comparator.naturalOrder()))
//		.forEach(System.out::println);
		
//		stdStream
//		.sorted(Comparator.comparing(Student::getBan)
//				.thenComparing(Student::getName))
//		.forEach(System.out::println);
		
		stdStream
		.sorted(Comparator.comparing(Student::getBan)
				.thenComparing(Student::getTotalscore))
		.forEach(System.out::println);
		
		
	}

	private static void extracted02() {
		//		sorted
				Stream<String> strStream = Stream.of("dd","aaa","CC","cc","b");
				strStream.sorted().forEach(s->System.out.print(s+" "));
				System.out.println();
				
				Stream.of("dd","aaa","CC","cc","b")
				.sorted(Comparator.naturalOrder())
				.forEach(s->System.out.print(s+" "));
				System.out.println();
				
		
				Stream.of("dd","aaa","CC","cc","b")
				.sorted((s1, s2)-> s1.compareTo(s2))
				.forEach(s->System.out.print(s+" "));
				System.out.println();
				
				Stream.of("dd","aaa","CC","cc","b")
				.sorted(String::compareTo)
				.forEach(s->System.out.print(s+" "));
				System.out.println();
				
				Stream.of("dd","aaa","CC","cc","b")
				.sorted(Comparator.reverseOrder())
				.forEach(s->System.out.print(s+" "));
				System.out.println();
				
				Stream.of("dd","aaa","CC","cc","b")
				.sorted(String.CASE_INSENSITIVE_ORDER)
				.forEach(s->System.out.print(s+" "));
				System.out.println();
				
				Stream.of("dd","aaa","CC","cc","b")
				.sorted(String.CASE_INSENSITIVE_ORDER.reversed())
				.forEach(s->System.out.print(s+" "));
				System.out.println();
	}

	private static void extracted01() {
		//중간연산
		// 1. skip(), limit()
		IntStream.rangeClosed(1,10)
		.skip(3)
		.limit(5)
		.forEach(System.out::print);
		
		System.out.println("중간연산 filter, distinct()");
		IntStream.of(1,2,2,2,3,3,3,4,5,5,5)
		.distinct().forEach(s->System.out.print(s+" "));
		System.out.println();
		
		IntStream.rangeClosed(1,20)
		.filter(i->i%2==0)
		.filter(i->i%3==0)
		.forEach(s->System.out.print(s+" "));
		System.out.println();

		IntPredicate test = new IntPredicate() {
			@Override
			public boolean test(int value) {
				return value % 2 == 0;
			}
		};
		
		IntPredicate p = t -> t%2 ==0;
		
		IntStream.rangeClosed(1,20)
		.filter(p)
		.forEach(s ->System.out.println(s+ " "));
		System.out.println();
	}

}
