package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		// launch the browser
		ChromeDriver driver=new ChromeDriver();

		//Launching the URL
		driver.get("http://leaftaps.com/opentaps/control/login");

		//Maximize the drive
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");

		driver.findElement(By.id("password")).sendKeys("crmsfa");

		//Click on Login Button using Class Locator

		driver.findElement(By.className("decorativeSubmit")).click();

		//Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();


		driver.findElement(By.linkText("Contacts")).click();

		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

		driver.findElement(By.xpath("//span[text()='From Contact']/following::img[@alt='Lookup']")).click();

		Set<String> windowhandle=driver.getWindowHandles();

		List<String> list=new ArrayList<String>(windowhandle);

		String Sndwindow=list.get(1);

		driver.switchTo().window(Sndwindow);

		driver.findElement(By.xpath("//a[text()='16112']")).click();

		Thread.sleep(3000);

		Set<String> windowhandle3=driver.getWindowHandles();

		List<String> list1=new ArrayList<String>(windowhandle3);

		String Sndwindow3=list1.get(0);

		driver.switchTo().window(Sndwindow3);

		driver.findElement(By.xpath("//span[text()='To Contact']/following::img[@alt='Lookup']")).click();

		driver.findElement(By.xpath("//a[text()='16113']")).click();

		Set<String> windowhandle4=driver.getWindowHandles();

		List<String> list3=new ArrayList<String>(windowhandle4);

		String Sndwindow4=list3.get(0);

		driver.switchTo().window(Sndwindow4);

		driver.findElement(By.className("buttonDangerous")).click();

		driver.switchTo().alert().accept();

		System.out.println(driver.getTitle());


	}

}
