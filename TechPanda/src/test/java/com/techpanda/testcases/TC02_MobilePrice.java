package com.techpanda.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TC02_MobilePrice extends BaseClass{
	
	@Test
	public void mobilePriceCheck() {
	

	String price = driver.findElement(By.xpath("//span[contains(text(),'$100.00')]")).getText();//span[contains(text(),'$100.00')]
	driver.findElement(By.xpath("//img[@id='product-collection-image-1']")).click();
	String priceDetail= driver.findElement(By.xpath("//span[contains(text(),'$100.00')]")).getText();
	
	if (price.equals(priceDetail))
	{
		System.out.println("Price of the selected mobile matches in first and details page");
	}
	else
	{
		System.out.println("Price of the selected mobile matches in first and details page");
	}
	
	
	}
}
