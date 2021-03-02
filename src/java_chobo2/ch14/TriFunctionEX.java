package java_chobo2.ch14;

public class TriFunctionEX {

	public static void main(String[] args) {
		TriFunction<Integer, Integer, Integer, Integer> tri = new TriFunction<Integer, Integer, Integer, Integer>() {

			@Override
			public Integer apply(Integer t, Integer u, Integer v) {

				return t * u * v;
			}

		};

		System.out.println(tri.apply(10, 10, 10));
		TriFunction<Integer, Integer, Integer> tri01 = (t, u, v) -> t * u * v;
		System.out.println(tri101.apply(2,2,2));

	}

}
