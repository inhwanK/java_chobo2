package java_chobo2.ch11;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapEx {

	public static void main(String[] args) {
		HashMap<Integer, Student> map = new HashMap<>();
		Student std1 = new Student(1,"À¯ÇÑ¼Ö",90,80,70);
		Student std2 = new Student(2,"±èÅÂ¿î",91,81,70);
		Student std3 = new Student(3,"±èÀç¿ø",92,82,70);
		Student std4 = new Student(4,"½Åº´°Ç",93,83,70);
		Student std5 = new Student(5,"±è°æ¿¬",94,84,70);

		map.put(std1.getStdNo(), std1);
		map.put(std2.getStdNo(), std2);
		map.put(std3.getStdNo(), std3);
		map.put(std4.getStdNo(), std4);
		map.put(std5.getStdNo(), std5);
		
		prnMap(map);
		
		Student std6 = new Student(3,"±èÅÂÇü",98,88,77);
		map.replace(std6.getStdNo(), std6);
		
		prnMap(map);
		
		boolean isExsists = map.containsKey(7);
		System.out.println(isExsists);
		
		map.remove(3);
		prnMap(map);
		
		
	}

	private static void prnMap(HashMap<Integer, Student> map) {
		// TODO Auto-generated method stub
		System.out.println("=====");
		Set<Entry<Integer,Student>> s = map.entrySet();
		for(Entry<Integer, Student> e:s) {
			System.out.println(e.getKey() + " = " + e.getValue());
		}
		System.out.println();
		
		Set<Integer> keySet = map.keySet();
		for(Integer key: keySet) {
			System.out.println(key + " = " + map.get(key));
		}
		System.out.println();
	}
	

}
