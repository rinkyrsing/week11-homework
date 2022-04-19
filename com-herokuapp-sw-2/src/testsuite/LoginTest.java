package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp(){
    openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
    //Find log in link and click on login link
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");

        //Find log in link and click on login link
        WebElement passWord = driver.findElement(By.name("password"));
        passWord.sendKeys("SuperSecretPassword!");

        //Login field link
        WebElement login = driver.findElement(By.cssSelector("i.fa.fa-2x.fa-sign-in"));
        login.click();

        //Find secure area text on website

        String expectedText = "Secure Area";

        WebElement actualText = driver.findElement(By.tagName("h2"));
        String actual = actualText.getText();

        Assert.assertEquals("'Secure Area' text not found ",expectedText, actual);
    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        //Find log in link and click on login link
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith1");

        //Find log in link and click on login link
        WebElement passWord = driver.findElement(By.name("password"));
        passWord.sendKeys("SuperSecretPassword!");

        //Login field link
        WebElement login = driver.findElement(By.cssSelector("i.fa.fa-2x.fa-sign-in"));
        login.click();

        //Finding 'Your username is invalid!' error massage
        String expectedText = "Your username is invalid!";

        WebElement actualTextElement = driver.findElement(By.id("flash"));
        String actualText = actualTextElement.getText();
        String actual = actualText.substring(0,25);

        Assert.assertEquals("'Your username is invalid!' error message not found" ,expectedText, actual);


    }
    @Test
    public void verifyThePasswordErrorMessage(){
        //Find log in link and click on login link
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");

        //Find log in link and click on login link
        WebElement passWord = driver.findElement(By.name("password"));
        passWord.sendKeys("SuperSecretPassword");

        //Login field link
        WebElement login = driver.findElement(By.cssSelector("i.fa.fa-2x.fa-sign-in"));
        login.click();

        //Finding 'Your password is invalid!' error massage
        String expectedText = "Your password is invalid!";

        WebElement actualTextElement = driver.findElement(By.id("flash"));
        String actualText = actualTextElement.getText();
        String actual = actualText.substring(0,25);

        Assert.assertEquals("'Your password is invalid!' error message not found" ,expectedText, actual);

    }
    @After
    public void tearDown(){
        closerBrowser();
    }



}
