package com.selenium.mavenproject;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab1 {
	 void run(){
		//WebDriverManager.chromedriver().setup();
    	WebDriverManager.chromedriver().setup();
    	
    	//System.setProperty("webdriver.chrome.driver", "C:\\eclipse_workspace\\chromedriver.exe");
    	ChromeDriver driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	
    	driver.get("https://www.google.com");
    	//driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();
    								// //div[text() = 'Priimti viską']
    	//arba
    	//driver.findElement(By.xpath("//input[@name = 'q']")).sendKeys("Test Automation");
    	//driver.findElement(By.xpath("//input[@name = 'q']")).sendKeys(Keys.ENTER);
    	//driver.findElement(By.xpath("//h3[text() = 'Test automation - Wikipedia']")).click();
    	
    	//xpath examples
    	//div[@class = 'toctitle']
    	//div[@class and @id or @name]
    	//div[@text() = 'Launched']
    	//th[contains(text(), 'Laun')]
    	//input[position < 4]
    	//input | //div
    	
	}
}
