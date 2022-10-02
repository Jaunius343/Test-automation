package com.selenium.mavenproject;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab2 {
	
	void run() {
		//WebDriverManager.chromedriver().setup();
    	WebDriverManager.chromedriver().setup();
    	
    	//System.setProperty("webdriver.chrome.driver", "C:\\eclipse_workspace\\chromedriver.exe");
    	ChromeDriver driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	
    	driver.get("https://demowebshop.tricentis.com");
    	
//    	String str = driver.findElement(By.xpath("//strong[text() = 'Categories']")).getText();
//    	System.out.println(str);
//    	driver.quit();
    	
    	driver.findElement(By.xpath("//a[text() = 'Log in']")).click();
    	driver.findElement(By.xpath("//input[@value = 'Register']")).click();
    	driver.findElement(By.xpath("//input[@id = 'gender-male']")).click();
    	driver.findElement(By.xpath("//input[contains(@id, 'First')]")).sendKeys("Firstname");
    	driver.findElement(By.xpath("//input[contains(@id, 'Last')]")).sendKeys("Lastname");
    	driver.findElement(By.xpath("//input[contains(@id, 'Email')]")).sendKeys(Math.random() + "@test.com");
    	driver.findElement(By.xpath("//input[@id ='Password']")).sendKeys("123456");
    	driver.findElement(By.xpath("//input[contains(@id, 'ConfirmPassword')]")).sendKeys("123456");
    	driver.findElement(By.xpath("//input[@value = 'Register']")).click();
    	driver.findElement(By.xpath("//input[@value = 'Continue']")).click();
    	
    	driver.findElement(By.xpath("//li[@class = 'inactive']//a[@href = '/computers']")).click();
    	driver.findElement(By.xpath("//li[@class = 'inactive']//a[@href = '/desktops']")).click();
    	driver.findElement(By.xpath("//span[text() > 1500] /following::input")).click();
    	driver.findElement(By.xpath("//input[contains(@id, 'add-')]")).click();
    	
    	System.out.println(driver.findElement(By.xpath("//span[@class = 'cart-qty']")).getText());
    	
//    	System.out.println(ExpectedConditions.textToBe(By.xpath("//span[@class = 'cart-qty']"), "(1)"));
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	
    	wait.until(ExpectedConditions.textToBe(By.xpath("//span[@class = 'cart-qty']"), "(1)"));
    	
//    	System.out.println(ExpectedConditions.textToBe(By.xpath("//span[@class = 'cart-qty']"), "(1)"));
    	
    	System.out.println(driver.findElement(By.xpath("//span[@class = 'cart-qty']")).getText());
    	
//    	new WebDriverWait((WebDriver)driver, Duration.ofSeconds(20)).until(ExpectedConditions.textToBe(By.xpath("//span[@class = 'cart-qty']"), "(1)"));
//    	new WebDriverWait()
    	
//    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class = 'cart-label']"))).click();
    	
    	WebElement ele = driver.findElement(By.xpath("//span[@class = 'cart-label']"));
    	JavascriptExecutor jse = (JavascriptExecutor)driver;
    	jse.executeScript("arguments[0].click()", ele);
    	
    	//driver.findElement(By.xpath("//span[@class = 'cart-label']")).click();
    	driver.findElement(By.xpath("//input[@type = 'checkbox']")).click();
    	
    	//Kaip sutrumpinti arba kiekviena karta nesikartoti
    	//driver.findElement(By.xpath("//input[@name= 'updatecart']")).click();
    	PerformClick(driver, "//input[@name= 'updatecart']");
    	
    	String str = driver.findElement(By.xpath("//div[contains(@class , 'order-summary')]")).getText();
    	System.out.println(str.matches("Your Shopping Cart is empty!"));
    	
    	
    	
    	driver.quit();
    	//driver.close();
    }
    
    public static void PerformClick(ChromeDriver driver, String string) {
    	driver.findElement(By.xpath(string)).click();
    }
	
}
