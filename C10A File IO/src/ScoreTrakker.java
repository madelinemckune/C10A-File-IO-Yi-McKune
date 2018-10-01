/**
 * Authors: Madeline McKune, Edward Yi
 * Assignment: C10A File IO
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ScoreTrakker {
	private ArrayList<Student> students;
	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt" };
	
	public void loadDataFromFile(String fileName)throws FileNotFoundException {
	//	try {
			ArrayList<Student> tempStudent = new ArrayList<Student>();
			FileReader reader = new FileReader(fileName);
			Scanner in = new Scanner(reader);
			//read in the title 
			String trash = in.nextLine();
			while (in.hasNextLine()) {
				String fullName = in.nextLine();
				String stringGpa = in.nextLine();
				int gpa = 0;
				
				try {
					gpa = Integer.parseInt(stringGpa);
					Student current = new Student(fullName, gpa);
					tempStudent.add(current);
				}catch(NumberFormatException n) {
					System.out.println("Incorrect format for " + fullName + " not a valid score: " + stringGpa);
					System.out.println("");
				}
		
				//System.out.println(studentFirstName + " " + studentLastName+ " " + gpa);
				//System.out.println(studentName);
				
			}
			students = tempStudent;
		//} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
	//	}
		
	}
	
	public void printInOrder() {
		Collections.sort(students);
		for(Student s: students) {
			System.out.println(s);
		}
	}
	
	public void processFiles() throws FileNotFoundException {
		for(String f : this.files) {
			try {
				this.loadDataFromFile(f);
				this.printInOrder();
				System.out.println("");
			}
			catch(FileNotFoundException e){
				System.out.println("Can't open file: " + f);
				System.out.println("");
			}
		}
		
		
	}
	public static void main (String [] args) throws FileNotFoundException{
		ScoreTrakker s = new ScoreTrakker();
		s.processFiles();
		
	}
	
}
