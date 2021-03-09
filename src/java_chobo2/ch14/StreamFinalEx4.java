package java_chobo2.ch14;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamFinalEx4 {
	public static void main(String[] args) {
//		new Student(name, isMale, hak, ban, score)
		
		Student2[] stuArr = {
			new Student2("나자바", true,  1, 1, 300),	
			new Student2("김지미", false, 1, 1, 250),	
			new Student2("김자바", true,  1, 1, 200),	
			new Student2("이지미", false, 1, 2, 150),	
			new Student2("남자바", true,  1, 2, 100),	
			new Student2("안지미", false, 1, 2,  50),	
			new Student2("황지미", false, 1, 3, 100),	
			new Student2("강지미", false, 1, 3, 150),	
			new Student2("이자바", true,  1, 3, 200),	
			new Student2("나자바", true,  2, 1, 300),	
			new Student2("김지미", false, 2, 1, 250),	
			new Student2("김자바", true,  2, 1, 200),	
			new Student2("이지미", false, 2, 2, 150),	
			new Student2("남자바", true,  2, 2, 100),	
			new Student2("안지미", false, 2, 2,  50),	
			new Student2("황지미", false, 2, 3, 100),	
			new Student2("강지미", false, 2, 3, 150),	
			new Student2("이자바", true,  2, 3, 200)
		};
		
		Map<Boolean, List<Student2>> stdBySex =
				Arrays.stream(stuArr)
				.collect(Collectors.partitioningBy(Student2::isMale));
		List<Student2> femaleStds = stdBySex.get(false);
		System.out.println("여학생 = " +femaleStds);
		
//		Arrays.stream(stuArr).collect(Collectors.partitioningBy(Student2::))
		
//		Map<Boolean, List<Student2>> stdNumBySex =
//				Arrays.stream(stuArr)
//				.collect(
//						Collectors.partitioningBy(Student2::isMale, Collectors.counting()
//								)
//						);
//		System.out.printf("남학생 수 %d, 여학생 수 %d",
//				stdNUmBySex.get(true),);
//		List<Student2> femaleStds = stdBySex.get(false);
		
	}
}
