package java_chobo2.ch15;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

public class FileEx {

	public static void main(String[] args) throws IOException {
//		File f = new File("C:\\Users\\202-12\\eclipse-workspace\\native_jdbc_programing\\src\\native_jdbc_programing\\ConnectionTest.java");
		File f = getSearchFile();
		String fileName = f.getName();
		int pos = fileName.lastIndexOf(".");
		
		System.out.println("��θ� ������ �����̸� - " + f.getName());
		System.out.println("Ȯ���ڸ� ������ �����̸� - " + fileName.substring(0,pos));
		System.out.println("Ȯ���� - " + fileName.substring(pos+1));

		System.out.println("��θ� ������ �����̸� - " + f.getPath());
		System.out.println("������ ������ - " + f.getAbsolutePath());
		System.out.println("������ ���԰�� - " + f.getCanonicalPath());
		System.out.println("������ ���� �ִ� ���丮 - " + f.getParent());
		System.out.println();
		System.out.println("File.pathSeparator - " +File.pathSeparator);
		System.out.println("File.pathSeparatorChar - " + File.pathSeparatorChar);
		System.out.println("File.pathSeparator - " + File.separator);
		System.out.println("File.pathSeparatorChar - " + File.separatorChar);
		System.out.println();
		System.out.println("user.dir="+System.getProperty("user.dir"));
		System.out.println("sun.boot.clas.path="+System.getProperty("sun.boot.class.path"));
		
	}
	public static File getSearchFile() {
		JFileChooser jfc = new JFileChooser(System.getProperty("user.dir"));
		int res = jfc.showOpenDialog(null);
		File file = null;
		if(res ==JFileChooser.APPROVE_OPTION) {
			file = jfc.getSelectedFile();
			System.out.println(file.getAbsolutePath());
		}
		return file;
	}
}
