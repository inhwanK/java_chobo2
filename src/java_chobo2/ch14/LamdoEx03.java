package java_chobo2.ch14;


@FunctionalInterface
interface MyFunction{
	void myMethod();
}
public class LamdoEx03 {

	public static void main(String[] args) {
		MyFunction f = ()->System.out.println("myMethod()");
		aMethod(f);

	}

	public static void aMethod(MyFunction f) {
		f.myMethod();
	}
}
