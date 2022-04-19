package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public void openBrowser(String  baseUrl) {
        //Launching browser
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();

       //Launch URL
        driver.get(baseUrl);

        //Get Title
        String title = driver.getTitle();
        System.out.println("Title: " + title);

        //Maximize window
        driver.manage().window().maximize();

        //Implicitly time to deliver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

        public void closerBrowser() {
            driver.quit();

        }
}

