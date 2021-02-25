package java_chobo2.ch15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWirterEx {

	public static void main(String[] args) throws FileNotFoundException, IOException {
//		fileReadWriterEx();

		try (FileReader fr = new FileReader("output2.properties");
				BufferedReader br = new BufferedReader(fr, 8192);

				FileWriter fw = new FileWriter("test.propreties");
				BufferedWriter bw = new BufferedWriter(fw, 8192);) {
			String line;
			while ((line = br.readLine()) != null) {
				bw.write(line);
				bw.newLine();
			}
		}

	}

	private static void fileReadWriterEx() {
		try (FileReader fr = new FileReader("Output.xml"); FileWriter fw = new FileWriter("test.xml");) {

			char[] cbuf = new char[512];
			while ((fr.read(cbuf)) != -1) {
				fw.write(cbuf);
			}
		} catch (FileNotFoundException e) {
			System.out.println("�ش� ������ �������� ����.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
