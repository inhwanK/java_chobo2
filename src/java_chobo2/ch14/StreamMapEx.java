package java_chobo2.ch14;

import java.io.File;
import java.lang.Character.Subset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMapEx {

	
	public static void main(String[] args) {
//		extracted1();
//		extracted();
		
		IntStream intStream = new Random().ints(1,46);
		Stream<Integer> integerStream = intStream.boxed();
		integerStream.limit(6).forEach(System.out::println);
		
		Stream<String> lottoStream = new Random().ints(1,46)
				.distinct().limit(6).sorted()
				.mapToObj(i -> i+",");
		lottoStream.forEach(System.out::print);
	}

	private static void extracted1() {
		List<Student> list = new ArrayList<>();
				list.add(	new Student("김자바",3,300));
				list.add(new Student("이자바",3,200));
				list.add(new Student("박자바",1,100));
				list.add(new Student("최자바",2,150));
				list.add(new Student("정자바",2,100));
				list.add(new Student("임자바",1,290));
				list.add(new Student("사공자바",3,300));
				list.add(new Student("제갈자바",3,120));
	}

	private static void extracted() {
		//스트림을 기본 스트림으로 변환.
		
		
		
		List<File> list = new ArrayList<File>();
		list.add(new File("Ex1.java"));
		list.add(new File("Ex1.bak"));
		list.add(new File("Ex2.java"));
		list.add(new File("Ex1"));
		list.add(new File("Ex1.txt"));
		
		Stream<File> fileStream = list.stream();
		
		//map()으로 Stream<File>을 Stream<String>으로 변환
		
		Stream<String> fileNameStream = fileStream.map(File::getName);
		fileNameStream.forEach(System.out::println);
		
		System.out.println();
		
		list.stream().map(File::getName)
		.filter(s-> s.indexOf('.') !=-1)
		.peek(System.out::println)
		.map(s -> s.substring(s.indexOf('.')+1))
		.map(String::toUpperCase)
		.distinct()
		.forEach(System.out::print);
		
		System.out.println();
		Set<String> s = new HashSet<>();
		for(File f : list) {
			String ext = f.getName();
			if (ext.indexOf('.')!= -1) {
				s.add(ext.substring(ext.indexOf('.')+1).toUpperCase());
			}
		}
		System.out.println(s);
			
		File file = new File("test.java");
		String fileName = file.getName();
		int idx = fileName.indexOf(".");
		System.out.println(fileName + " : " + idx);
		System.out.println(fileName.substring(idx+1));
	}

}
