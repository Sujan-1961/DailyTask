package dailytask;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.sukgu.Shadow;

public class ArchitectCertifications {
           public static void main(String[] args) throws InterruptedException {
        	   ChromeOptions options = new ChromeOptions();
          		options.addArguments("--disable-notifications", "start-maximized");
          		ChromeDriver driver = new ChromeDriver(options);	
   			driver.manage().window().maximize();
   			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
   			driver.get("https://qeagle-dev-ed.my.salesforce.com/");
   			driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
   			driver.findElement(By.id("password")).sendKeys("Leaf@1234");
   			driver.findElement(By.id("Login")).click();
   			
   			driver.findElement(By.xpath("//span[text()='Learn More']")).click();
   			Set<String> handles = driver.getWindowHandles();
   			List<String>child=new ArrayList<String>(handles);
   			Thread.sleep(10000);
   			driver.switchTo().window(child.get(1));
   			driver.findElement(By.xpath("//button[text()='Confirm']")).click();
   			Shadow shadow = new Shadow(driver);
   			shadow.setImplicitWait(10);
   			shadow.findElementByXPath("//span[text()='Learning']").click();
   			
   			WebElement elementByXPath = shadow.findElementByXPath("//span[text()='Learning on Trailhead']");
   			Actions actions = new Actions(driver);
   			actions.moveToElement(elementByXPath).perform();
   			
   			shadow.findElementByXPath("//a[text()='Salesforce Certification']").click();   			
   			driver.findElement(By.xpath("//div[@class='slds-p-horizontal--small slds-p-top--small'][2]")).click();
   			
   			WebElement findText = driver.findElement(By.xpath("//div[text()=' Salesforce Architects are the most trusted digital advisors and respected team leaders in the ecosystem. They’re big-picture thinkers and in-depth problem solvers who take pride in designing systems that can stand up to anything. Salesforce Architect credentials comprise various certification paths that recognize specialized knowledge and skills, as well as your growing expertise using the Salesforce platform. ']"));
				String text3 = findText.getText();
				System.out.println("The Summary is " +text3);
			
   			
   			List<WebElement> list = shadow.findElementsByXPath("//div[contains(@class,'credentials-card_title')]");
   			for (int i = 0; i < list.size(); i++) {
				String text1 = list.get(i).getText();
				System.out.println("The Salesforce certification list" +text1);
			}
   			int count = list.size();
			System.out.println(count);
			
			driver.findElement(By.xpath("//a[text()='Application Architect']")).click();
			
			List<WebElement> list1 = shadow.findElementsByXPath("//div[@class='credentials-card_title']");
			for (int i = 0; i < list1.size(); i++) {
				String text2 = list1.get(i).getText();
				System.out.println("The Application Architect certification list" +text2);
			}
			int countOf = list1.size();
			System.out.println(countOf);
			
			
//			int countOf = list1.size();
//			System.out.println(countOf);
//			
 		
		}
}
