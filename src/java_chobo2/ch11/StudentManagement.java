package java_chobo2.ch11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class StudentManagement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<Student> students = new ArrayList<Student>();
		initial(students);

		System.out.println("�л����� ���α׷�");
		int choice;
		do {
			showMenu();
			System.out.print("�޴� > ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				addStudent(students, sc);
				break;
			case 2:
				modifyStudent(students, sc);
				break;
			case 3:
				deleteStudent(students, sc);
				break;
			case 4:
				sortStd(students);
				prnStudent(students);				
				break;
			}
		} while (choice < 5);
		sc.close();
	}

	public static void sortStd(ArrayList<Student> students) {
		students.sort(new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				
				return o1.getStdNo() - o2.getStdNo();
			}
		});
	}

	private static void deleteStudent(ArrayList<Student> students, Scanner sc) {
		prnStudent(students);
		System.out.print("�����ϰ����ϴ� �л���ȣ �Է� > ");
		int delStdNo = sc.nextInt();

		Student delStudent = new Student(delStdNo);
		if (!students.contains(delStudent)) {
			System.out.println("�ش� �ϴ� �л��� �������� ����");
		}

		students.remove(delStudent);
	}

	private static void modifyStudent(ArrayList<Student> students, Scanner sc) {
		// 1. �л���ȣ �Է�
		// 2. �ش� ��ġ�� �Է¹��� �л������� ����
		prnStudent(students);
		System.out.print("�����ϰ����ϴ� �л���ȣ �Է� > ");
		int findStdNo = sc.nextInt();
		Student upStd = new Student(findStdNo);

		if (!students.contains(upStd)) {
			System.out.println("�ش� �ϴ� �л��� �������� ����");
			return;
		}

		int idxStdNo = students.indexOf(upStd);
		students.set(idxStdNo, createStudent(sc));
	}

	private static void addStudent(ArrayList<Student> students, Scanner sc) {
		Student newStd = createStudent(sc);
		if (students.contains(newStd)) {
			System.out.println("������ �л��� �Է��� �� �����ϴ�.");
			return;
		}
		students.add(newStd);
	}

	private static Student createStudent(Scanner sc) {
		System.out.println("�л� ������ �Է��ϼ���. ex) ��ȣ ���� ���� ���� ���� ");
		int stdNo = sc.nextInt();
		String name = sc.next();
		int kor = sc.nextInt();
		int eng = sc.nextInt();
		int math = sc.nextInt();
		return new Student(stdNo, name, kor, eng, math);
	}

	private static void prnStudent(ArrayList<Student> students) {
		for (Student std : students) {
			System.out.println(std);
		}
		System.out.println();
	}

	private static void initial(ArrayList<Student> students) {
		students.add(new Student(1, "������", 90, 90, 90));
		students.add(new Student(2, "����", 91, 91, 91));
		students.add(new Student(3, "������", 92, 92, 92));
	}

	private static void showMenu() {
		String[] m = new String[6];
		m[0] = "�޴��� �����ϻ���.\n";
		m[1] = "1. �л� �߰�\n";
		m[2] = "2. �л� ����\n";
		m[3] = "3. �л� ����\n";
		m[4] = "4. �л� ���\n";
		m[5] = "5. ����\n";

		for (String str : m) {
			System.out.print(str);
		}
	}
}
