package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BasePage {
    public WebDriver driver;
    //public HomePage homePage;

    public static String loginurl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";


    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //homePage = new HomePage(driver);
    }

    @AfterTest
    public void quitBrowser(){
        //driver.quit();
    }
}
