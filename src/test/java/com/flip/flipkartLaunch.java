package com.flip;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Before;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.junit.After;

public class flipkartLaunch {
	
	 static WebDriver driver;
	 static long start;

	    @BeforeClass
	    public static void browserlaunch() {
	        System.setProperty("webdriver.edge.driver", "C:\\Users\\User\\eclipse-workspace\\FlipkartLaunch\\target\\msedgedriver.exe");
	        driver = new EdgeDriver();
	        driver.manage().window().maximize();
	        System.out.println("Edge browser launched");
	    }

	    @AfterClass
	    public static void quit() {
	           driver.quit();
	            System.out.println("Edge browser closed");
	        }
	    
	    @Before
	    public void starttime() {
	    	start= System.currentTimeMillis();
	    	System.out.println("before");
	    }
	    @After
	    public void endtime() {
	    	long end= System.currentTimeMillis();
	    	System.out.println("Aftertotaltime"+ (end-start));
	    }
	    @Test
	    public void method1() throws InterruptedException {
	        driver.get("https://www.flipkart.com/");
	        Thread.sleep(2000);
	      
	    }
	    @Test
	    public void method2() throws InterruptedException, AWTException {
	    	WebElement search=driver.findElement(By.xpath("//input[@type='text']"));
	    	search.sendKeys("Realme mobile");
	    	 Thread.sleep(2000);
	    	 Robot r= new Robot();
	    		r.keyPress(KeyEvent.VK_ENTER);
	    	    r.keyRelease(KeyEvent.VK_ENTER);
	    	    Thread.sleep(2000);
	    }
	    @Test
	    public void method3() {
	    	WebElement getproduct = driver.findElement(By.xpath("//div[@class='KzDlHZ']"));
         	getproduct.click();
	    }
	    @Test
	    public void method4() {
	    	String parentwindow=driver.getWindowHandle();
	        
	        Set<String>allwindow=driver.getWindowHandles();
	        
	        for(String x:allwindow) {
	        	if(!parentwindow.equals(x)) {
	        		driver.switchTo().window(x);
	        	}
	        }
	       WebElement text= driver.findElement(By.xpath("//span[contains(text(),'realme C61 (Safari Green, 128 GB)')]"));
	       System.out.println(text.getText());
	    }
	    @Test
	    public void method5() {
	        WebElement text = driver.findElement(By.xpath("//span[contains(text(),'realme C61')]"));
	        String ProductName = text.getText().toLowerCase();
	        if (ProductName.contains("realme c61")) {
	            System.out.println("method 5= validation pass");
	        } else {
	            System.out.println("method 5= validation fail");
	        }
	    }
	    @Test
	    public void method6() {
	    	WebElement buynow = driver.findElement(By.xpath("//button[@class='QqFHMw vslbG+ _3Yl67G _7Pd1Fp']"));
	    	buynow.click();
	    	
	    }
}