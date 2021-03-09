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
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamFinalEx2 {

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

	
		
		
		
		
		
		extracted2(list);
		
		
		extracted(list);
	}

	private static void extracted2(List<Student> list) {
		//스트림의 통계정보
		long cnt1 = list.stream().count();
		long cnt2 = list.stream().collect(Collectors.counting());
		System.out.printf("count %d, %d%n", cnt1, cnt2);
		
		int sum1 = list.parallelStream().mapToInt(Student::getTotalscore)
				.peek(System.out::println)
				.sum();
		
		int sum2 = list
		.parallelStream()
		.collect(Collectors.summingInt(Student::getTotalscore));

		System.out.printf("totalScore %d, %d%n", sum1, sum2);
		
		OptionalInt max1 = list
				.parallelStream()
				.mapToInt(Student::getTotalscore)
				.peek(System.out::println)
				.max();
		System.out.printf("maxScore %d%n", max1.getAsInt());
		Optional<Student> maxStd1 = list.parallelStream().max(Comparator.comparingInt(Student::getTotalscore));
		Student std = maxStd1.get();
		System.out.println(std);
		
		Optional<Student> maxStd2 = list.parallelStream()
				.collect(Collector
						.Comparator.comparingInt(Student::getTotalscore));
		Student std1 = maxStd2.get();
		System.out.println(std1);
		
//		IntSummaryStatistics iss1 = list
//									.parallelStream()
//									.mapToInt(Student::getTotalscore)
//									.
	}

	private static void extracted(List<Student> list) {
		List<String> stdList = list.stream().map(Student::getName).peek(System.out::println)
				.collect(Collectors.toList());

		System.out.println(stdList);
		ArrayList<Student> arList = list.stream().collect(Collectors.toCollection(ArrayList::new));
		System.out.println(arList);
		
		Map<String, Student> map = list.stream()
				.collect(Collectors.toMap(s->s.getName(), s->s));
		
		for(java.util.Map.Entry<String, Student> e : map.entrySet()) {
			System.out.println(e.getKey()+" : " + e.getValue());
		}
	}

}
