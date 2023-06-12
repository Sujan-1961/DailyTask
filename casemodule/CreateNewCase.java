package casemodule;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateNewCase {
         public static void main(String[] args) throws InterruptedException {
        	 ChromeOptions options = new ChromeOptions();
        		options.addArguments("--disable-notifications", "start-maximized");
        		ChromeDriver driver = new ChromeDriver(options);	
     			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
     			driver.get("https://qeagle-dev-ed.my.salesforce.com/");
     			driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
     			driver.findElement(By.id("password")).sendKeys("Leaf@1234");
     			driver.findElement(By.id("Login")).click();	
     			Thread.sleep(20000);
                driver.findElement(By.xpath("//a[@role='button']")).click();
     			Thread.sleep(3000);
     			driver.findElement(By.xpath("//span[text()='New Case']")).click();
     			driver.findElement(By.xpath("//div[@title='Yaswanth']")).click();
     			driver.findElement(By.xpath("//a[text()='New']")).click();
     			driver.findElement(By.xpath("//a[text()='Escalated']")).click();
     			driver.findElement(By.xpath("//input[@class=' input']")).sendKeys("Testing");
     			driver.findElement(By.xpath("//textarea[@class=' textarea']")).sendKeys("Dummy");
     			driver.findElement(By.xpath("//div[@class='bottomBarRight slds-col--bump-left']")).click();
     			WebElement element = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
     			String text = element.getText();
    			System.out.println(text);
    			String text2 = "Case was created.";
    			Thread.sleep(3000);
				if (text.contains(text2)) {
					System.out.println("I confirm the text as Task Bootcamp was created.");
				} else {
	                      System.out.println("The text doesn't match");
				}
		}
}
