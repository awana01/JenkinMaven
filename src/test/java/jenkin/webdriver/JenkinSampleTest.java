package jenkin.webdriver;

import java.awt.AWTException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JenkinSampleTest {

	public WebDriver driver;

	@BeforeClass()
	public void beforeTest() {

	 //System.setProperty("webdriver.chrome.driver","E:\\Selenium-3.6\\chrome-87\\chromedriver.exe");
	 
	 WebDriverManager.chromedriver().setup();
     ChromeOptions option = new ChromeOptions();
     
	 driver = new ChromeDriver(option);
	 driver.get("https://www.google.com/");
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


	}

  @Test()
  public void Test01() throws InterruptedException {

	 WebElement search_btn = driver.findElement(By.name("btnK"));
	 JavascriptExecutor js = (JavascriptExecutor)driver;

	 String search_data = "access jenkin on remote machine";

	 driver.findElement(By.name("q")).sendKeys(search_data);
     Thread.sleep(2000);
     driver.findElement(By.name("q")).sendKeys(Keys.ESCAPE);
     Thread.sleep(1000);

     js.executeScript("arguments[0].click();", search_btn);
     Thread.sleep(5000);

     Assert.assertEquals(search_data+" - Google Search",driver.getTitle());
     System.out.println("Google Test");



  }


  @AfterTest()
  public void afterTest() throws AWTException {
//	  Point p = driver.manage().window().getPosition();
//	  Dimension d = driver.manage().window().getSize();
//	  driver.manage().window().setPosition(new Point((d.getHeight()-p.getX()), (d.getWidth()-p.getY())));

	  //driver.manage().window().setPosition(new Point(-2000, 0));
	  //driver.manage().window().setPosition(new Point(0, -2000));

	  //
	  Dimension n = new Dimension(360, 592);
	  driver.manage().window().setSize(n);
	  driver.close();
//	  Robot robot = new Robot();
//	  robot.keyPress(KeyEvent.VK_ALT);
//	  robot.keyPress(KeyEvent.VK_SPACE);
//	  robot.keyPress(KeyEvent.VK_N);
//	  robot.keyRelease(KeyEvent.VK_ALT);
//	  robot.keyRelease(KeyEvent.VK_SPACE);
//	  robot.keyRelease(KeyEvent.VK_N);


//	  driver.close();
  }

}
