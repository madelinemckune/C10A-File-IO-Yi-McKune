/**
 * Authors: Madeline McKune, Edward Yi
 * Assignment: C10A File IO
 */
public class Student implements Comparable<Student> {
	//student has two privates
	private String name;
	private int score;
	
	//constructor for student
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	//compare GPA
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return (int)Math.round((score-o.score)*10);
	}

	//toString method
	@Override
	public String toString() {
		return  name + " " +score;
	}
	
}
