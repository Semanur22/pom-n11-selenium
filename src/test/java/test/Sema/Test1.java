package test.Sema;


import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import java.time.Duration;

public class Test1 {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver1");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);

    }

    @Test
    public void test() throws InterruptedException {


        // Initialize WebDriver
        driver.get("http://localhost/karinca/");
        driver.manage().window().maximize();

        String email="beyzkay2a@gmail.com";
        String password="123";

        //Giris yap
        login(email,password);

        //Admin paneline gecis yap
        admin();
    }
    public void login(String email, String password){
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='GİRİŞ YAP']")));
        loginButton.click();
        WebElement labelEmail=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_email_1")));
        WebElement labelPassword=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_password_1")));


        labelEmail.click();
        labelEmail.sendKeys(email);
        labelPassword.click();
        labelPassword.sendKeys(password);

        WebElement buttonLogin=driver.findElement(By.xpath("//button[text()=\"Giriş\"]"));
        buttonLogin.click();
    }

    public void admin(){
        WebElement userDropdown=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".donate-btn-header .dropdown")));
        actions.moveToElement(userDropdown).perform();
        WebElement adminPanel=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"admin\"]")));
        adminPanel.click();

    }


}

