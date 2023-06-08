package taskmodule;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class CreateTask {
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
      			Thread.sleep(5000);
      			WebElement findElement = driver.findElement(By.xpath("//p[text()='Tasks']"));
				Actions actions = new Actions(driver);
				actions.scrollToElement(findElement).perform();
				findElement.click();
				driver.findElement(By.xpath("//a[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled']")).click();
				WebElement ele = driver.findElement(By.xpath("//div[text()='New Task']"));
				driver.executeScript("arguments[0].click();", ele);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input']")).sendKeys("Bootcamp");
				driver.findElement(By.xpath("//a[text()='Not Started']")).click();
				driver.findElement(By.xpath("//a[text()='Waiting on someone else']")).click();
				driver.findElement(By.xpath("//span[text()='Save']")).click();
				WebElement element = driver.findElement(By.xpath("//div[@class='slds-theme--success slds-notify--toast slds-notify slds-notify--toast forceToastMessage']"));
				String text = element.getText();
    			System.out.println(text);
    			String text2 = "Bootcamp";
    			Thread.sleep(3000);
				if (text.contains(text2)) {
					System.out.println("I confirm the text as Task Bootcamp was created.");
				} else {
	                      System.out.println("The text doesn't match");
				}
		}
}
