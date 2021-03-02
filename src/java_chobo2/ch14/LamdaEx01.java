package java_chobo2.ch14;

interface LamdaInter {
	public int max(int a, int b);
}

interface LamdaInter01 {
	void printVar(String name, int i);
}

interface LamdaInter02 {
	int square(int x);
}

interface LamdaInter03 {
	int roll();
}

class LamdaInterClass implements LamdaInter {

	@Override
	public int max(int a, int b) {
		return a > b ? a : b;
	}

}

public class LamdaEx01 {

	public static void main(String[] args) {
		LamdaEx01 ex = new LamdaEx01();
		
		

		int a = ex.max(5, 3);
		System.out.println("max = " + a);

		LamdaInterClass lic = new LamdaInterClass();
		int c = lic.max(5, 4);
		System.out.println("max = " + c);

		LamdaInter ldi = (i, j) -> i > j ? i : j;
		int b = ldi.max(5, 3);
		System.out.println("max = " + b);

		LamdaInter01 lbi1 = (String name, int i)->{System.out.println(name+" : " +i);};
		lbi1.printVar("김상건", 5);
		
		LamdaInter01 lbi2 = (name,i)->{System.out.println(name+" : " +i);};
		lbi2.printVar("이나연", 15);

		LamdaInter01 lbi3 = (name,i)->System.out.println(name+ " : " +i);
		lbi3.printVar("신범건", 25);

		LamdaInter02 lbi4 = (int x) -> x * x;
		LamdaInter02 lbi5 = x -> x * x;
		System.out.println("square : "+ lbi4.square(5));
//		System.out.println("square : "+ lbi5.square(5));
		
		
}
	
	private int max(int i, int j) {
		return i > j ? i : j;
	}

}
