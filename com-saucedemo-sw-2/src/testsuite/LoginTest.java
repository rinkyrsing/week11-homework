package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Finding user name
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        //finding password
        WebElement userPassWord = driver.findElement(By.id("password"));
        userPassWord.sendKeys("secret_sauce");

        //login button field
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement actualResultElement = driver.findElement(By.xpath("//span[@class='title']"));
        String expectedResult = "PRODUCTS";

        String actualResult = actualResultElement.getText();
        Assert.assertEquals("'PRODUCT' text not found",expectedResult,actualResult);

    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //Finding user name
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");

        //finding password
        WebElement userPassWord = driver.findElement(By.id("password"));
        userPassWord.sendKeys("secret_sauce");

        //login button field
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        //counting list of 'PRODUCTS '
        int expectedResult = 6;
        List<WebElement> productsList = driver.findElements(By.className("inventory_item_label"));
        int list = productsList.size();
        System.out.println("Number of products displayed on page is: " + list);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }


}
