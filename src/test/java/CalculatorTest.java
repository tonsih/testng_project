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

        Assert.assertEquals(i+j, CalculatorMain.add(i,j));
    }


    @Test(priority = 1, enabled = true, groups={"subtraction"})
    @Parameters({"i", "j"})
    void subtractTest(int i, int j) {

        Assert.assertEquals(i-j, CalculatorMain.subtract(i,j));
    }


    @Test(priority = 1, groups={"multiplication"}, dataProvider = "CalculatorDataProvider")
//    @Parameters({"i", "j"})
    void multiplyTest(int i, int j) {

        Assert.assertEquals(i*j, CalculatorMain.multiply(i,j));
    }

    @DataProvider(name="CalculatorDataProvider")
    public Object[][] getInts() {
        return new Object[][] {{5,3},{3,3},{2,5}};
    }


    @Test(priority = 4, groups={"division"})
    @Parameters({"j"})
    void testNotZero (int j) {
        Assert.assertTrue(CalculatorMain.notZero(j));
    }


    @Test(priority = 4, groups={"division"}, dependsOnMethods={"testNotZero"})
    @Parameters({"i", "j"})
    public void testDivision(int i, int j) {
        Assert.assertEquals(i/j, CalculatorMain.divide(i, j));
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
