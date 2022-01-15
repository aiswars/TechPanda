package com.techpanda.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

 
public class BaseClass {

	WebDriver driver; 
	 

	@BeforeClass
	public void setUp() throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
		// System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());

		driver = new FirefoxDriver();
		// Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // deprecated
		String url = "http://live.techpanda.org/";
		driver.get(url);
		driver.manage().window().maximize();

	}

	@AfterClass
	public void tearDown() {

		driver.close();
	}

	
}
