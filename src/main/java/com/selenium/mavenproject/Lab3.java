package com.selenium.mavenproject;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab3 {
	
	void run(){
		//WebDriverManager.chromedriver().setup();
    	WebDriverManager.chromedriver().setup();
    	
    	//System.setProperty("webdriver.chrome.driver", "C:\\eclipse_workspace\\chromedriver.exe");
    	ChromeDriver driver = new ChromeDriver();
    	driver.manage().window().maximize();
//    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	
    	driver.get("https://demoqa.com/");
//    	driver.get("https://www.google.com");
    	
//    	WebElement ele = driver.findElement(By.xpath("/descendant::div/h5[text() = \"Widgets\"]"));
//    	JavascriptExecutor jse = (JavascriptExecutor)driver;
//    	jse.executeScript("arguments[0].click()", ele);
//    	
//    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/descendant::div/h5[text() = \"Widgets\"]"))).click();
    	//wait.pollingEvery(Duration.ofSeconds(5));
    	//wait.ignoring(NoSuchElementException.class);
    	
    	//fluentWait
//    	Function<WebDriver,Boolean> function = new Function<WebDriver,Boolean>(){
//    		public Boolean apply(WebDriver arg0) {
//    			WebElement element = arg0.findElement(By.xpath(""));
//    			String textValue = element.getText();
//    			if(textValue.equals("text")) return true;
//    			return false;
//    		}
//    	};
    	
    	//driver.findElement(By.xpath("/descendant::div/h5[text() = \"Widgets\"]")).click();
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	//js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
    	
    	WebElement ele = driver.findElement(By.xpath("/descendant::div[contains(@class, \"card mt\")][4]"));
    	js.executeScript("arguments[0].scrollIntoView(true);", ele);
    	driver.findElement(By.xpath("/descendant::div[contains(@class, \"card mt\")][4]")).click();
    	
    	
//    	js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
    	
    	ele = driver.findElement(By.xpath("/descendant::span[text() = \"Progress Bar\"]"));
    	js.executeScript("arguments[0].scrollIntoView(true);", ele);    	
    	
    	driver.findElement(By.xpath("/descendant::span[text() = \"Progress Bar\"]")).click();
    	
    	
    	driver.findElement(By.xpath("/descendant::button[text() = \"Start\"]")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.textToBe(By.xpath("/descendant::div[@id = \"progressBar\"]/child::*"), "100%"));
    	
    	driver.findElement(By.xpath("/descendant::button[@id = \"resetButton\"]")).click();
    	
    	String str = driver.findElement(By.xpath("/descendant::div[@id = \"progressBar\"]/child::*")).getText();
    	System.out.println(str.matches("0%"));
    	
    	///descendant::div[@id = "progressBar"]/child::*[contains(text(),"")]
    	
    	driver.quit();
	}
}
