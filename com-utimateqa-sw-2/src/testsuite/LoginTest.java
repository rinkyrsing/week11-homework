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

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //Sign In link
        WebElement signIn = driver.findElement(By.xpath("//a[contains(text(),'Sign In')]"));
        signIn.click();

        // Verify the text ‘Welcome Back!’
        String expectedText = "Welcome Back!";

        //Geting welcome element
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[@class='page__heading']"));
        String actualText = actualTextElement.getText();

        Assert.assertEquals("'Welcome Back!' massage not found",expectedText, actualText);

    }
    @Test
    public void verifyTheErrorMessage(){
        //Sign In link
        WebElement signIn = driver.findElement(By.xpath("/html/body/header/div/div/section[1]/ul/li/a"));
        signIn.click();
        // invalid username
        WebElement userName = driver.findElement(By.id("user[email]"));
        userName.sendKeys("amysmith@gmail.com");

        // invalid pass ward
        WebElement userPassword = driver.findElement(By.name("user[password]"));
        userPassword.sendKeys("amy123");

        //Click on Login button
        WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
        login.click();

        //Verify the error message
        WebElement actualElement = driver.findElement(By.id("notice"));
        String expectedMessage = "Invalid email or password.";

        String actualMessageError = actualElement.getText();
        Assert.assertEquals("Error message not found", expectedMessage, actualMessageError);
    }
    @After
    public void tearDowm(){
        closeBrowser();
    }

}
