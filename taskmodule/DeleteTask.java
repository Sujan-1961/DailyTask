package taskmodule;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DeleteTask {
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
			Thread.sleep(2000);
   		driver.findElement(By.xpath("//span[@class='triggerLinkText selectedListView slds-page-header__title slds-truncate slds-p-right--xx-small uiOutputText']")).click();
   		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Bootcamp']")).click();
		driver.findElement(By.xpath("//a[@title='Show 9 more actions']")).click();
		WebElement ele1 = driver.findElement(By.xpath("//div[text()='Delete']"));
		driver.executeScript("arguments[0].click();", ele1);
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		WebElement del = driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']"));
		String text = del.getText();
		System.out.println(text);
		String text2 = "was deleted.";
		Thread.sleep(3000);
		if (text.contains(text2)) {
			System.out.println("I confirm the text as Task Bootcamp was deleted.");
		} else {
                  System.out.println("The text doesn't match");
		}
	}
}
