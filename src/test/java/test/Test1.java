package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver=new ChromeDriver();
        //linke gitme
        //driver.get("https://demoqa.com/");

        driver.get("https://demoqa.com/text-box");
        //acilan pencere buyuk boyutta acilir
        driver.manage().window().maximize();

        // Swipe işlemi için JavaScriptExecutor oluştur
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Swipe işlemi için JavaScript kodunu çalıştır
        WebElement element = driver.findElement(By.id("userEmail"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        //userName elemntini bulma
        WebElement nameElement=driver.findElement(By.id("userName"));
        nameElement.click();
        //userName labelina Sema yazildi
        nameElement.sendKeys("Sema");

        WebElement emailElement=driver.findElement(new By.ById("userEmail"));
        emailElement.click();
        emailElement.sendKeys("sema@gmail.com");

        WebElement currentAddressElement=driver.findElement(new By.ById("currentAddress"));
        currentAddressElement.click();
        currentAddressElement.sendKeys("İstanbul");

        WebElement permanentAddress=driver.findElement(new By.ById("permanentAddress"));
        permanentAddress.click();
        permanentAddress.sendKeys("Ankara");

        WebElement submitButton=driver.findElement(new By.ByCssSelector("button.btn"));
        submitButton.click();


        //text okuma
        WebElement nameText=driver.findElement(By.xpath("//div/p[@id='name']"));
        String name=nameText.getText();
        System.out.println(name);


        System.out.println(name.equals("Name:Sema"));

    }

}
