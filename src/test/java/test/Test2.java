package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();

        driver.get("https://profile.w3schools.com/signup");

        WebElement email=driver.findElement(new By.ByCssSelector(".SignUpForm_signup_input__6r1Lr[placeholder='email']"));
        email.click();
        email.sendKeys("sema@gmail.com");

        WebElement password=driver.findElement(new By.ByCssSelector(".SignUpForm_signup_input__6r1Lr[placeholder='password']"));
        password.click();
        password.sendKeys("Sema.124");

        WebElement firstName=driver.findElement(new By.ByCssSelector(".SignUpForm_signup_input__6r1Lr[placeholder='first name']"));
        firstName.click();
        firstName.sendKeys("Sema");

        WebElement lastName=driver.findElement(new By.ByCssSelector(".SignUpForm_signup_input__6r1Lr[placeholder='last name']"));
        lastName.click();
        lastName.sendKeys("Aydın");

        WebElement signUp=driver.findElement(new By.ByCssSelector("button.CustomButton_primary__ZDr5g"));
        signUp.click();


        WebElement text=driver.findElement(new By.ByCssSelector(".LoginPanel_or_text__fRkMM"));
        String text1=text.getText();
        System.out.println(text1);

        System.out.println(text1.equals("OR"));
    }

}
