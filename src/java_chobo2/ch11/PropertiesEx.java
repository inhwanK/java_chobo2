package java_chobo2.ch11;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import javax.sound.sampled.AudioFormat.Encoding;

public class PropertiesEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Properties prop = new Properties();

		prop.setProperty("url", "jdbc:mysql://localhost:3306/mysql_study?useSSL=false");
		prop.setProperty("user", "user_mysql_study");
		prop.setProperty("password", "rootroot");

		// file 저장
		try {
			prop.store(new FileOutputStream("oupt.txt"), "Properties Examples");
			prop.store(new FileWriter("output2.properties"), "Properties Examples");
			prop.storeToXML(new FileOutputStream("oupt.xml"), "Properties Examples XML", "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		file 로부터 로드
		Properties loadProp = new Properties();
		Properties xmlProp = new Properties();
		try {
			loadProp.load(new FileInputStream("oupt.txt"));
			prnProperties(loadProp);
			
			xmlProp.loadFromXML(new FileInputStream("oupt.xml"));
			prnProperties(xmlProp);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void prnProperties(Properties loadProp) {
		// TODO Auto-generated method stub
		Set<Object> keys = loadProp.keySet();
		for (Object key : keys) {
			System.out.println(key + " : " + loadProp.getProperty((String) key));
		}
	}

//		

}
