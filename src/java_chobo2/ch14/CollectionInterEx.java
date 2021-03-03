package java_chobo2.ch14;

import java.awt.RenderingHints.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.function.UnaryOperator;

public class CollectionInterEx {

	public static void main(String[] args) {
		ArrayList<Integer> arList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			arList.add(i);
		}

		ArrayList<Integer> arList2 = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			arList2.add(i);
		}
		arList2.forEach(i -> System.out.print(i + " "));
		System.out.println();

		UnaryOperator<Integer> v = new UnaryOperator<Integer>() {

			@Override
			public Integer apply(Integer t) {
				return t * 10;
			}
		};
		arList.replaceAll(v);
		arList.forEach(i -> System.out.print(i + " "));
		System.out.println();

		UnaryOperator<Integer> u = i -> i * 10;
		arList2.replaceAll(u);
		arList2.forEach(i -> System.out.print(i + " "));
		
		Map<String, String> map = new HashMap<>();

		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		map.put("5", "5");
		
		for(Entry<String, String> e : map.entrySet()) {
			System.out.printf("{ %s -> %s } %n", e.getKey(), e.getValue());
		}
		
		for(String key : map.keySet()) {
			System.out.printf("{ %s -> %s } %n", key, map.get(key));
		}
		
		BiConsumer<String, String> w = new BiConsumer<String, String>() {

			@Override
			public void accept(String t, String u) {
				System.out.printf("{ $s -> %s } %n", t, u);			
			}
		};
		
		System.out.println("Map<key, value> 함수형 인터페이스 출력1");
		map.forEach((key , value) -> System.out.printf("{ %s -> %s }%n", key, value));
	}

}
