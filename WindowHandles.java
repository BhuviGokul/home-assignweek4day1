package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();

		// launch the browser
		ChromeDriver driver=new ChromeDriver();

		//Launching the URL
		driver.get("https://login.salesforce.com/");

		//Maximize the drive
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		
		driver.findElement(By.id("password")).sendKeys("Password$123");
		
		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		
		Set<String> windowhandle=driver.getWindowHandles();

		List<String> list=new ArrayList<String>(windowhandle);

		String second=list.get(1);

		driver.switchTo().window(second);
		
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		System.out.println(driver.getTitle());
		
		driver.close();
		
		driver.quit();
		
	}

}
