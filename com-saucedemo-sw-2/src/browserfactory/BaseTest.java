package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public void openBrowser(String baseUrl){
        //launching Url
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();

        //Launch URL
        driver.get(baseUrl);

        //launch title
        String title = driver.getTitle();
        System.out.println("Title: " + title );

        //Maximize
        driver.manage().window().maximize();

        //Implicitly Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    public void closeBrowser() {
        driver.quit();

    }



}
