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
import org.openqa.selenium.Keys;

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
		ffd.manage().window().maximize();
		
		//Now login using user name and password
		ffd.findElement(By.xpath("/html/body/div/div[1]/form/div[2]/div/input")).sendKeys("philip_limitone@shopkeep.com");
		System.out.println("Entered username");
		ffd.findElement(By.xpath("/html/body/div/div[1]/form/div[3]/div/input")).sendKeys("PLpassword123");
		System.out.println("Entered password");
		
		//Wait for things to clear up
		System.out.println("Wait for things to clear up before clicking login");
		Thread.sleep(10000);
		
		//Click Login button
		//Had to find this by NAME because xpath was not working....
		try {
			assertEquals("commit", ffd.findElement(By.name("commit")).getAttribute("name"));
			System.out.println("Found the login button");
		} catch (Throwable e) {
			System.out.println("Something went wrong, couldn't find the login button");
		}
		
		//Now click the login button
		try {
		ffd.findElement(By.name("commit")).click();
		System.out.println("Clicked the login button");
		} catch (Throwable e) {
			System.out.println("Something happened, couldn't click the login button");
		}
		
		//click shopkeep back office on top left (from layout screen) (added this because of browser weirdness on my end)
		ffd.findElement(By.xpath("/html/body/div[1]/aside/nav/div/a[2]/img")).click();
		System.out.println("Clicked Back office at top left to go to the bird's eye view screen");
		
		//now at bird's eye view main page, select Ipad Button Layout from Items (added this because of browser weirdness on my end)
		ffd.findElement(By.xpath("/html/body/div[1]/aside/nav/ul/li[3]/a")).click();
		System.out.println("Click to expand items list on Bird's Eye View screen");
		
		//now click ipad button layout from the expanded items list (added this because of browser weirdness on my end)
		ffd.findElement(By.xpath("/html/body/div[1]/aside/nav/ul/li[3]/ul/li[2]/a")).click();
		
		//Verify that we're on the iPad Button Layout screen
		ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/h1"));
		System.out.println("Found ipad Button Layout at the top of the screen");

		//Verify the items in the list
		try {
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
		//////
		///Now search for an item (one letter)
		//enter a letter to search in the search field
		ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/header/div[1]/input")).sendKeys("a");
		System.out.println("Clicked on the search field and entered letter");

		//now verify the results in the list
		try {
			//bagel
			ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[1]/ul/li[1]"));
			
			//coffee beans
			ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[1]/ul/li[3]/span[1]"));
			
			//latte
			ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[1]/ul/li[6]"));
			
			//Misc Non-Taxable
			ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[1]/ul/li[7]/span[1]"));
			
			//Misc Taxable
			ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[1]/ul/li[8]/span[1]"));
			System.out.println("Found all the search results items");
			} catch (Throwable e) {
			System.out.println("Couldn't find search results item(s)");
			}
		////////
		
		
		//Search multiple letters
		//enter multiple letters to search in the search field
		ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/header/div[1]/input")).sendKeys("on");
		System.out.println("Clicked on the search field and entered multiple letters");
		
		//then verify the results in the list
		try {
			//Coffee beans
			ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[1]/ul/li[3]/span[2]"));
			
			//Donut
			ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[1]/ul/li[4]/span[2]"));
			
			//Misc Non-taxable
			ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[1]/ul/li[7]/span[1]"));
			System.out.println("Found all the search results items");
			
			} catch (Throwable e) {
			System.out.println("Couldn't find search results item(s)");
			}
		/////////
		
		//Search one word
		//first clear the text box of previous entries
		ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/header/div[1]/input")).clear();
		
		//then enter a search word (coffee)
		ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/header/div[1]/input")).sendKeys("coffee");
		
		//then verify the results
		//then verify the results in the list
		try {
			//Coffee
			ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[1]/ul/li[2]/span[2]"));
			
			//Coffee Beans
			ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[1]/ul/li[3]/span[2]"));
			System.out.println("Found the results in the word search list");
			} catch (Throwable e) {
			System.out.println("Couldn't find search results item(s) in the word search list");
			}
		
		//Clear out the text field for the next test
		ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/header/div[1]/input")).clear();
		/////////
		
		
		//Rename the existing page
		//Check that the existing page is there
		try {
			//Find New Page
			ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[4]/div[2]/div[2]/a/span[1]"));
			System.out.println("Found new page at the bottom");
			} catch (Throwable e) {
			System.out.println("Couldn't find new page at the bottom");
			}
		
		//click then Clear the new page field
		ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/header/div[2]/input")).click();
		ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/header/div[2]/input")).clear();
		System.out.println("cleared the new page field");
		
		//Then rename the existing page
		ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/header/div[2]/input")).sendKeys("Phil New Page");
		//Then press Enter to execute the change
		ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/header/div[2]/input")).sendKeys(Keys.RETURN);
		System.out.println("Renamed the existing page to Phil New Page");
		
		//Check for the renamed page
		ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[4]/div[2]/div[2]/a/span[1]"));
		System.out.println("Found the renamed page");
		///////////////
		
		//Create a new page
		//Click the new page button
		try {
		ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/header/div[2]/a[1]")).click();
		System.out.println("Clicked the new page button");
		} catch (Throwable e) {
			System.out.println("Did Not click the new page button");
		}
		
		//Verify the new button for the new page is at the bottom (New Page)
		try {
		ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[4]/div[2]/div[2]/a[2]/span[1]"));
		System.out.println("Found the new button");
		} catch (Throwable e) {
			System.out.println("couldn't find the new button");
		}
		
		//verify the items in the list on a new page
		try {
			//bagel
			ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[1]/ul/li[1]"));
			
			//coffee
			ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[1]/ul/li[2]"));
			
			//coffee beans
			ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[1]/ul/li[3]"));
			
			//donut
			ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[1]/ul/li[4]"));
			
			//french press
			ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[1]/ul/li[5]/span[1]"));
			
			//latte
			ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[1]/ul/li[6]/span[2]"));
			
			//misc non taxable
			ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[1]/ul/li[8]/span[2]"));
			
			//muffin
			ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[1]/ul/li[9]"));
			
			//novelty mug
			ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[1]/ul/li[10]/span[1]"));
			
			//shipping
			ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[1]/ul/li[11]"));
			
			System.out.println("found all the list items on the new created page");
		} catch (Throwable e) {
			System.out.println("Couldn't find items on the list on the new created page");
		}
		///////////
		
		//delete the created page
		//first check that it's there
		try {
			ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[4]/div[2]/div[2]/a[2]/span[1]"));
			System.out.println("Found the created page");
		}catch  (Throwable e) {
			System.out.println("Couldn't find the created page");
		}
		
		//click on the created page to make sure it's in focus
		ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[4]/div[2]/div[2]/a[2]/span[1]")).click();
		
		//then click the delete button on top right
		ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/header/div[2]/a[2]")).click();
		
		//verify the confirmation dialog appears, check the title to be sure
		ffd.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[1]/h2"));
		System.out.println("found the title of the remove dialog");
		
		//Wait to make sure things catch up
		System.out.println("wait a bit to catch up...");
		Thread.sleep(5000);
		
		//Click confirm button
		ffd.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[2]/button[2]")).click();
		System.out.println("Confirm button clicked");
		
		//now check that the button is no longer on the screen (Check that it's  NOT there)
		try {
		ffd.findElement(By.xpath("/html/body/div[1]/div[4]/div[3]/div[2]/div[4]/div[2]/div[2]/a[2]/span[1]")).isDisplayed();
		System.out.println("button no longer displayed");
		} catch (Throwable e) {
			System.out.println(e);
		}
		
		System.out.println("For now we're done....\n");
		//close the window when all is done
		ffd.close();
	}
}