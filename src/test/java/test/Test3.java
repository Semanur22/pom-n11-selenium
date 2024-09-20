package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3 {

    public static void main(String[] args) {
        // Set ChromeDriver property
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the webpage
        driver.get("https://demoqa.com/checkbox");
        driver.manage().window().maximize();
        // Find the checkbox element
        WebElement homeCheckbox = driver.findElement(By.cssSelector(".rct-icon-uncheck"));

        // Click the checkbox
        homeCheckbox.click();

        // Find the checkbox element again to check its updated state
        homeCheckbox = driver.findElement(By.cssSelector(".rct-icon-check"));

        // Get the class attribute of the checkbox
        String homeCheckboxClass = homeCheckbox.getAttribute("class");

        // Check if the checkbox is checked
        if (homeCheckboxClass.equals("rct-icon rct-icon-check")) {
            System.out.println("Checkbox is checked!");
        } else {
            System.out.println("Checkbox is unchecked!");
        }

        // Close the WebDriver instance
        driver.quit();
    }
}
