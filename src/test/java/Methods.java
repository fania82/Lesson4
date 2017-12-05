import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.interactions.Actions;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Methods {

    private WebDriver driver;

    private By email = By.id("email");
    private By password = By.id("passwd");
    private By button = By.name("submitLogin");
    private By product = By.id("page-header-desc-configuration-add");
    private By quantity = By.id("form_step1_qty_0_shortcut");
    private By productName = By.id("form_step1_name_1");
    private By switchProduct = By.xpath("//*[@id=\"form\"]/div[4]/div[1]/div");
    private By saveProductButton = By.id("product_form_save_go_to_catalog_btn");
    private String emailInput = "webinar.test@gmail.com";
    private String passwordInput = "Xcg7299bnSmMuRLp9ITw";



    public Methods(WebDriver driver) {

        this.driver = driver;
    }

    public void open() {
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
    }

    public void fillEmail() {
        driver.findElement(email).sendKeys(emailInput);
    }

    public void fillPassword() {
        driver.findElement(password).sendKeys(passwordInput);
    }

    public void clickButton() {
        driver.findElement(button).click();
    }

    public void newProduct() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subtab-AdminCatalog")));
        WebElement catalogCatalog = driver.findElement(By.id("subtab-AdminCatalog"));
        Actions builder = new Actions(driver);
        builder.moveToElement(catalogCatalog).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subtab-AdminProducts")));
        driver.findElement(By.id("subtab-AdminProducts")).click();
    }
    public void addProduct (){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(product));
        driver.findElement(product).click();

}
    public void clearQuantity () {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(quantity));
        driver.findElement(quantity).clear();
    }
    public void addListOfProducts(String sQuantity, String sNames){

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(productName));

        driver.findElement(productName).sendKeys(sNames);

        wait.until(ExpectedConditions.visibilityOfElementLocated(quantity));

        driver.findElement(quantity).sendKeys(sQuantity);


    }
    public void createProduct(){

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(switchProduct));

        driver.findElement(switchProduct).click();

        wait.until(ExpectedConditions.elementToBeClickable(saveProductButton));

        driver.findElement(saveProductButton).click();

        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"main-div\"]/div[1]/h2")));

    }
}
