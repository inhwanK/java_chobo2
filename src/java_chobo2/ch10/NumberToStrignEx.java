package java_chobo2.ch10;

import java.text.DecimalFormat;
import java.text.ParseException;

public class NumberToStrignEx {

	public static void main(String[] args) throws ParseException {
		//1234567 -> format(pattern)  : #,### -> "123,456"
		//"123,567" -> parse(pattern) : #,### -> "123456"
		
		
		//숫자를 문자로 표시 (format)
		int salary = 12345678;
		DecimalFormat df = new DecimalFormat("#,###.#");
		System.out.println(df.format(salary));
	    System.out.printf("%,d%n", salary);
	    String str = String.format("%,d%n", salary);
	    System.out.println(str);
	    String strObj = String.format("%,2f", 1234.56);
	    System.out.println(strObj);
		
		//문자를 숫자로 표시(parse)
		String strnum = "123,456";
		DecimalFormat df2 = new DecimalFormat("0,000.0");
		Number s = df2.parse(strnum);
		int i= s.intValue();
		System.out.printf("i +",i);
		
		
	}
	

	public static void extratemethod() throws ParseException {
		double number = 1234567.89;
		System.out.println(" number > "+number);
		
		DecimalFormat df = new DecimalFormat();
		df.applyPattern("#,###.#");
		
		String str = df.format(number);
		System.out.println(str);
		
		df.applyPattern("000000000.0");
		System.out.println(df.format(number));
		
		df.applyPattern("###########.0");
		System.out.println(df.format(number));
		
		df.applyPattern("0.#E0");
		System.out.println(df.format(number));
		
		Number numberStr = df.parse("1.2E6");
		Double d = numberStr.doubleValue();
		System.out.println(d);
		
		df.applyPattern("#,###.0");
		numberStr = df.parse("123,456.55");
		d= numberStr.doubleValue();
		System.out.println(d);
	}

}
