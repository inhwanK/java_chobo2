package java_chobo2.ch10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatEx {
	public static void main(String[] args) throws ParseException {

		Date toDay = new Date();
		System.out.println(toDay);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� E���� a K�� m�� s��");
		System.out.println(sdf.format(toDay));
		
		String str = "2021�� 02�� 16��";
		sdf.applyPattern("yyyy�� MM�� dd��");
		System.out.println(sdf.parse(str));
		
	}
}
