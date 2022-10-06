package com.selenium.mavenproject;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab4_User {
	
	public User run() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		
		User user = new User();
		user.Email = String.valueOf(Math.random()) + "@test.com";
		user.Pass = "123456";
		
		driver.findElement(By.xpath("//a[text() = 'Log in']")).click();
    	driver.findElement(By.xpath("//input[@value = 'Register']")).click();
    	driver.findElement(By.xpath("//input[@id = 'gender-male']")).click();
    	driver.findElement(By.xpath("//input[contains(@id, 'First')]")).sendKeys("Firstname");
    	driver.findElement(By.xpath("//input[contains(@id, 'Last')]")).sendKeys("Lastname");
    	driver.findElement(By.xpath("//input[contains(@id, 'Email')]")).sendKeys(user.Email);
    	driver.findElement(By.xpath("//input[@id ='Password']")).sendKeys(user.Pass);
    	driver.findElement(By.xpath("//input[contains(@id, 'ConfirmPassword')]")).sendKeys(user.Pass);
    	driver.findElement(By.xpath("//input[@value = 'Register']")).click();
    	driver.findElement(By.xpath("//input[@value = 'Continue']")).click();
    	
    	driver.quit();
		
		return user;
	}

}
