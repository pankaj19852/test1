package PracticeSelenium;


import java.awt.List;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {

    static WebDriver Driver;
    String address;
    static int TotalUrl;
    static int urlcount;
    
	public void Initialise()
	{
		
//		System.setProperty("webdriver.gecko.driver", "G:\\geckodriver\\geckodriver.exe");
//
//			WebDriver Driver = new FirefoxDriver();s
//			Driver.get("http://www.gmail.com");
//	
		
		System.setProperty("webdriver.chrome.driver", "G:\\chromedriver_win32\\chromedriver.exe");
		 Driver = new ChromeDriver();
		
		Driver.get("http://www.ymail.com");
		
		Driver.manage().window().maximize();
		//Driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
		//Thread.sleep(1000L);
		//Driver1.close();	
	}
	
	 static void Quitwindow() {
		
		Driver.close();
				
	}
	
	public void totalUrl() {
		
		java.util.List<WebElement> Urls = Driver.findElements(By.tagName("a"));
		
		TotalUrl = Urls.size();
		
		
		System.out.println("Total Url on current page are "+ TotalUrl );
		urlcount = TotalUrl + urlcount;
		for(int i=0; i<TotalUrl; i++) {
			
		address = Urls.get(i).getAttribute("href").toString();
				System.out.println((i+1) + ". "+address + "\n");
				
		}
	
		
	}
	
	
	
public void ImageUrl() {
		
		java.util.List<WebElement> ImageUrls = Driver.findElements(By.tagName("img"));
		
		TotalUrl = ImageUrls.size();
		
		System.out.println("Total Image Url on current page are "+ TotalUrl );
		urlcount = TotalUrl + urlcount;
		for(int i=0; i<TotalUrl; i++) {
			
		address = ImageUrls.get(i).getAttribute("src").toString();
				System.out.println((i+1) + ". "+address + "\n");
				
		}
	
		
	}
	
	public static void main(String[] args) {
	
		Test t1 = new Test();
		
		t1.Initialise();
		System.out.println("Window Opened");
		
		t1.totalUrl();
		
		System.out.println("total image url are as below: ");
		
		t1.ImageUrl();
		
		
		System.out.println("Totaol URl count is : "+urlcount);
		Test.Quitwindow();
		System.out.println("Window Closed");
	}
	
}

