package java_chobo2.ch11;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntUnaryOperator;

public class ArrayEx {
	public static void main(String[] args) {
//		arrayToString();
//		arrayDeeptoString();
//
//		arraysToEquals();
//		arrayTofill();
//		arrayToList();

//		arrayToBinarySearchBySort();

		Student[] stdArr = { new Student(1, "¿Ã¡æ¿±", 90, 90, 90), new Student(5, "±Ëº∫«ˆ", 80, 30, 90),
				new Student(3, "±Ë¿Œ»Ø", 100, 100, 100), new Student(4, "±Ë¿Á»Ø", 99, 60, 40) };

		Arrays.sort(stdArr);
		prnStudent(stdArr);
		Comparator<Student> comp = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.getKor() - o2.getKor();
			}
		};
		
		Arrays.sort(stdArr, comp);
		prnStudent(stdArr);

		Comparator<Student> revComp = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o1.getMath()-o2.getMath();
			}

		};
		Arrays.sort(stdArr, comp);
		prnStudent(stdArr);
		Arrays.sort(stdArr, revComp);
		prnStudent(stdArr);
		
	}

	private static void prnStudent(Student[] stdArr) {
		System.out.println("¡§∑ƒ");
		for(Student s : stdArr) {
			System.out.println(s);
		}
		System.out.println();
	}

	private static void arrayToBinarySearchBySort() {
		int[] arr = { 10, 9, 5, 6, 7, 8, 1 };

		System.out.println(Arrays.binarySearch(arr, 8));
		long start = System.nanoTime();
		System.out.println("start - " + start);
		System.out.println(Arrays.toString(arr));

		System.out.println(System.nanoTime());
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		long end = System.nanoTime() - start;
		System.out.println("end - " + end);

		System.out.println(Arrays.toString(arr));

		System.out.println(Arrays.binarySearch(arr, 8));
	}

	private static void arrayToList() {
		Integer[] intArr = new Integer[] { 1, 2, 3, 4 };
		List<Integer> arList = Arrays.asList(intArr);

		for (int a : arList) {
			System.out.println(a);
		}
		arList.set(1, 6);
		System.out.println(arList);

		ArrayList<Integer> al = new ArrayList<Integer>(arList);
		al.add(10);
		System.out.println(al);
	}

	private static void arrayTofill() {
		int[] intArr1 = { 1, 2, 3, 4, 5, 6 };
		int[] copyArr1 = Arrays.copyOf(intArr1, intArr1.length);

		System.out.println(Arrays.toString(copyArr1));
		System.out.println(Arrays.equals(intArr1, copyArr1));

		int[] copyArr2 = Arrays.copyOf(intArr1, 3);
		System.out.println(Arrays.toString(copyArr2));

		int[] newArr = new int[10];
		Arrays.fill(newArr, 10);
		System.out.println(Arrays.toString(newArr));
		Arrays.setAll(newArr, (i) -> (int) (Math.random() * 100) + 1);

		System.out.println(Arrays.toString(newArr));
	}

	private static void arraysToEquals() {
		int[] intArr1 = { 1, 2, 3 };
		int[] intArr2 = { 1, 2, 4 };
		System.out.println(Arrays.equals(intArr2, intArr1));

		int[][] intTwoDimen1 = { { 1, 2 }, { 3, 4 } };
		int[][] intTwoDimen2 = { { 1, 2 }, { 3, 5 } };

		System.out.println(Arrays.deepEquals(intTwoDimen1, intTwoDimen2));
	}

	private static void arrayDeeptoString() {
		int[][] twoArr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		System.out.println(Arrays.toString(twoArr));
		System.out.println(Arrays.deepToString(twoArr));
	}

	private static void arrayToString() {
		ArrayList<String> arList = new ArrayList<String>();
		arList.add("abc");
		arList.add("def");
		arList.add("ghi");

		Object[] objArr = arList.toArray();
		String str = Arrays.toString(objArr);
		System.out.println("objArr to String" + objArr);

		String[] strArr = new String[arList.size()];
		arList.toArray(strArr);
		System.out.println(Arrays.toString(strArr));
	}
}
