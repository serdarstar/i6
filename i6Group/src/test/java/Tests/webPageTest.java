package Tests;

import Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class webPageTest {

   WebDriver driver;


   @BeforeMethod
    public void setUpMethod(){

       driver = WebDriverFactory.getDriver("chrome");
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
   }

   @AfterMethod
    public void tearDownMethod() throws InterruptedException {

       Thread.sleep(3000);
       driver.quit();
   }

   @Test
    public void test1() throws InterruptedException {

       driver.get("https://i6.io/");

       WebElement about = driver.findElement(By.xpath("(//a[@href='/about'])[3]"));
       about.click();

       WebElement contactUs = driver.findElement(By.xpath("//a[@href='/contact-us']"));
       contactUs.click();

      WebElement cookies = driver.findElement(By.cssSelector("a.fs-cc-banner_button.w-button"));
      Thread.sleep(3000);
      cookies.click();

      WebElement firstName = driver.findElement(By.xpath("//input[@name='First-Name']"));


       Actions actions = new Actions(driver);
       actions.click(firstName).sendKeys("Test")
               .sendKeys(Keys.TAB)
               .sendKeys("Quality")
               .sendKeys(Keys.TAB)
               .sendKeys("Leave Blank")
               .sendKeys(Keys.TAB)
               .sendKeys("aaaa88888")
               .sendKeys(Keys.TAB)
               .sendKeys("Leave Blank")
               .sendKeys(Keys.TAB)
               .sendKeys("Careers")
               .sendKeys(Keys.TAB)
               .sendKeys("Leave Blank")
               .perform();

        WebElement tickingBox = driver.findElement(By.xpath("//input[@id='Subscribe-to-Email']"));


        actions.click(tickingBox).sendKeys(Keys.TAB).click().perform();

        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));

        email.sendKeys("aaaa88888@i6user");


       WebElement submitButton = driver.findElement(By.xpath("//input[@value='Submit Now']"));

       submitButton.click();

       Thread.sleep(3000);

       String expectedMessage = "Thank you! Your submission has been received!";

       String actualMessage = driver.findElement(By.xpath("(//*[text()='Thank you! Your submission has been received!'])[1]")).getText();

       Assert.assertEquals(actualMessage,expectedMessage);














   }
}
