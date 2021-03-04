package java_chobo2.ch14;

public class Student implements Comparable<Student> {
	private String name;
	private int ban;
	private int totalscore;
	
	
	public String getName() {
		return name;
	}


	public int getBan() {
		return ban;
	}


	public int getTotalscore() {
		return totalscore;
	}


	@Override
	public int compareTo(Student o) {
		
		return (this.totalscore - o.totalscore);
	}


	@Override
	public String toString() {
		return String.format("Student [name=%s, ban=%s, totalscore=%s]", name, ban, totalscore);
	}


	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Student(String name, int ban, int totalscore) {
		super();
		this.name = name;
		this.ban = ban;
		this.totalscore = totalscore;
	}

}
