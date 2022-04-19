package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Find  user name  link and click on login link
        WebElement userName = driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");

        //Find  user password  link and click on login link
        WebElement userPassword = driver.findElement(By.id("txtPassword"));
        userPassword.sendKeys("admin123");

        //Login button link
        WebElement login = driver.findElement(By.name("Submit"));
        login.click();

        //verify welcome on webpage
        WebElement welcomeMessage = driver.findElement(By.id("welcome"));
        String actualResult = welcomeMessage.getText();
        //verifying message display or not
        if(welcomeMessage.isDisplayed()){
            System.out.println("'Welcome' Message is Displayed" );
        }else{
            System.out.println("'Welcome' Message is not Displayed");
        }
        String requiredActualText = actualResult.substring(0,7);
        System.out.println(requiredActualText);

        String expectedText = "Welcome";
        Assert.assertEquals("'welcome text not found",expectedText, requiredActualText);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }




}
