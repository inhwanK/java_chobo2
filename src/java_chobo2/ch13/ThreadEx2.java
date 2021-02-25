package java_chobo2.ch13;

public class ThreadEx2 extends Thread{

	public static void main(String[] args) throws InterruptedException {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 300; i++) {
			System.out.printf("%s", new String("."));
		}

		long endTime = System.nanoTime();
		System.out.printf("%s 나노초 %n", "첫번째 작업", System.currentTimeMillis() - startTime);
		
		for(int i=0;i<300;i++) {
			System.out.printf("%s","l");
		}
		System.out.println();
		System.out.printf("%s %d 초%n","두번째작업",System.currentTimeMillis() - startTime);

	}

}
