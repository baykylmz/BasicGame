package AhmetBuyukyilmaz;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UnitTest2 {

    private  Parent parent;

    @Before
    public void setUp(){
        parent = new Parent("Ahmet","321");
    }

    @Test
    public void testChildArray(){
        parent.addChild(new Child("Child"));
        assertTrue(parent.getChilds()!=null);;
    }
    @Test
    public void testModeArray(){
        parent.addChild(new Child("Child"));
        assertTrue(parent.getModes()!=null);;
    }

    @Test
    public void testUserName(){
        parent.setUserName("Deneme");
        assertTrue(parent.getUserName().equals("Deneme"));
    }

    @Test
    public void testPassword(){
        parent.setPassword("123");
        assertTrue(parent.getPassword().equals("123"));
    }

}
