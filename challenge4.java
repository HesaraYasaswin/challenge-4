import java.util.*;
import java.io.*;


class challenge4
{
	private class subject{
		private String studentName;
		private double marks;

		private void setEnglishMarks(double term, double mid, double fin){
			double finalMarks = (term*(30.0/100.0))+(mid*(30.0/100.0))+(fin*(40.0/100.0));
			marks = finalMarks;
		}
		private void setScienceMarks(double attendance, double project, double mid, double fin){
			double finalMarks = (attendance*(10.0/100.0))+(project*(30.0/100.0))+(mid*(30.0/100.0))+(fin*(30.0/100.0));
			marks = finalMarks;
		}
		private void setMathMarks(double q1, double q2, double q3, double q4, double q5, double test1, double test2, double fin){
			double quizAverage = (q1+q2+q3+q4+q5)/5.0;
			double finalMarks = (quizAverage*(15.0/100.0))+(test1*(30.0/100.0))+(test2*(20.0/100.0))+(fin*(35.0/100.0));
			marks = finalMarks;
		}
		private double getMarks(){
			return marks;
		}
	}

	private String fname;
	private String lname;
	private Subject subject = new Subject();
	private char grade;

	private void setName(String firstName, String lastName){
		fname = firstName;
		lname = lastName;
	}
	private String getName(){
		String name = fname+" "+lname;
		return name;
	}
	private void setSubject(String sub){
		subject.setSubjectName(sub);
	}
	private String getSubject(){
		return subject.getSubjectName();
	}
	private void setEnglish(double term, double mid, double final){
		subject.setEnglishMarks(term,mid,final);
	}
	private void setScience(double attendance, double project, double mid, double final){
		subject.setScienceMarks(attendance,project,mid,final);
	}
	private void setMath(double q1, double q2, double q3, double q4, double q5, double test1, double test2, double final){
		subject.setMathMarks(q1,q2,q3,q4,q5,test1,test2,final);
	}
	private double getMarks(){
		return subject.getMarks();
	}
	private char getGrade(){
		char grade = ' ';
		double marks = subject.getMarks();
		if(marks >= 90){
			grade = 'A';
		}else if(marks >= 80){
			grade = 'B';
		}else if(marks >= 70){
			grade = 'C';
		}else if(marks >= 60){
			grade = 'D';
		}else if(marks >= 50){
			grade = 'E';
		}else if(marks >= 40){
			grade = 'F';
		}else if(marks >= 30){
			grade = 'G';
		}else if(marks >= 20){
			grade = 'H';
		}else if(marks >= 10){
			grade = 'I';
		}else if(marks >= 0){
			grade = 'J';
		}else{
			grade = '-';
		}
		return grade;
	}

	public static void main(String[] args)
	{

		FileInputStream fileStream = null;
		String line = "";
		PrintWriter pw;
		try{
			fileStream = new FileInputStream("marks.txt");
			line = br.readLine();
			studCount = Integer.parseInt(line);
			Stud[] array = new Stud[studCount];
			for(int i = 0; i < studCount; i++){
				array[i] = new Student();
			}
			line = br.readLine();
			while(line != null || inputCounter < studCount){//
				String[] splitLine;
				splitLine = line.split(",");
				if(count%2 == 0){
					
					array[inputCounter].setName(splitLine[1],splitLine[0]);
				}
				else{
					
					array[inputCounter].setSubject(splitLine[0]);
					if(splitLine[0].equals("english")){
						array[inputCounter].setEnglish(Integer.parseInt(splitLine[1]),Integer.parseInt(splitLine[2]),Integer.parseInt(splitLine[3]));
					}
					else if(splitLine[0].equals("science")){
						array[inputCounter].setScience(Integer.parseInt(splitLine[1]),Integer.parseInt(splitLine[2]),Integer.parseInt(splitLine[3]),Integer.parseInt(splitLine[4]));
					}
					else if(splitLine[0].equals("math")){
						array[inputCounter].setMath(Integer.parseInt(splitLine[1]),Integer.parseInt(splitLine[2]),Integer.parseInt(splitLine[3]),Integer.parseInt(splitLine[4]),Integer.parseInt(splitLine[5]));
					}
					inputCounter+=1;
				}
				count+=1;
				line = br.readLine();
			}
			fis.close();


		
			pw.println("A: "+gradeArray[0]);
			pw.println("B: "+gradeArray[1]);
			pw.println("C: "+gradeArray[2]);
			pw.println("D: "+gradeArray[3]);
			pw.println("E: "+gradeArray[4]);
			pw.println("F: "+gradeArray[5]);
			pw.close();
		}
		catch(IOException e){
			if(fileStream != null){
				try{
					fileStream.close();
				}
				catch(IOException errorDetails){
				}
			}
		}
	}
}
	}
	
}