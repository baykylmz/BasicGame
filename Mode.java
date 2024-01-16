package AhmetBuyukyilmaz;

import java.io.Serializable;

public class Mode implements Serializable {
    private static final long serialVersionUID = 1L;
    private String Name;
    private int QuestionNumber;
    private int A;
    private int B;

    public Mode(String name, int questionNumber, int a, int b) {
        Name = name;
        QuestionNumber = questionNumber;
        A = a;
        B = b;
    }

    public Mode() {
        Name = "Default_Mode";
        QuestionNumber = 10;
        A = 10;
        B = 10;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getQuestionNumber() {
        return QuestionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        QuestionNumber = questionNumber;
    }

    public int getA() {
        return A;
    }

    public void setA(int a) {
        A = a;
    }

    public int getB() {
        return B;
    }

    public void setB(int b) {
        B = b;
    }

    @Override
    public String toString() {
        return  Name + " N="+QuestionNumber + " A=" + A + " B=" + B ;
    }
}
