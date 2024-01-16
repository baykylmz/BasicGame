package AhmetBuyukyilmaz;

import java.io.Serializable;
import java.util.ArrayList;

public class Child implements Serializable {
	private static final long serialVersionUID = 1L;

	private String Name;
	ArrayList<Exam> Exams;


	public Child(String name) {
		Name = name;
		Exams = new ArrayList<Exam>();
	}

	public String getName() {
		return Name;
	}

	public ArrayList<Exam> getExams() {
		return Exams;
	}

	public void setExams(ArrayList<Exam> exams) {
		Exams = exams;
	}

	public void setName(String name) {
		Name = name;
	}

	public void addExam(Exam E){Exams.add(E);}
}
