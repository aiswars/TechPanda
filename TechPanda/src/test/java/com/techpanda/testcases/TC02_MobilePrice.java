package com.techpanda.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.Assert;


public class TC02_MobilePrice extends BaseClass{
	
	@Test
	public void mobilePriceCheck() {
	
//price of xperia mobile
	String price = driver.findElement(By.xpath("//span[contains(text(),'$100.00')]")).getText();//span[contains(text(),'$100.00')]
	driver.findElement(By.xpath("//img[@id='product-collection-image-1']")).click();//clicking peria mobile
	String priceDetail= driver.findElement(By.xpath("//span[contains(text(),'$100.00')]")).getText();//price in details page of xperia mobile
	
	if (price.equals(priceDetail)) //comparing the price - price stored as String
	{
		System.out.println("Price of the selected mobile matches in first and details page");
	}
	else
	{
		System.out.println("Price of the selected mobile matches in first and details page");
	}
	
	
	}
	
	@Test
	public void quantityUpdateCheck()
	{
		driver.findElement(By.xpath("//button[@title='Add to Cart']")).click(); //clicking add to cart button
	//	driver.findElement(By.xpath("//span[contains(.,'Sony Xperia was added to your shopping cart.')]")).getText();
		//checking the confirmation messgae 
		Assert.assertEquals("Sony Xperia was added to your shopping cart.", driver.findElement(By.xpath("//span[contains(.,'Sony Xperia was added to your shopping cart.')]")).getText());
	}
}
