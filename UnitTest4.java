package AhmetBuyukyilmaz;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UnitTest4 {
    private  Exam exam;

    @Before
    public void setUp(){
        exam = new Exam(10,10,5,"Default");
    }

    @Test
    public void testQuestionsArray(){
        assertTrue(exam.getQuestions()!=null);
    }

    @Test
    public void testScore(){
        exam.calculateScore();
        assertTrue(exam.getScore()==0);
    }
}
