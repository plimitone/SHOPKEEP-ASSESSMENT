package com.shopkeep;
//This may need to be commented out or modified if running on another machine


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;


public class ShopKeepAssessment {
	 
	public static void main(String[] args) throws InterruptedException {
				
		// Create a new instance of the Firefox driver
		WebDriver ffd = new FirefoxDriver();
		ffd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//System.setProperty("webdriver.chrome.driver", "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
		//WebDriver ffd = new ChromeDriver();
		//DesiredCapabilities capability = DesiredCapabilities.chrome();
        //ffd = new RemoteWebDriver(new URL("http://127.0.0.1"), capability);
		
		//Launch the ShopKeep test area
		String url = "https://test-pl-1.shopkeepapp.com/ipad-layout";
		ffd.get("https://test-pl-1.shopkeepapp.com/ipad-layout");
		ffd.get(url);
		//print message to the screen that successfully reached URL
		System.out.println("Reached the initial ipad-layout URL....now will be redirected to the login screen");
		
		//Then you're brought to the login screen, check that too
		String loginURL = "https://www.shopkeepapp.com/login";
		ffd.get("https://www.shopkeepapp.com/login");
		ffd.get(loginURL);
		// Print a Log In message to the screen for login
        System.out.println("Successfully opened the login screen");
        
		//Store the title name into the String variable
		String title = ffd.getTitle();
		
		//Store the title length into the int variable
		int titleLength = ffd.getTitle().length();
		
		//Print the title and length to the Console window
		System.out.println("The title of the page is, " + title);
		System.out.println("The length of the title is, " + titleLength);
		
		//Store the URL in String variable
		String actualUrl = ffd.getCurrentUrl();
		
		if (actualUrl.equals(loginURL)){
			System.out.println("Verification is successful --- The correct URL was opened");
		}else{
			System.out.println("Verification has failed -- Incorrect URL has opened");
			//IN CASE OF FAILURE
			System.out.println("Actual URL is " + actualUrl);
			System.out.println("Expected URL is " + loginURL);
		}
		
		//Store the page source into String variable
		String pageSource = ffd.getPageSource();
		
		//Store page source length into string
		int pageSourceLength = pageSource.length();
		
		//Print the length of the page source
		System.out.println("Total length of page source is " + pageSourceLength);
		
		//Wait for 5 Sec
		System.out.println("Waiting for things to clear up......");
		Thread.sleep(5000);
		
		//Maximize the webpage
		//ffd.manage().window().maximize();
		
		//Now login using user name and password
		ffd.findElement(By.xpath("/html/body/div/div[1]/form/div[2]/div/input")).sendKeys("philip_limitone@shopkeep.com");
		System.out.println("Entered username");
		ffd.findElement(By.xpath("/html/body/div/div[1]/form/div[3]/div/input")).sendKeys("PLpassword123");
		System.out.println("Entered password");
		
		//Wait for things to clear up
		//System.out.println("Wait for things to clear up before clicking login");
		//Thread.sleep(10000);
		
		//Click Login button
		ffd.findElement(By.xpath("//div[4]/input")).click();
		System.out.println("Clicked login....");
		
		//Verify that we're on the iPad Button Layout screen
		ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/h1"));
		System.out.println("Found ipad Button Layout at the top of the screen");

		try {
		//Verify the items in the list
		//Bagel
		ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[1]/ul/li[1]"));
		System.out.println("Found Bagel");
		
		//Coffee
		ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[1]/ul/li[2]"));
		System.out.println("Found Coffee");
		
		//Coffee Beans
		ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[1]/ul/li[3]/span[1]"));
		System.out.println("Found Coffee Beans");
		
		//Donut
		ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[1]/ul/li[4]/span[1]"));
		System.out.println("Found Donut");
		
		//French Press
		ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[1]/ul/li[5]/span[2]"));
		System.out.println("Found French Press");
		
		//Latte
		ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[1]/ul/li[6]/span[2]"));
		System.out.println("Found Latte");
		
		//Misc Non Taxable
		ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[1]/ul/li[8]/span[2]"));
		System.out.println("Found Non Taxable");
		
		//Muffin
		ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[1]/ul/li[9]"));
		System.out.println("Found muffin");
		
		//Novelty Mug
		ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[1]/ul/li[10]/span[1]"));
		System.out.println("Found Novelty Mug");
		
		//Shipping
		ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[1]/ul/li[11]"));
		System.out.println("Found Shipping");
		} catch (Throwable e) {
			System.out.println("Unable to find an item in the list!!!");
		}
		
		System.out.println("For now we're done....\n");
		//close the window when all is done
		ffd.close();
	}
}