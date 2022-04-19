package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest  extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setup(){

        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){

       // Forgot your password link
        WebElement forgotPassword = driver.findElement(By.linkText("Forgot your password?"));
        forgotPassword.click();

        //verifying forgot password
        String expectedText = "Forgot Your Password?";
        WebElement actualForgotText = driver.findElement(By.tagName("h1"));

        String actualText = actualForgotText.getText();
        Assert.assertEquals("'Forgot your password?'text not found", expectedText, actualText);

    }
    @After
    public void tearDowm(){
        closeBrowser();
    }

}
