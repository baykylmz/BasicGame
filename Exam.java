package AhmetBuyukyilmaz;

import java.io.Serializable;
import java.util.ArrayList;

public class Exam implements Serializable {
	private static final long serialVersionUID = 1L;
	private int QuestionsNumber;
	private ArrayList<Question> Questions;
	private int Score;
	private int count;
	private int time;
	private String startDate;
	private String finishDate;
	private String childName;

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String date) {
		this.startDate = date;
	}

	public String getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public int getQuestionsNumber() {
		return QuestionsNumber;
	}

	public void setQuestionsNumber(int questionsNumber) {
		QuestionsNumber = questionsNumber;
	}

	public ArrayList<Question> getQuestions() {
		return Questions;
	}

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}

	public Exam(int A,int B,int questionsNumber,String name) {
		this.childName = name;
		this.count = 0;
		this.QuestionsNumber = questionsNumber;
		Questions = new ArrayList<Question>();
		int i = 0;
		while(i<getQuestionsNumber()) {
			Questions.add(new Question(A,B));
			i++;
		}
	}
	public int getTime(){
		int r =0;
		for (Question question:this.getQuestions()) {
			r+=question.getTime();
		}
		return r;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void calculateScore() {
		int tmp1 = 0;
		for (Question question : Questions) {
			int a = 0;
			if(question.isTrue()) a =1;
			tmp1 += a;
		}
		tmp1 *= 100/getQuestionsNumber();
		tmp1 -=(this.getTime()*2) ;
		this.setScore(tmp1);
	}
	
}
