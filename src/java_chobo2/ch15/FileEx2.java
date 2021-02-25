package java_chobo2.ch15;

import java.io.File;

import javax.swing.JFileChooser;

public class FileEx2 {

	public static void main(String[] args) {
		File f= getSearchFile();
		File[] files = f.listFiles();
		
		if(!f.exists() || !f.isDirectory()) {
			System.out.println("��ȿ���� ���� ���͸��Դϴ�.");
			System.exit(0);
		}
		System.out.println(f.getName());
		
		for(File file :files) {
			System.out.println(file.isDirectory() ? "["+file.getName()+"]":file.getName());
		}
	}
	public static File getSearchFile() {
		JFileChooser jfc = new JFileChooser(System.getProperty("user.dir"));
		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		
		
		int res = jfc.showOpenDialog(null);
		File file = null;
		if(res ==JFileChooser.APPROVE_OPTION) {
			file = jfc.getSelectedFile();
			System.out.println(file.getAbsolutePath());
		}
		return file;
	}
}