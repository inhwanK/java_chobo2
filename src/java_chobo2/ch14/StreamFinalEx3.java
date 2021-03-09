package java_chobo2.ch14;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamFinalEx3 {

	public static void main(String[] args) {

		List<Student> list = new ArrayList<>();
		// 학생 생성
		list.add(new Student("김자바",3,300));
		list.add(new Student("이자바",3,200));
		list.add(new Student("박자바",1,100));
		list.add(new Student("최자바",2,150));
		list.add(new Student("정자바",2,100));
		list.add(new Student("임자바",1,290));
		list.add(new Student("사공자바",3,300));
		list.add(new Student("제갈자바",3,120));
		
		
		OptionalInt maxValue = new Random(1234).ints(1, 46)
				.distinct().limit(6)
				.peek(s -> System.out.println(s + ","))
				.reduce(Integer::max);
		
		Optional<Integer> maxValue2 = new Random(1234).ints(1, 46)
				.distinct().limit(6)//IntStream
				.boxed()  			//Stream<integer>
				.peek(s -> System.out.println(s+","))
				.reduce(Integer::max);
		
		System.out.println("max = " + maxValue.getAsInt());
		System.out.println("max = " + maxValue2.get());
	
		int sum1 = new Random(1234)
				.ints(1,46)
				.distinct()
				.limit(6)
				.reduce(0, (a,b)->a+b);
		
		int sum2 = new Random(1234)
				.ints(1,46)
				.distinct()
				.limit(6)
				.boxed()
				.collect(Collectors.reducing(0, (a,b)->a+b));
		
		int grandTotal1 = list.parallelStream()
				.map(Student::getTotalscore)
				.reduce(0, Integer::sum);
		System.out.println(grandTotal1);
		
		int grandTotal2 = list.parallelStream()
				.collect(Collectors.reducing(0, Student::getTotalscore()));
		
		int grandTotal = list.parallelStream()
				.map(Student::getName)
				.collect(Collectors.joining());
		
		String names1 = list.parallelStream().map(Student::getName)
				.collect(Collectors.joining());
		
		String names2 = list.parallelStream().map(Student::getName)
				.collect(Collectors.joining(","));
		
		String names3 = list.parallelStream().map(Student::getName)
				.collect(Collectors.joining(",","[","]"));
		
		String studentInfo = list.parallelStream().collect(Collectors.joining(","));
		
		System.out.println(names1);
		System.out.println(names2);
		System.out.println(names3);
	}



}
