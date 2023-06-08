package dailytask;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class CreateDashboard {
            public static void main(String[] args) throws InterruptedException {
            	ChromeOptions options = new ChromeOptions();
           		options.addArguments("--disable-notifications", "start-maximized");
           		ChromeDriver driver = new ChromeDriver(options);	
        			//driver.manage().window().maximize();
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
        				
        		    WebElement findElement = driver.findElement(By.xpath("//p[text()='Dashboards']"));
					Actions actions = new Actions(driver);
					actions.scrollToElement(findElement).perform();
					findElement.click();
					driver.findElement(By.xpath("//div[text()='New Dashboard']")).click();
					Thread.sleep(10000);
					driver.findElement(By.xpath("//iframe[@title='dashboard']"));
					driver.switchTo().frame(0);
					driver.findElement(By.xpath("//input[@id='dashboardNameInput']")).sendKeys("SalesforceAutomationby Sujan D");
					driver.findElement(By.xpath("//button[text()='Create']")).click();
					driver.findElement(By.xpath("//button[text()='Save']")).click();
					WebElement element = driver.findElement(By.xpath("//span[@class='slds-form-element__static slds-grid slds-grid_align-spread']"));
					String text = element.getText();
        			System.out.println(text);
        			String text2 = "SalesforceAutomationby Sujan D";
        			Thread.sleep(3000);
					if (text.contains(text2)) {
						System.out.println("I confirm the text as SalesforceAutomationby Sujan D");
					} else {
		                      System.out.println("The text doesnt match");
					}
					
				    
				    }
}
