package java_chobo2.ch11;

import java.util.ArrayList;
import java.util.Comparator;

class Department{
	private int deptNo;
	private String deptname;
	private int floor;

	@Override
	public String toString() {
		return String.format("Department [%s, %s, %s]", deptNo, deptname, floor);
	}

	public Department(int deptNo, String deptname, int floor) {
		this.deptNo = deptNo;
		this.deptname = deptname;
		this.floor = floor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deptNo;
		result = prime * result + ((deptname == null) ? 0 : deptname.hashCode());
		result = prime * result + floor;
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
		Department other = (Department) obj;
		if (deptNo != other.deptNo)
			return false;
		if (deptname == null) {
			if (other.deptname != null)
				return false;
		} else if (!deptname.equals(other.deptname))
			return false;
		if (floor != other.floor)
			return false;
		return true;
	}

	public Department() {

		// TODO Auto-generated constructor stub
	}

	public Department(int deptNo) {
		this.deptNo = deptNo;
	}
}

public class ArrayListsEx {

	public static void main(String[] args) {
		ArrayList<Department> deptList  = new ArrayList<>();
		deptList.add(new Department(1,"기획", 20));
		deptList.add(new Department(2,"개발", 10));
		deptList.add(new Department(3,"인사", 30));
		
		prnList(deptList);
		
		boolean isConstain = deptList.contains(new Department(2));
		deptList.remove(new Department(2));
		prnList(deptList);
		
	
		ArrayList<Integer> arList = new ArrayList<>();
		System.out.println(arList);
		
		deptList.indexOf(new Department(2,"개발", 10));
		
		//추가
//		ArrayList<String> strList = extractedStringList(arList);
//		System.out.println(strList);
	}

	private static ArrayList<String> extractedMehtod1(ArrayList<Integer> arList) {
		arList.add(10); // autoboxing
		arList.add(20);
		System.out.println(arList);
		System.out.println(arList.size());
		
		arList.add(1, 40);
		System.out.println(arList);
		System.out.println(arList.size());
		
		System.out.println("40 indexOf " + arList.indexOf(40));
		
		arList.remove(1);
		System.out.println(arList);
		System.out.println(arList.size());
		
		arList.add(40);
		arList.add(50);
		System.out.println(arList);
		System.out.println(arList.size());
		
		arList.remove(new Integer(50));
		System.out.println(arList);
		System.out.println(arList.size());
		
		for(int a : arList) {
			System.out.println(a);
		}
		for(int i=0;i<arList.size();i++) {
			System.out.println(arList.get(i));
		}
		arList.set(1, 40);
		System.out.println(arList);
		
		if(arList.contains(30)) {
			System.out.println("10 있음");
		}else {
			System.out.println("10 없음");
		}
		
		System.out.println(arList.contains(60));
		
		ArrayList<String> strList = new ArrayList<>();
		strList.add("a");
		strList.add("b");
		strList.add("c");
		
		System.out.println(strList);
		strList.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return (o1.hashCode()-o2.hashCode())*-1;
			}
		});
		return strList;
	}

	private static void prnList(ArrayList<Department> deptList) {
		for(Department d : deptList) {
			System.out.println(d);
		}
		System.out.println();
		
	}

}
