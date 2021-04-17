import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ObjectRepository {
    public static void main(String[] args) throws IOException {

        // This code is an example of how to use an Object Repository file
        // Will login to Facebook to utilise the key-values in my Object Repository file
        // The locator values in my repository are using the relative path of Xpath

        // I have for simplicity purposes left my chromedriver in my users Downloads folder
        // I am using the standalone version of Selenium. The standalone Selenium jar file was added
        // to the current project via IntelliJ

        System.setProperty("webdriver.chrome.driver","/Users/Jody1/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        Properties obj = new Properties();
        FileInputStream objFile = new FileInputStream(System.getProperty("user.dir")+"/objRepository.properties");
        obj.load(objFile);

        driver.get("https://facebook.com");

        driver.findElement(By.xpath(obj.getProperty("facebook.username.xpath"))).
                sendKeys("cwigney1995@gmail.com");
        driver.findElement(By.xpath(obj.getProperty("facebook.password.xpath"))).
                sendKeys("test");
        driver.findElement(By.xpath(obj.getProperty("facebook.login.xpath"))).click();



    }
}
