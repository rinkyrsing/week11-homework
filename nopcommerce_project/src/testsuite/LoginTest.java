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

    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Find log in link and click on login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        //This is from requirement
        String expectedMessage = "Welcome, Please Sign In!";

        //Find the welcome text element and get the text
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        String actualMessage = actualMessageElement.getText();

        //Validate actual and expected message
        Assert.assertEquals("Not navigate to login page", expectedMessage, actualMessage);

    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //  click on login link
        WebElement loginButton = driver.findElement(By.linkText("Log in"));
        loginButton.click();

        //Passing valid user name in user field
        WebElement userName = driver.findElement(By.id("Email"));
        userName.sendKeys("amysmith@gmail.com");

        //  Passing password feild
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("amy123");

        //Login button
        WebElement loginlink = driver.findElement(By.partialLinkText("Log in"));
        loginlink.click();

        //find logout button
        WebElement logout = driver.findElement(By.className("ico-logout"));
        if(logout.isDisplayed()){
            System.out.println("Verification completed successfully - 'Log out' is not displayed on the wed pade");
        }else
        {
            System.out.println("Verification completed Unsuccessfully - 'Log out' is not displayed on the wed pade");
        }
    }

    @Test
    public void verifyTheErrorMessage() {
        //Find log in link and click on login link
        WebElement lodinLink = driver.findElement(By.linkText("Log in"));
        lodinLink.click();

        //find email element
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.sendKeys("amysmith12@gmail.com");

        // Find password field element
        WebElement passwordField = driver.findElement(By.name("Password"));
        passwordField.sendKeys("amy123");

        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginButton.click();

        String expectedErrorMessade = "Login was unsuccessful. Please correct the errors and try again.\n"
                + "No customer account found";
        String actualErrorMessage = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();
        Assert.assertEquals("Error message not display", expectedErrorMessade, actualErrorMessage);

    }

    @After
    public void tearDown() {

        closeBrowser();
    }

}
