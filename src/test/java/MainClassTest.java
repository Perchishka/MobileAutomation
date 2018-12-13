import Test1.MainClass;
import org.junit.Assert;
import org.junit.Test;

public class MainClassTest extends BaseTest {

    @Test
    public void testGetLocalNumber(){
        MainClass mainClass = new MainClass();
        Assert.assertTrue(mainClass.getLocalNumber()==14);
    }
}
