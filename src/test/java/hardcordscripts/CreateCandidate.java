package hardcordscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateCandidate {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//span[text()='Recruitment']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//i[contains(@class,'bi-plus')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.name("firstName")).sendKeys("Veera");
		driver.findElement(By.name("lastName")).sendKeys("R");
		driver.findElement(By.xpath("(//input[contains(@class,'oxd-input') and @placeholder='Type here'])[1]")).sendKeys("veera@tek.com");
		driver.findElement(By.xpath("//button[contains(@class,'oxd-button--seconda')]")).click();
		Thread.sleep(2000);
		
		WebElement name = driver.findElement(By.xpath("//div[contains(text(),'Veera')]"));
		String text = name.getText();
		if(text.contains("Veera"))
			System.out.println("Candidate added :) ");
		else
			System.out.println("Candidate not be added :( ");
		Thread.sleep(1000);
		
		driver.navigate().back();
		
		String candidateName = driver.findElement(By.xpath("//div[text()='Veera  R']")).getText();
		if(candidateName.contains("Veera")) {
			driver.findElement(By.xpath("//i[contains(@class,'oxd-icon bi-trash')]")).click();
		}
	}

}
