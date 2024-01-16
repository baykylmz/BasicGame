package AhmetBuyukyilmaz;

import java.io.Serializable;
import java.util.Random;

public class Question implements Serializable {
	private static final long serialVersionUID = 1L;
	private int A;
	private int B;
	private int Answer;
	private int ChildsAnswer;
	private boolean isAnswered;
	private int Time;
	Random rand = new Random();
	
	public int getTime() {
		return Time;
	}

	public void setTime(int time) {
		Time = time;
	}
	
	public Question(int X,int Y) {
		this.A = rand.nextInt(X) + 1;
		this.B = rand.nextInt(Y) + 1;
		this.Answer = A*B;
		this.isAnswered = false;
	}

	public boolean setChildsAnswer(int childsAnswer) {
		if(this.isAnswered()) {
			return false;
		}
		else {
			this.ChildsAnswer = childsAnswer;
			setAnswered(true);
			return true;
		}
	}

	public boolean isTrue(){
		if(this.isAnswered()){
			if(this.getChildsAnswer()==this.getAnswer()){
				return true;
			}
		}
		return false;
	}

	public int getChildsAnswer() {
		return ChildsAnswer;
	}

	public int getA() {
		return A;
	}

	public int getB() {
		return B;
	}

	public int getAnswer() {
		return Answer;
	}

	public boolean isAnswered() {
		return isAnswered;
	}

	public void setAnswered(boolean isAnswered) {
		this.isAnswered = isAnswered;
	}

}
