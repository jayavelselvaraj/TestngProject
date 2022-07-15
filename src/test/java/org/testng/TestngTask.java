package org.testng;


import java.awt.RenderingHints.Key;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

      public class TestngTask {
    	  @DataProvider(name = "mobile")
    	  public  Object[][] searchmobile() {
    		return  new Object[][] {{"redmi"}};
    	  }
    	  static long start;
    	  static WebDriver driver;
    	  static String text;
    	  
  @Parameters("URL")
    	  @BeforeClass
      public void browserlaunch(@Optional("https://www.flipkart.com/")String URL) {
	  WebDriverManager.edgedriver().setup();
	  driver = new EdgeDriver();
	  driver.get(URL);
	  driver.manage().window().maximize();
	 //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  
	  
	  
    System.out.println("launch");
  }
  @AfterClass
  public void quit() {
	  //driver.quit();
  System.out.println("browserquit");
}
	
	@BeforeMethod
   public  void Startingtime() {
	System.out.println("before");
start = System.currentTimeMillis();
}
	@AfterMethod
  public  void Endtime() {
	
  long end = System.currentTimeMillis();

   System.out.println("After time taken  is:"+(end -start));
}
	
	@Test(priority=1)
	public void login() throws Throwable {
		Thread.sleep(2000);
		WebElement X=driver.findElement(By.xpath("//button[text()='✕']"));
		X.click();
		System.out.println("login");
	}
	@Test(priority=2,dataProvider= "mobile")
	public void search(String name) throws Throwable {
		Thread.sleep(2000);
		 WebElement user = driver.findElement(By.xpath("//input[@type ='text']"));
		   user.sendKeys(name,Keys.ENTER);
		System.out.println("search");
	}
	@Test(priority=3)
	public void mobiles() throws Throwable {
		  Thread.sleep(2000);
		   WebElement element1 = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
		   element1.click();
		    text = element1.getText();
		   System.out.println(text);
		System.out.println("mobiles");
	}
	@Test(priority=4,enabled=false)
	public void windows() throws Throwable {

		   Thread.sleep(2000);
		   WebElement element1 = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
		   element1.click();
		   
		   Thread.sleep(2000);
		   WebElement element2 = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[2]"));
		   element2.click();
		   
		   Thread.sleep(2000);
		   WebElement element3 = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[3]"));
		   element3.click();
		   
		System.out.println("windows");
	}
	@Test(priority=5,invocationCount=3)
	public void screenshot() {
				System.out.println("screenshots");
				//hardassert
			//	Assert.assertEquals("jayavel", "karthick");
//softassert
				SoftAssert s = new SoftAssert();
				s.assertEquals("jayavel", "karthick");
	}
}
