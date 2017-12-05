import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


public class DataProviderTest {

    private static WebDriver driver;


    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Methods methods = new Methods(driver);
        methods.open();
        methods.fillEmail();
        methods.fillPassword();
        methods.clickButton();
        methods.newProduct();
    }

    @DataProvider(name = "Authentication")

    public static Object[][] credentials() {
        return new Object[][]{
           {"1", "prod1"}
// , {"2", "prod2"}, {"3", "prod3"}
//                , {"4", "prod4"}, {"5", "prod5"}, {"6", "prod6"}, {"7", "prod7"}, {"8", "prod8"}, {"9", "prod9"}, {"10", "prod10"},
//                {"11", "prod11"}, {"12", "prod12"}, {"13", "prod13"}, {"14", "prod14"}, {"15", "prod15"}, {"16", "prod16"}, {"17", "prod17"}, {"18", "prod18"}, {"19", "prod19"}, {"20", "prod20"}

        };
    }

    @Test( dataProvider = "Authentication")

    public void test(String sQuantity, String sNames ) {
        Methods methods = new Methods(driver);
        methods.addProduct();
        methods.clearQuantity();
        methods.addListOfProducts(sQuantity, sNames);
        methods.createProduct();
    }

    @Test (dependsOnMethods = { "test" })
    public void test2() {

        driver.get("http://prestashop-automation.qatestlab.com.ua/ru/");

    }
//    @AfterTest
//    public void afterMethod() {
//        driver.close();
//    }
}