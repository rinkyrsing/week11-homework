package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/register?returnUrl=%2F";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToRegisterPageSuccessfull() {
        WebElement register = driver.findElement(By.className("ico-register"));
        register.click();
    }

    @Test
    public void radioButton() {
        // getting gender radio button
        WebElement radioButton = driver.findElement(By.id("gender-male"));
        radioButton.click();

    }

    @Test
    public void userShouldRegisterAccountSuccessfull() {

        //Find First name and send value
        WebElement firstName = driver.findElement(By.id("FirstName"));
        firstName.sendKeys("Amy");
        //Finding last name and send value
        WebElement lastName = driver.findElement(By.id("LastName"));
        lastName.sendKeys("Smith");

        // Finding date elements
        WebElement date = driver.findElement(By.name("DateOfBirthDay"));
        date.sendKeys("19");
        //Finding month
        WebElement month = driver.findElement(By.name("DateOfBirthMonth"));
        month.sendKeys("April");
        //Finding year element
        WebElement year = driver.findElement(By.name("DateOfBirthYear"));
        year.sendKeys("2022");

        //Using select class for dropdown
        Select DOB = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
        DOB.selectByVisibleText("3");

        Select month1 = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
        month1.selectByIndex(8);

        Select year1 = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
        year1.selectByVisibleText("2022");


        // Finding Email
        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("amysmith1@gmail.com");
        // password
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("amy123");
        //Confirm password
        WebElement confPassword = driver.findElement(By.id("ConfirmPassword"));
        confPassword.sendKeys("amy123");
        //Registration
        WebElement registration = driver.findElement(By.id("register-button"));
        registration.click();

        //Verifying successful registration
        WebElement registrationConfirmElement = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]"));
        String actualText = registrationConfirmElement.getText();

        String expectedText = "Your registration completed";
        //Validating actual and expected text
        Assert.assertEquals("Not found 'Your registration completed' text", expectedText, actualText);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}







