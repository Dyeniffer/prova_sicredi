import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UntitledTestCase {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    // Preencher as informações do formulário
    @Test
    public void testUntitledTestCase() throws Exception {
        driver.get("https://www.grocerycrud.com/demo/bootstrap_theme");
        driver.findElement(By.id("switch-version-select")).click();
        new Select(driver.findElement(By.id("switch-version-select"))).selectByVisibleText("Bootstrap V4 Theme");
        driver.findElement(By.id("switch-version-select")).click();
        driver.findElement(By.linkText("Add Customer")).click();
        driver.findElement(By.id("field-customerName")).sendKeys("Teste Sicredi");
        driver.findElement(By.id("field-contactLastName")).click();
        driver.findElement(By.id("field-contactLastName")).sendKeys("Teste");
        driver.findElement(By.id("field-contactFirstName")).click();
        driver.findElement(By.id("field-contactFirstName")).sendKeys("Dyeniffer");
        driver.findElement(By.id("field-phone")).click();
        driver.findElement(By.id("field-phone")).sendKeys("51 9999-9999");
        driver.findElement(By.id("field-addressLine1")).click();
        driver.findElement(By.id("field-addressLine1")).sendKeys("Av Assis Brasil, 3970");
        driver.findElement(By.id("field-addressLine2")).click();
        driver.findElement(By.id("field-addressLine2")).sendKeys("Torre D");
        driver.findElement(By.id("field-city")).click();
        driver.findElement(By.id("field-city")).sendKeys("Porto Alegre");
        driver.findElement(By.id("field-state")).click();
        driver.findElement(By.id("field-state")).sendKeys("RS");
        driver.findElement(By.id("field-postalCode")).click();
        driver.findElement(By.id("field-postalCode")).sendKeys("91000-000");
        driver.findElement(By.id("field-country")).click();
        driver.findElement(By.id("field-country")).sendKeys("Brasil");
        driver.findElement(By.linkText("Select from Employeer")).click();
        driver.findElement(
                By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Firrelli'])[4]/following::li[1]"))
                .click();
        driver.findElement(By.id("field-creditLimit")).click();
        driver.findElement(By.id("field-creditLimit")).sendKeys("200");
        driver.findElement(By.id("form-button-save")).click();
        driver.findElement(By.linkText("Go back to list")).click();
        driver.findElement(
                By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Print'])[1]/following::a[1]")).click();
        driver.findElement(By.name("search")).click();
        driver.findElement(By.name("search")).sendKeys("Teste Sicredi");
        driver.findElement(
                By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='CreditLimit'])[1]/following::input[1]"))
                .click();
        driver.findElement(
                By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='CreditLimit'])[1]/following::span[1]"))
                .click();
        driver.findElement(
                By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[2]/following::button[1]"))
                .click();
        driver.findElement(
                By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Delete'])[5]/following::span[1]"))
                .click();
        driver.close();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}