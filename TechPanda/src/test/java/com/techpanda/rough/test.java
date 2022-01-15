package com.techpanda.rough;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class test {

	public static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // deprecated
		String url = "http://live.techpanda.org/";
		driver.get(url);
		driver.manage().window().maximize();
		
		Assert.assertEquals(driver.getTitle(), "Home page");
		System.out.println("Title of Home page is " + driver.getTitle());
		driver.findElement(By.xpath("//a[normalize-space()='Mobile']")).click();
		System.out.println("Title of Mobile link page is " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Mobile");
		
		Select sortByDrp = new Select(
		  driver.findElement
			(By.xpath("//html[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")));
		//             //html[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select
		sortByDrp.selectByVisibleText("Name");  //selectByVisibleText("Name"
		// Thread.sleep(3000);
		
		//System.out.println(sortByDrp.getFirstSelectedOption().getText());
		System.out.println("done");
		driver.quit();
		
	}

}
