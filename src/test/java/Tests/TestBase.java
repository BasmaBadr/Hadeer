package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;

    @BeforeSuite
    public void startDriver(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.navigate().to("https://webstdy-011.shoppn.io/admin/login");
        driver.navigate().to("https://shoppn.io/public/en/affiliate/login");

    }
    @AfterSuite
    public void closeDriver(){
        driver.quit();
    }
}
