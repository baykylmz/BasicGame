package AhmetBuyukyilmaz;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UnitTest3 {
    private  Question question;

    @Before
    public void setUp(){
        question = new Question(10,10);
    }

    @Test
    public void testAnswerTrue(){
        question.setChildsAnswer(question.getA() * question.getB());
        assertTrue(question.getAnswer()==question.getChildsAnswer());
    }

}
