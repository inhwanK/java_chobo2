package java_chobo2.ch12;

import java.util.ArrayList;

public class Box<T> {

	ArrayList<T> list = new ArrayList<T>();
//		ArrayList<java_chobo2.ch11.T> list;

	public void add(T item) {
		list.add(item);
	}

	public T get(int idx) {
		return list.get(idx);
	}

	public int size() {
		return list.size();
	}

	public ArrayList<T> getList() {
		return list;
	}

	@Override
	public String toString() {
		return list.toString();
	}

}
