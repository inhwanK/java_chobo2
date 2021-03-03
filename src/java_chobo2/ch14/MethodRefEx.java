package java_chobo2.ch14;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

class MyClass {
	int x;
	int y;

	public MyClass() {

	}

	public MyClass(int x) {
		super();
		this.x = x;
	}

	public MyClass(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyClass other = (MyClass) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("MyClass [x=%s, y=%s]", x, y);
	}

}

public class MethodRefEx {

	public static void main(String[] args) {
		Function<String, Integer> f = s -> Integer.parseInt(s);
		System.out.println(f.apply("16"));

		Function<String, Integer> f2 = Integer::parseInt;
		System.out.println(f2.apply("16"));

		BiFunction<String, String, Boolean> g = (s1, s2) -> s1.equals(s2);
		System.out.println(g.apply("abc", "abc"));

		BiFunction<String, String, Boolean> h = String::equals;
		System.out.println(g.apply("abc", "abc"));

		MyClass m1 = new MyClass(5, 2);
		MyClass m2 = new MyClass(4, 3);
		MyClass m3 = new MyClass(5, 3);

		Function<MyClass, Boolean> j = i -> m1.equals(i);
		System.out.println(j.apply(m2));
		System.out.println(j.apply(m3));

		Function<MyClass, Boolean> x = m1::equals;
		System.out.println(x.apply(m2));
		System.out.println(x.apply(m3));

		Supplier<MyClass> s = MyClass::new;
		System.out.println(s.get());

		Function<Integer, MyClass> t = MyClass::new;
		System.out.println(t.apply(10));
		
		BiFunction<Integer, Integer, MyClass> u = MyClass::new;
		System.out.println(u.apply(20,29));
		
		Function<Integer, int[]> o = int[]::new;
		System.out.print(Arrays.toString(o.apply(20)));
		
	}

}
