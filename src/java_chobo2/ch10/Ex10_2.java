package java_chobo2.ch10;

import java.util.Calendar;

public class Ex10_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String[] DAY_OF_WEEK = { "", "일", "월", "화", "수", "목", "금", "토" };
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();

		date1.set(2019, 3, 29);
		System.out.println("date1은 " + toString(date1));
//		long d
	}

	private static String toString(Calendar date) {
		return date.get(Calendar.YEAR)+"년 "+(date.get(Calendar.MONTH)+1)+"월 " + date.get(Calendar.DATE)+"일 ";
	}

}
