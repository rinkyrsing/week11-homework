package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        //find computer tab and click on computer tab
        driver.findElement(By.linkText("Computers")).click();
        String expectedResult = "Computers";
        WebElement actualResultElement = driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a"));
        String actualResult = actualResultElement.getText();
        Assert.assertEquals("invalid element", expectedResult, actualResult);
    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {

        driver.findElement(By.linkText("Electronics")).click();
        String expectedResult = "Electronics";
        WebElement actualResultElement = driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/a"));
        String actualResult = actualResultElement.getText();
        Assert.assertEquals("Error occured", expectedResult, actualResult);

    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {

        WebElement computerTab = driver.findElement(By.linkText("Apparel"));
        computerTab.click();
        String expectedResult = "Apparel";
        WebElement actualResultElement = driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[3]/a"));
        String actualResult = actualResultElement.getText();
        Assert.assertEquals("Error occured", expectedResult, actualResult);
    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {

        driver.findElement(By.linkText("Digital downloads")).click();
        String expectedResult = "Digital downloads";
        WebElement actualResultElement = driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[4]/a"));
        String actualResult = actualResultElement.getText();
        Assert.assertEquals("Error occured", expectedResult, actualResult);

    }

    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {

        driver.findElement(By.linkText("Books")).click();
        String expectedResult = "Books";
        WebElement actualResultElement = driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[5]/a"));
        String actualResult = actualResultElement.getText();
        Assert.assertEquals("Error occured", expectedResult, actualResult);
    }

    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {

        driver.findElement(By.linkText("Jewelry")).click();
        String expectedResult = "Jewelry";
        WebElement actualResultElement = driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[6]/a"));
        String actualResult = actualResultElement.getText();
        Assert.assertEquals("Error occured", expectedResult, actualResult);

    }

    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() {

        WebElement giftCards = driver.findElement(By.linkText("Gift Cards"));
        giftCards.click();
        String expectedResult = "Gift Cards";
        WebElement actualResultElement = driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[7]/a"));
        String actualResult = actualResultElement.getText();
        Assert.assertEquals("Error occured", expectedResult, actualResult);

    }

    @After
    public void close(){
        closeBrowser();
    }
}
