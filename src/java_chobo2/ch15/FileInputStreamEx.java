package java_chobo2.ch15;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamEx {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		fileInputStreamEx();
		File file = new File("8.jpg");
		try (FileInputStream fis = new FileInputStream(file);
				BufferedInputStream bis = new BufferedInputStream(fis, 8192);
				
				FileOutputStream fos = new FileOutputStream("test2.gif");
				BufferedOutputStream bos = new BufferedOutputStream(fos, 8192);) {
			int data = 0;
			while((bis.read() != -1)) {
				bos.write(data);
			}
		}
	}

	private static void fileInputStreamEx() {
		try (FileInputStream fis = new FileInputStream("8.jpg");
				FileOutputStream fos = new FileOutputStream("test.gif");) {
			int data = 0;
			while ((data = fis.read()) != -1) {
				fos.write(data);
				System.out.print((char) data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
