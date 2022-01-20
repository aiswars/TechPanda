package com.techpanda.rough;

import static org.testng.AssertJUnit.assertEquals;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class test {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // deprecated
		String url = "http://live.techpanda.org/";
		driver.get(url);
		driver.manage().window().maximize();

		// Day1
		Assert.assertEquals(driver.getTitle(), "Home page");
		System.out.println("Title of Home page is " + driver.getTitle());
		driver.findElement(By.xpath("//a[normalize-space()='Mobile']")).click();
		System.out.println("Title of Mobile link page is " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Mobile");

		Select sortByDrp = new Select(driver.findElement(By
				.xpath("//html[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")));
		// //html[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select
		sortByDrp.selectByVisibleText("Name"); // selectByVisibleText("Name"
		// Thread.sleep(3000);

		// System.out.println(sortByDrp.getFirstSelectedOption().getText());
		System.out.println("done");

		// ********************************************************************************************
		// Day2
		// Product price in list and details page should be equal
		String price = driver.findElement(By.xpath("//span[contains(text(),'$100.00')]")).getText();// span[contains(text(),'$100.00')]
		System.out.println(price);
		driver.findElement(By.xpath("//img[@id='product-collection-image-1']")).click();

		String priceDetail = driver.findElement(By.xpath("//span[contains(text(),'$100.00')]")).getText();
		System.out.println(priceDetail);

		// string1.equals(string2))
		if (price.equals(priceDetail)) {
			System.out.println("Price of the selected mobile matches in first and details page");
			System.out.println(price);
			System.out.println(priceDetail);
		} else {
			System.out.println("Price of the selected mobile NOT matches in first and details page");
			System.out.println(price);
			System.out.println(priceDetail);
		}

		// Product price in list and details page should be equal ($100)
		try {
			assertEquals(price, priceDetail);
			// assertEquals(XPeriaPrice, detailPrice);
		} catch (Exception e) {
			e.printStackTrace();
		}
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// Day3
		// adding xperia to the Cart
		driver.findElement(By.xpath("//button[@title='Add to Cart']")).click(); // clicking add to cart button
		// driver.findElement(By.xpath("//span[contains(.,'Sony Xperia was added to your// shopping cart.')]")).getText();
		// checking the confirmation messgae
		Assert.assertEquals("Sony Xperia was added to your shopping cart.", driver
				.findElement(By.xpath("//span[contains(.,'Sony Xperia was added to your shopping cart.')]")).getText());
		//update the quantity
		driver.findElement(By.xpath("//input[@title='Qty']")).clear();// clear the quantity
		driver.findElement(By.xpath("//input[@title='Qty']")).sendKeys("1000"); // editing quatity textbox to 1000
		driver.findElement(By.xpath("//button[@class='button btn-update']/child::*")).click();// clicking on uudate// button - to update the quantity
		System.out.println(driver.findElement(By.cssSelector("p.item-msg.error")).getText()); // css -tag.class -/ //errormessage
		Assert.assertEquals("* The maximum quantity allowed for purchase is 500.",
				driver.findElement(By.cssSelector("p.item-msg.error")).getText()); // css -tag.class - //errormessage
		Thread.sleep(3000);
		//click on empty cart
		driver.findElement(By.xpath("//span[contains(text(),'Empty Cart')]")).click(); // clicking empety cart button
		System.out.println(driver.findElement(By.xpath("//h1[contains(.,'Shopping Cart is Empty')]")).getText());
//////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Day4
		 
	    // 1. Click on Mobile menu
	    driver.findElement(By.linkText("MOBILE")).click();
	    Thread.sleep(1000);
	    
	    // 2. In mobile products list , click on ‘Add To Compare’ for 2 mobiles (Iphone & Sony Xperia)
	    
	    //note: store the title of the 2 mobiles for comparison for verification later when popup page comes up
	    
	    String mobile1Name = driver.findElement(By.xpath("//a[@title='IPhone'][normalize-space()='IPhone']")).getText();//name of first phone to compare
	    // driver.findElement(By.linkText("Add to Compare")).click(); //clicking     Add to Compare
        driver.findElement(By.xpath("(//a[contains(text(),'Add to Compare')])[1]")).click(); //clicking     Add to Compare 1st mobile
	    System.out.println("Mobile1 to compare :  "  +mobile1Name);
	    Thread.sleep(1000);
	    
        String mobile2Name = driver.findElement(By.xpath("//a[@title='Samsung Galaxy'][normalize-space()='Samsung Galaxy']")).getText(); //name of second mobile to comapre
	    driver.findElement(By.xpath("(//a[contains(text(),'Add to Compare')])[2]")).click(); //clicking     Add to Compare - 2nd mobile
	    //didnt check whether the products are added to compare products page
	    System.out.println("Mobile1 to compare :  "  +mobile2Name);
	    Thread.sleep(1000);
	    
	    //3. clicking compare button to compare the products
	    driver.findElement(By.xpath("//button[@title='Compare']")).click();
	    Thread.sleep(1000);
	    
	    //compare products opened in new window  -  get the windowhandles
		    //4. switching to new window
	    for (String handle : driver.getWindowHandles()) { //2 windows
	    	System.out.println(handle); // handle values are printed - iterate through each windowhandles
	    	driver.switchTo().window(handle); //2nd loop- the last loop on second window
	   	    	}
	    
	  //verifying the page opened and checking added products are available in the compare products page
	    //5.heading of new opened window - compare products page
	   // assertEquals(driver.findElement(By.xpath("//h1[normalize-space()='Compare Products']")).getText(), "COMPARE PRODUCTS");
	    
	    try {	    	
	    	//assertEquals(strHead, compHead);
	    	assertEquals(driver.findElement(By.xpath("//h1[normalize-space()='Compare Products']")).getText(), "COMPARE PRODUCTS");
		    } 
	    catch (Exception e) {
		    	e.printStackTrace();	    	
		    }	
	    
	    //6. name of mobiles in the new window - compare products page
	 System.out.println(driver.findElement(By.xpath("//a[normalize-space()='IPhone']")).getText());  // IPHONE
	 System.out.println(driver.findElement(By.xpath("//a[normalize-space()='Samsung Galaxy']")).getText()); //SAMSUNG GALAXY
	 //verifying the mobile names added - 
	  try {	    	 //IPHONE
	    	assertEquals(mobile1Name, driver.findElement(By.xpath("//a[normalize-space()='IPhone']")).getText()); //IPHONE
		    } catch (Exception e) {
		    	e.printStackTrace();	    	
		    }	
	    // to check the 2 mobiles selected are the two in the popup - this is to check Sony X
	    try {	   //SAMSUNG GALAXY	
	    	assertEquals(mobile2Name, driver.findElement(By.xpath("//a[normalize-space()='Samsung Galaxy']")).getText());//SAMSUNG GALAXY
		    } catch (Exception e) {
		    	e.printStackTrace();	    	
		    }	
	    	    
	    // 7.Clicking on  Close Button on the COmpare Products page - popup window ??
	    driver.findElement(By.xpath("//button[@title='Close Window']")).click();
	
	    
	    // 8. switching back to window
	    for (String handle : driver.getWindowHandles()) {
	    	System.out.println(handle); // handle values are printed - iterate through each windowhandles
	    driver.switchTo().window(handle); //compare products window is closed -now only 1 window ??- so going to last window - back to home window 
	    }	   
	    
	    
	 

		
		driver.quit();

	}

}
