package com.techpanda.testcases;

import java.time.Duration;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC01_Home {



		WebDriver driver;

		@BeforeClass
		public void setUp() throws InterruptedException {

			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\driver\\geckodriver.exe");
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

		@Test
		public void checkHomeTitle() {

			isTitleMatch();

			try {
				Assert.assertEquals(driver.getTitle(), "Home page");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void isTitleMatch() {

			if (driver.getTitle().equals("Home page")) {
				System.out.println("Title is as expected!");
			} else {
				System.out.println("Title is not as expected!!. Expected tilte is " + driver.getTitle());
			}
		}

		@Test
		public void checkMobileLink() {

			// driver.findElement(By.linkText("MOBILe")).getText();
			driver.findElement(By.xpath("//a[normalize-space()='Mobile']")).click();
			System.out.println("Title of Mobile link page is " + driver.getTitle());
			isTitleMatch();
			Assert.assertEquals(driver.getTitle(), "Mobile");
		}

		@Test
		public void checkMobileDropdown() throws InterruptedException {

			// Handling Drop down l13
			Select sortByDrp = new Select(
					driver.findElement
							(By.xpath("//html[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")));
			
			// "(//select[@title='Sort By'])[1]")));
			// "//select[@title='Sort By'][contains(text(),'Position')]")));
			
			
			//sortByDrp.selectByIndex(2);
			sortByDrp.selectByVisibleText("Name");
			
//System.out.println(sortByDrp.getFirstSelectedOption().getText());

			
		}

		@AfterClass
		public void tearDown() {

			driver.close();
		}

	

	
	
}
