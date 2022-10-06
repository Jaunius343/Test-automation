package com.selenium.mavenproject;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab4_Test {
	
	void run(User user, String fileName) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://demowebshop.tricentis.com/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		driver.findElement(By.xpath("//a[@href = \"/login\"]")).click();
		driver.findElement(By.xpath("//input[@class = \"email\"]")).sendKeys(user.Email);
		driver.findElement(By.xpath("//input[@class = \"password\"]")).sendKeys(user.Pass);
		driver.findElement(By.xpath("//input[@value = \"Log in\"]")).click();
		
		driver.findElement(By.xpath("//li[@class = 'inactive']//a[@href = '/digital-downloads']")).click();
    	
    	FileArrayProvider fap = new FileArrayProvider();
        String[] lines;
		try {
			lines = fap.readLines(fileName);
			  for (String line : lines) {
//		            System.out.println(line);
		            int i = 1;
//		        	js.executeScript("window.scrollBy(0,200)", "");
		            
		            
		            driver.findElement(By.xpath("//a[text() = \"" + line + "\"] /following::input[@value = \"Add to cart\"]")).click();
		            WebElement ele = driver.findElement(By.xpath("//div[contains(@class, \"ajax\")]"));
		            
		            wait.until(ExpectedConditions.attributeContains(ele, "style", "display: none;"));
		    
//		            ele = driver.findElement(By.xpath("//a[text() = \"" + line + "\"] /following::input"));
//		            wait.until(ExpectedConditions.textToBe(By.xpath("//span[@class = 'cart-qty']"), "(" + String.valueOf(i) + ")"));
		            
//		            WebElement ele = driver.findElement(By.xpath("//div[contains(@class, \"ajax\")]"));
//		            wait.until(ExpectedConditions.attributeContains(ele, "style", "display: none;"));
//		            js.executeScript("arguments[0].scrollIntoView(true);", ele);
//		            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text() = \"" + line + "\"] /following::input[@value = \"Add to cart\"]"))).click();
		        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//span[text() = \"Shopping cart\"]")).click();
		driver.findElement(By.xpath("//input[@id = \"termsofservice\"]")).click();
		driver.findElement(By.xpath("//button[@id = \"checkout\"]")).click();
		
		driver.findElement(By.xpath("//input[@id = \"BillingNewAddress_City\"]")).sendKeys("Test");
		driver.findElement(By.xpath("//input[@id = \"BillingNewAddress_Address1\"]")).sendKeys("Test");
		driver.findElement(By.xpath("//input[@id = \"BillingNewAddress_ZipPostalCode\"]")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@id = \"BillingNewAddress_PhoneNumber\"]")).sendKeys("123456789");
		driver.findElement(By.xpath("//select[@id = \"BillingNewAddress_CountryId\"]")).click();
		driver.findElement(By.xpath("//option[@value = \"1\"]")).click();
		driver.findElement(By.xpath("//input[@title = \"Continue\"]")).click();
		
//		WebElement ele = driver.findElement(By.xpath("//input[contains(@class, \"payment-method-next\")]"));
//		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@class, \"payment-method-next\")]"))).click();
//		driver.findElement(By.xpath("//input[contains(@class, \"payment-method-next\")]")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@class, \"payment-info-next\")]"))).click();
//		driver.findElement(By.xpath("//input[contains(@class, \"payment-info-next\")]")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@class, \"confirm-order-next\")]"))).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@class, \"order-completed\")]")));
		
		boolean success  = driver.findElement(By.xpath("//strong[text()]")).getText().contains("success");
		System.out.println(success);
		
		driver.quit();
	}

}
