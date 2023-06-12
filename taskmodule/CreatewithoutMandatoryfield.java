package taskmodule;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreatewithoutMandatoryfield {
        public static void main(String[] args) throws InterruptedException {
        	ChromeOptions options = new ChromeOptions();
    		options.addArguments("--disable-notifications", "start-maximized");
    		ChromeDriver driver = new ChromeDriver(options);	
 			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
 			driver.get("https://qeagle-dev-ed.my.salesforce.com/");
 			driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
 			driver.findElement(By.id("password")).sendKeys("Leaf@1234");
 			driver.findElement(By.id("Login")).click();	
 			driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
   			try {
 				driver.findElement(By.xpath("//button[text()='View All']")).click();      		
				} catch (Exception e) {
					// TODO: handle exception
				}
   		driver.findElement(By.xpath("//p[text()='Sales']")).click();
   		//driver.findElement(By.xpath("//a[@class='slds-context-bar__label-action dndItem']/span[text()='Tasks']")).click();
   		WebElement ele = driver.findElement(By.xpath("//a[@class='slds-context-bar__label-action dndItem']/span[text()='Tasks']"));
			driver.executeScript("arguments[0].click();", ele);
			driver.findElement(By.xpath("//a[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled']")).click();
			WebElement ele1 = driver.findElement(By.xpath("//div[text()='New Task']"));
			driver.executeScript("arguments[0].click();", ele1);
			driver.findElement(By.xpath("//textarea[@role='textbox']")).sendKeys("SALESFORCE Automation Using Selenium");
			driver.findElement(By.xpath("//button[@title='Save']")).click();
			String text = driver.findElement(By.xpath("//div[@class='genericNotification']")).getText();
			System.out.println(text);
			String text2 = "Review the errors on this page.";
			Thread.sleep(3000);
			if (text.contains(text2)) {
				System.out.println("I confirm the error message is Review the errors on this page.");
			} else {
                      System.out.println("The text doesn't match");
			}
		}
}
