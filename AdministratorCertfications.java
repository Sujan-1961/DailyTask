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

public class AdministratorCertfications {
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
			Thread.sleep(2000);
			driver.switchTo().window(child.get(1));
			driver.findElement(By.xpath("//button[text()='Confirm']")).click();
			Shadow shadow = new Shadow(driver);
			shadow.setImplicitWait(10);
			shadow.findElementByXPath("//span[text()='Learning']").click();
			
			WebElement elementByXPath = shadow.findElementByXPath("//span[text()='Learning on Trailhead']");
			Actions actions = new Actions(driver);
			actions.moveToElement(elementByXPath).perform();
			
			shadow.findElementByXPath("//a[text()='Salesforce Certification']").click();
			
			//Click on first resulting Certificate
			driver.findElement(By.xpath("//a[text()='Administrator']")).click();
		  
			System.out.println("The Title is" + driver.getTitle());
			
			 //verify - Administrator Overview page
			if (driver.getTitle().contains("Certification - Administrator Overview")) {
				System.out.println("I confirm the title as Certification - Administrator Overview");
			} else {
                      System.out.println("The title doesnt match");
			}
			
			List<WebElement> list = shadow.findElementsByXPath("//div[contains(@class,'credentials-card_title')]");
			for (int i = 0; i < list.size(); i++) {
				String text1 = list.get(i).getText();
				System.out.println(text1);
			}
			int countOf = list.size();
			System.out.println(countOf);
	}
}
