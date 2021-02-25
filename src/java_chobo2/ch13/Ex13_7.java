package java_chobo2.ch13;

public class Ex13_7 implements Runnable {
	static boolean autoSave = false;

	public static void main(String[] args) {
		Thread t = new Thread(new Ex13_7());
		t.setDaemon(true);
		t.start();

		for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(1000);
				System.out.println(i);
				if (i == 5)
					autoSave = true;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		System.out.println("프로그램을 종료합니다.");
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(3 * 1000);
				if (autoSave)
					autoSave();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void autoSave() {
		System.out.println("작업파일이 자동저장되었습니다.");
	}

}
