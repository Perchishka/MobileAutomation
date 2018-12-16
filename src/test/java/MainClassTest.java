import Test1.MainClass;
import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends BaseTest {

    MainClass mainClass = new MainClass();

    @Test
    public void testGetLocalNumber(){

        Assert.assertTrue("The number is not correct",mainClass.getLocalNumber()==14);
    }

    @Test
    public void  testGetClassNumber(){
        Assert.assertTrue("The number "+mainClass.getClassNumber()+" is not > 45",
                mainClass.getClassNumber()>45);
    }

    @Test
    public void testGetClassString(){
        Assert.assertTrue("The string is not correct", mainClass.getClass_string().contains("hello")
                | mainClass.getClass_string().contains("Hello"));
}
}
