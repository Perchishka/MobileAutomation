package suites;

import Test1.MainClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.*;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        Ex6AndEx7.class,
        Ex9Test.class,
        FistTest.class,
        MainClass.class,
        RotationTest.class,
        SaveNewArticleToMyListTest.class,
        SwipeTest.class
})

public class TestSuite {
}
