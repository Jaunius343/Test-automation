package com.selenium.mavenproject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab3_2 {
	
	void run() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
    	driver.findElement(By.xpath("/descendant::div[contains(@class, \"card mt\")][1]")).click();
    	
    	WebElement ele = driver.findElement(By.xpath("/descendant::span[text() = \"Web Tables\"]"));
    	js.executeScript("arguments[0].scrollIntoView(true);", ele);
//    	js.executeScript("window.scrollBy(0,500)", "");
    	driver.findElement(By.xpath("/descendant::span[text() = \"Web Tables\"]")).click();
    	
    	
    	ExpectedCondition<Boolean> secondPageExists = arg0 -> {
    		if (driver.findElement(By.xpath("//span[@class = \"-totalPages\"]")).getText().equals("2")) {
    			return true;
    		} else {
    			driver.findElement(By.xpath("/descendant::button[@id = \"addNewRecordButton\"]")).click();
        		
        		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@id, 'first')]"))).sendKeys("Firstname");
            	
            	//driver.findElement(By.xpath("//input[contains(@id, 'first')]")).sendKeys("Firstname");
            	driver.findElement(By.xpath("//input[contains(@id, 'last')]")).sendKeys("Lastname");
            	driver.findElement(By.xpath("//input[contains(@id, 'Email')]")).sendKeys(Math.random() + "@test.com");
            	driver.findElement(By.xpath("//input[contains(@id, 'age')]")).sendKeys("80");
            	driver.findElement(By.xpath("//input[contains(@id, 'salary')]")).sendKeys("99999");
            	driver.findElement(By.xpath("//input[contains(@id, 'department')]")).sendKeys("testing");
            			
        		driver.findElement(By.xpath("/descendant::button[text() = \"Submit\"]")).click();
    			return false;
    		}
    	};
    	wait.until(secondPageExists);
    	
    	
//    	for(int i = 0; i <= 7; ++i) {
//    		driver.findElement(By.xpath("/descendant::button[@id = \"addNewRecordButton\"]")).click();
//    		
//    		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@id, 'first')]"))).sendKeys("Firstname");
//        	
//        	//driver.findElement(By.xpath("//input[contains(@id, 'first')]")).sendKeys("Firstname");
//        	driver.findElement(By.xpath("//input[contains(@id, 'last')]")).sendKeys("Lastname");
//        	driver.findElement(By.xpath("//input[contains(@id, 'Email')]")).sendKeys(Math.random() + "@test.com");
//        	driver.findElement(By.xpath("//input[contains(@id, 'age')]")).sendKeys("80");
//        	driver.findElement(By.xpath("//input[contains(@id, 'salary')]")).sendKeys("99999");
//        	driver.findElement(By.xpath("//input[contains(@id, 'department')]")).sendKeys("testing");
//        			
//    		driver.findElement(By.xpath("/descendant::button[text() = \"Submit\"]")).click();
//    	}
    	
    	js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/descendant::button[text() = \"Next\"]"))).click();
    	
//    	try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
    	//driver.findElement(By.xpath("/descendant::button[text() = \"Next\"]")).click();
    	driver.findElement(By.xpath("/descendant::span[contains(@id, \"delete-record\")]")).click();
    	
    	String str = driver.findElement(By.xpath("//span[@class = \"-totalPages\"]")).getText();
    	System.out.println(str.matches("1"));
	}

}
