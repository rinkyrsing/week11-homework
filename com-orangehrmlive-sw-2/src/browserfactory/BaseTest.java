package browserfactory;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

  public void openBrowser(String baseUrl){

      //Launching browser
      System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
      driver = new ChromeDriver();

      //Launching URL
      driver.get(baseUrl);

      //Title
       String title = driver.getTitle();
      System.out.println("Title: "+ title);

      //Maximize window
      driver.manage().window().maximize();

      //We give implicit time to driver
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  }

  public void closeBrowser(){

      driver.quit();

  }

}
