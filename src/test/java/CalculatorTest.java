import org.testng.Assert;
import org.testng.annotations.*;

public class CalculatorTest {

    @BeforeSuite
    void beforeSuite() {
        System.out.println("This will execute before the suite");
    }

    @BeforeTest
    void beforeClass() {
        System.out.println("This will execute before the class");
    }

    @BeforeMethod
    void beforeMethod() {
        System.out.println("Before each method.");
    }


    @Test(priority = 2, groups={"addition"})
    @Parameters({"i", "j"})
    void addTest(int i, int j) {

        CalculatorMain calculatorMain = new CalculatorMain();

        Assert.assertEquals(i+j, calculatorMain.add(i,j));
    }


    @Test(priority = 1, enabled = true, groups={"subtraction"})
    @Parameters({"i", "j"})
    void subtractTest(int i, int j) {

        CalculatorMain calculatorMain = new CalculatorMain();

        Assert.assertEquals(i-j, calculatorMain.subtract(i,j));
    }


    @Test(priority = 1, groups={"multiplication"}, dataProvider = "CalculatorDataProvider")
//    @Parameters({"i", "j"})
    void multiplyTest(int i, int j) {

        CalculatorMain calculatorMain = new CalculatorMain();

        Assert.assertEquals(i*j, calculatorMain.multiply(i,j));
    }

    @DataProvider(name="CalculatorDataProvider")
    public Object[][] getInts() {
        return new Object[][] {{5,3},{3,3},{2,5}};
    }


    @AfterMethod
    void afterMethod() {
        System.out.println("After each method");
    }

    @AfterClass
    void afterClass() {
        System.out.println("This will execute after the class");
    }

    @AfterSuite
    void afterSuite() {
        System.out.println("This will execute after the suite.");
    }
}
