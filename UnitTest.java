package AhmetBuyukyilmaz;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UnitTest {

    private Child child;

    @Before
    public void setUp(){
        child=new Child("Aby");
    }

    @Test
    public void testExamArray(){
        child.addExam(new Exam(10,10,10,"Ahmet"));
        assertTrue(child.getExams()!=null);;
    }

    @Test
    public void testExamName(){
        assertTrue(child.getName().equals("Aby"));
    }
}
