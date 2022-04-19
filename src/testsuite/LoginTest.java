package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    //Declaring URL

    String baseURL = "https://courses.ultimateqa.com/";

    //Setting up the browser before each individual test
    @Before
    public void setUp(){
        openBrowser(baseURL);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){

        //Click on the ‘Sign In’ link
        WebElement clickSignInBtn = driver.findElement(By.partialLinkText("Sign In"));
        clickSignInBtn.click();

        //Verify the text ‘Welcome Back!’
        //Declaring the text from the requirements
        String expectedMessage = "Welcome Back!";

        //Verifying the text from the requirements and getting the text
        WebElement actualMessageElement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome Back!')]"));
        String actualMessage = actualMessageElement.getText();
        System.out.println(actualMessage);

        //Validating actual vs expected message
        Assert.assertEquals("The text does not match the expected text", actualMessage, expectedMessage);
    }

    @Test
    public void verifyTheErrorMessage(){

        //Click on the ‘Sign In’ link
        WebElement clickSignInBtn = driver.findElement(By.partialLinkText("Sign In"));
        clickSignInBtn.click();

        //Enter invalid username
        WebElement enterUsername = driver.findElement(By.id("user[email]"));
        enterUsername.sendKeys("Primer123");

        //Enter invalid password
        WebElement enterPassword = driver.findElement(By.id("user[password]"));
        enterPassword.sendKeys("Clock123");

        //Click on Login button
        WebElement clickSignInFunction = driver.findElement(By.xpath("//input[@class='button button-primary g-recaptcha']"));
        clickSignInFunction.click();

        //Verify the error message ‘Invalid email or password.’
        //Declaring the text from the requirements
        String expectedMessage = "Invalid email or password.";

        //Verifying the text from the requirements and getting the text
        WebElement actualMessageElement = driver.findElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        String actualMessage = actualMessageElement.getText();
        System.out.println(actualMessage);

        //Validating actual vs expected message
        Assert.assertEquals("The text does not match the expected text", actualMessage, expectedMessage);
    }

    //Closing the browser after each individual test
    @After
    public void tearDown(){
        closeBrowser();
    }
}
