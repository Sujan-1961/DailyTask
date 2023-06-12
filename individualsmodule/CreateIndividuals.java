package individualsmodule;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class CreateIndividuals {
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
    			WebElement findElement = driver.findElement(By.xpath("//p[text()='Individuals']"));
				Actions actions = new Actions(driver);
				actions.scrollToElement(findElement).perform();
				findElement.click();
				driver.findElement(By.xpath("//div[text()='New']")).click();
				driver.findElement(By.xpath("//input[@class='lastName compoundBLRadius compoundBRRadius form-element__row input']")).sendKeys("Kumar");
				Thread.sleep(10000);
				WebElement ele = driver.findElement(By.xpath("//span[text()='Save']"));
				driver.executeScript("arguments[0].click();", ele);
				
				//After clicking save it shows an error mentioning that "This page has an error".
			
		}
}
