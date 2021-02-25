package java_chobo2.ch11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class ListEx2 {

	public static void main(String[] args) {

		HashMap<Integer, Department> depthash = new HashMap<>();
		depthash.put(1, new Department(1,"±‚»π1",21));
		depthash.put(2, new Department(2,"±‚»π2",22));
		depthash.put(3, new Department(3,"±‚»π3",23));
		depthash.put(4, new Department(4,"±‚»π4",24));
		
		System.out.println(depthash);
		
		Iterator<Entry<Integer, Department>> i = depthash.entrySet().iterator();
		while(i.hasNext()) {
			Entry<Integer, Department> e = i.next();
			System.out.println(e.getKey()+ " ");
			System.out.println(depthash.get(e.getKey()));
			
//			System.out.println(i.next());
//			System.out.println(i.next());
		}
		
		//		extracted();
	}

	private static void extracted() {
		ArrayList objList = new ArrayList<>();
		objList.add("aa");
		objList.add(1);
		objList.add(new Department(1,"√÷º¯Ω«",10));
		
		Iterator i = objList.iterator();
		while(i.hasNext()) {
			Object obj = i.next();
			System.out.println(obj);
		}
		
		ArrayList<Department> deptList = new ArrayList<>();
		deptList.add(new Department(1,"±‚»π1",10));
		deptList.add(new Department(2,"±‚»π2",20));
		deptList.add(new Department(3,"±‚»π3",30));

		Iterator<Department> iDept = deptList.iterator();
		while(iDept.hasNext()) {
			System.out.println(iDept.next());
		}
	}

}
