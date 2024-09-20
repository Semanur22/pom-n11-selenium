package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import java.time.Duration;

public class amazonTest {
    WebDriver driver;
    @Before
    public void before() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @Test
    public void test() throws InterruptedException {


        // Initialize WebDriver


        driver.get("https://www.amazon.com.tr/");

        driver.manage().window().maximize();
        WebElement homePage = driver.findElement(new By.ById("desktop-banner"));


        Assert.assertTrue(homePage.isDisplayed());

            WebElement cookieButton = driver.findElement(new By.ByCssSelector(".a-button-input"));
            cookieButton.click();

            WebElement loginLink = driver.findElement(new By.ById("nav-link-accountList"));
            loginLink.click();

            String email = "semanur.aydn2222@gmail.com";
            String password = "Sema.123";

            WebElement labelEmail = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/div[2]/div[2]/div[1]/form/div/div/div/div[1]/input[1]"));
            labelEmail.click();
            labelEmail.sendKeys(email);

            WebElement continueButton = driver.findElement(new By.ById("continue"));
            continueButton.click();

            WebElement labelPassword = driver.findElement(new By.ById("ap_password"));
            labelPassword.click();
            labelPassword.sendKeys(password);

            WebElement loginButton = driver.findElement(new By.ById("signInSubmit"));
            loginButton.click();

            WebElement selectButton = driver.findElement(new By.ById("searchDropdownBox"));
            selectButton.click();

            WebElement optionComputer = driver.findElement(new By.ByXPath("//option[text()=\"Bilgisayarlar\"]"));
            optionComputer.click();



            Assert.assertTrue(optionComputer.isDisplayed());
            WebElement searchText = driver.findElement(new By.ById("twotabsearchtextbox"));
            searchText.click();
            searchText.sendKeys("msi");

            WebElement searchButton = driver.findElement(new By.ById("nav-search-submit-button"));
            searchButton.click();

            WebElement result = driver.findElement(new By.ByXPath("//h2[text()=\"Sonuçlar\"]"));



            Assert.assertTrue(result.isDisplayed());
            WebElement pageTwo = driver.findElement(new By.ByXPath("//a[@aria-label=\"2 sayfasına git\"]"));
            JavascriptExecutor js = (JavascriptExecutor) driver;

            js.executeScript("arguments[0].scrollIntoView(true);", pageTwo);

            pageTwo.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement isPageTwo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@aria-label=\"Geçerli sayfa, sayfa 2\"]")));

            js.executeScript("arguments[0].scrollIntoView(true);", isPageTwo);

            Assert.assertTrue(isPageTwo.isDisplayed());

            WebElement selectProduct = driver.findElement(By.xpath("//img[@data-image-index=\"26\"]"));
            selectProduct.click();

            WebElement addList = driver.findElement(By.id("add-to-wishlist-button-submit"));
            js.executeScript("arguments[0].scrollIntoView(true);", addList);
            addList.click();
            WebElement createList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("list-name")));

            createList.click();
            createList.clear();
            createList.sendKeys("Favori Listem");

            WebElement createListButton = driver.findElement(By.xpath("//span[@data-action=\"create-list-submit\"]"));
            createListButton.click();
            WebElement correctAdd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),\"Favori Listem listesine eklendi\")]")));

            Assert.assertTrue(correctAdd.isDisplayed());

            WebElement closeButton = driver.findElement(By.xpath("//i[@class=\"a-icon a-icon-close\"]"));
            closeButton.click();

            Actions actions = new Actions(driver);

            WebElement hoverAccount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList")));

            js.executeScript("arguments[0].scrollIntoView(true);", hoverAccount);
            actions.moveToElement(hoverAccount).perform();
            WebElement selectList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=\"Favori Listem\"]")));

            selectList.click();

            WebElement correctList = driver.findElement(By.id("profile-list-name"));
            Assert.assertTrue(correctList.isDisplayed());

            WebElement deleteButton = driver.findElement(By.xpath("//input[@name=\"submit.deleteItem\"]"));
            deleteButton.click();
            WebElement isDeleted = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),\"Silindi\")]")));


            Assert.assertTrue(isDeleted.isDisplayed());

            WebElement moreLink= driver.findElement(By.xpath("//div[text()=\"Daha fazlası\"]"));
            moreLink.click();

            WebElement editList=driver.findElement(By.id("editYourList"));
            editList.click();

            WebElement saveChanges=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("list-settings-save-announce")));
            WebElement deleteList=driver.findElement(By.xpath("//*[@id=\"list-settings-container\"]/span/span/span/input"));
            js.executeScript("arguments[0].scrollIntoView(true);", deleteList);

            deleteList.click();

            WebElement deleteemin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //span[@id=\"list-delete-confirm\"]")));
            deleteemin.click();

            driver.get("https://www.amazon.com.tr/ref=nav_logo");

            WebElement hoverAccount1 =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id=\"nav-link-accountList\"]")));
            js.executeScript("arguments[0].scrollIntoView(true);", hoverAccount1);
            actions.moveToElement(hoverAccount1).perform();

            WebElement logoutButton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()=\"Çıkış Yap\"]")));
            logoutButton.click();


            WebElement labelEmail1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
            Assert.assertTrue(labelEmail1.isDisplayed());


    }
}
