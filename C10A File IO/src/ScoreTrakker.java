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
				//student name is first line
				String fullName = in.nextLine();
				//followed by score
				String stringGpa = in.nextLine();
				int gpa = 0;
				
				try {
					//check if string = int
					gpa = Integer.parseInt(stringGpa);
					//create student object
					Student current = new Student(fullName, gpa);
					tempStudent.add(current);
				//throw exception if score is not an int
				}catch(NumberFormatException n) {
					System.out.println("Incorrect format for " + fullName + " not a valid score: " + stringGpa);
					System.out.println("");
				}
			}
			//update the student arrayList
			students = tempStudent;
		
	}
	
	public void printInOrder() {
		//sort for comparable
		Collections.sort(students);
		//iterative for loop to print student objects
		for(Student s: students) {
			System.out.println(s);
		}
	}
	
	public void processFiles() throws FileNotFoundException {
		//for the current file name
		for(String f : this.files) {
			//check if it is a valid file
			try {
				this.loadDataFromFile(f);
				this.printInOrder();
				System.out.println("");
			}
			//if not a valid file
			catch(FileNotFoundException e){
				System.out.println("Can't open file: " + f);
				System.out.println("");
			}
		}
		
		
	}
	//main that creates scoreTrakker object
	public static void main (String [] args) throws FileNotFoundException{
		ScoreTrakker s = new ScoreTrakker();
		s.processFiles();
		
	}
	
}
