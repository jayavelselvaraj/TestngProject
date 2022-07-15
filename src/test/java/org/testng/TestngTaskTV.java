package org.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestngTaskTV {
	  static long start;
@BeforeClass(groups="default")
    public void browserlaunch() {
  System.out.println("launch");
}
@AfterClass (groups="default")
public void quit() {
System.out.println("browserquit");
}
	
	@BeforeMethod(groups="default")
 public  void Startingtime() {
	System.out.println("before");
start = System.currentTimeMillis();
}
	@AfterMethod(groups="default")
public  void Endtime() {
	
long end = System.currentTimeMillis();

 System.out.println("After time taken  is:"+(end -start));
}
	
	@Test(priority=1,groups="smoke")
	public void login() {
		
		System.out.println("login");
	}
	@Test(priority=2)
	public void search() {
		
		System.out.println("search");
	}
	@Test(priority=3,groups="smoke")
	public void tv() {
		
		System.out.println("tv");
	}
	@Test(priority=4,enabled=false)
	public void windows() {
		
		System.out.println("windows");
	}
	@Test(priority=5)
	public void screenshot() {
		
		System.out.println("screenshots");
	}
}


