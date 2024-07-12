package com.test.Injension;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

class HomePageTest {
	
	static WebDriver driver;
	static JavascriptExecutor jsExecutor;
	static WebDriverWait wait;
	static Actions actions;
	static UtilTypes utilElements;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		driver = new ChromeDriver();
		actions = new Actions(driver);
		utilElements = new UtilTypes();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		driver.get("http://localhost:8081/home");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.quit();
	}
	
	
	@Test
	void headerTest() throws InterruptedException {
	
		driver.getTitle();
		System.out.println(driver.getTitle());
		
		WebElement mainHeader = driver.findElements(By.xpath("//div/h1")).get(0);//4
		utilElements.highlightElement(driver, mainHeader);
		utilElements.removeHighlightElement(driver, mainHeader);
		
		WebElement subHeading = driver.findElement(By.xpath("//div/h4"));
		utilElements.highlightElement(driver, subHeading);
		utilElements.removeHighlightElement(driver, subHeading);
		
		WebElement headerTitle = driver.findElement(By.xpath("//a[contains(@class,'navbar-brand')]"));
		utilElements.highlightElement(driver, headerTitle);
		utilElements.removeHighlightElement(driver, headerTitle);
		
		WebElement home = driver.findElement(By.xpath("//a[contains(@class,'navbar-brand')]"));
		utilElements.highlightElement(driver, home);
		utilElements.removeHighlightElement(driver, home);
		
		WebElement signIn = driver.findElement(By.xpath("//a[contains(@href,'/home/login')]"));
		utilElements.highlightElement(driver, signIn);
		utilElements.removeHighlightElement(driver, signIn);
		
		WebElement aboutUs = driver.findElement(By.xpath("//a[contains(@href,'#about')]"));
		utilElements.highlightElement(driver, aboutUs);
		utilElements.removeHighlightElement(driver, aboutUs);
		
		WebElement contactUs = driver.findElement(By.xpath("//a[contains(@href,'contact')]"));
		utilElements.highlightElement(driver, contactUs);
		utilElements.removeHighlightElement(driver, contactUs);
		
		WebElement imagetxt = driver.findElement(By.xpath("//section[contains(@id,'home')]/h1"));
		utilElements.highlightElement(driver, imagetxt);
		System.out.println(imagetxt.getText());
		
	}
	

	@Test
	void headerlinkTest1() {
		WebElement home = driver.findElement(By.xpath("//a[contains(@class,'navbar-brand')]"));
		home.click();
		
	}
	

	@Test
	void headerlinkTest2() {
		WebElement signIn = driver.findElement(By.xpath("//a[contains(@href,'/home/login')]"));
		signIn.click();
		driver.navigate().back();
	}		

	

	@Test
	void headerlinkTest3() {
		WebElement aboutUs = driver.findElement(By.xpath("//a[contains(@href,'#about')]"));
		aboutUs.click();
		
		//aboutUsPage
//		WebElement aboutUsheader = driver.findElement(By.xpath("//h1[contains(@class,'text-start')]"));
		WebElement aboutUsheader1 = driver.findElements(By.xpath("//h1[contains(@class,'mb-3')]")).get(0);//3
		utilElements.highlightElement(driver, aboutUsheader1);
		
		WebElement aboutUstxt1 = driver.findElements(By.xpath("//p[contains(@class,'p-1')]")).get(0);//2
		utilElements.highlightElement(driver, aboutUstxt1);
		WebElement aboutUstxt2 = driver.findElements(By.xpath("//p[contains(@class,'p-1')]")).get(1);
		utilElements.highlightElement(driver, aboutUstxt2);
		
		WebElement aboutUsheader2 = driver.findElements(By.xpath("//h1[contains(@class,'mb-3')]")).get(1);
		utilElements.highlightElement(driver, aboutUsheader2);
		
		WebElement aboutUsp1 = driver.findElements(By.xpath("//li[contains(@class,'mb-1')]")).get(0);//10
		utilElements.highlightElement(driver, aboutUsp1);
		WebElement aboutUsp2 = driver.findElements(By.xpath("//li[contains(@class,'mb-1')]")).get(1);
		utilElements.highlightElement(driver, aboutUsp2);
		WebElement aboutUsp3 = driver.findElements(By.xpath("//li[contains(@class,'mb-1')]")).get(2);
		utilElements.highlightElement(driver, aboutUsp3);
		WebElement aboutUsp4 = driver.findElements(By.xpath("//li[contains(@class,'mb-1')]")).get(3);
		utilElements.highlightElement(driver, aboutUsp4);
		
		WebElement aboutUsheader3 = driver.findElements(By.xpath("//h1[contains(@class,'mb-3')]")).get(2);
		utilElements.highlightElement(driver, aboutUsheader3);
		WebElement aboutUspp1 = driver.findElements(By.xpath("//li[contains(@class,'mb-1')]")).get(4);//10
		utilElements.highlightElement(driver, aboutUspp1);
		WebElement aboutUspp2 = driver.findElements(By.xpath("//li[contains(@class,'mb-1')]")).get(5);
		utilElements.highlightElement(driver, aboutUspp2);
		WebElement aboutUspp3 = driver.findElements(By.xpath("//li[contains(@class,'mb-1')]")).get(6);
		utilElements.highlightElement(driver, aboutUspp3);
		WebElement aboutUspp4 = driver.findElements(By.xpath("//li[contains(@class,'mb-1')]")).get(7);
		utilElements.highlightElement(driver, aboutUspp4);
		WebElement aboutUspp5 = driver.findElements(By.xpath("//li[contains(@class,'mb-1')]")).get(8);
		utilElements.highlightElement(driver, aboutUspp5);
		WebElement aboutUspp6 = driver.findElements(By.xpath("//li[contains(@class,'mb-1')]")).get(9);
		utilElements.highlightElement(driver, aboutUspp6);
	}
		

	@Test
	void headerlinkTest4() {
		WebElement contactUs = driver.findElement(By.xpath("//a[contains(@href,'contact')]"));
		contactUs.click();
		
		WebElement header = driver.findElement(By.xpath("//h2[contains(@class,'text-center')]"));
		utilElements.highlightElement(driver, header);
		WebElement subheader = driver.findElement(By.xpath("//span[contains(@class,'text-center')]"));
		utilElements.highlightElement(driver, subheader);
		
		WebElement name = driver.findElement(By.xpath("//input[contains(@name,'fullname')]"));
		utilElements.highlightElement(driver, name);
//		name.sendKeys("test");
//		jsExecutor.executeScript("arguments[0].value='test name'", name);
		
		WebElement email = driver.findElement(By.xpath("//input[contains(@name,'email')]"));
		utilElements.highlightElement(driver, email);
//		email.sendKeys("test@gmail.com");
//		jsExecutor.executeScript("arguments[0].value='test@example.com'", email);
		
		WebElement subject = driver.findElement(By.xpath("//input[contains(@name,'subject')]"));
		utilElements.highlightElement(driver, subject);
//		subject.sendKeys("test subject");
//		jsExecutor.executeScript("arguments[0].value='test subject'", subject);
		
		WebElement message = driver.findElement(By.xpath("//textarea[contains(@name,'message')]"));
		utilElements.highlightElement(driver, message);
//		jsExecutor.executeScript("arguments[0].value='test message'", message);
//		WebElement recaptacha = driver.findElement(By.xpath("//h2[contains(@class,'text-center')]"));
//		utilElements.highlightElement(driver, recaptacha);
		
		WebElement send = driver.findElements(By.xpath("//button")).get(1);//10
//		send.click();
		
//		WebElement successMessage = driver.findElement(By.className("form_status"));
//		jsExecutor.executeScript("arguments[0].scrollIntoView();", successMessage);
//		wait.until(d -> successMessage.isDisplayed());
		
		utilElements.highlightElement(driver, send);
		
//		assertTrue(successMessage.isDisplayed());
//		System.out.println(driver.findElement(By.className("text-success")).getText());
		
		WebElement findUs = driver.findElements(By.xpath("//p[contains(@class,'mb-1')]")).get(2);
		utilElements.highlightElement(driver, findUs);
		WebElement address = driver.findElement(By.xpath("//section[contains(@class,'contact')]//address"));
		utilElements.highlightElement(driver, address);
		
	}
	



	@Test
	void footerTest() throws InterruptedException{
		
		WebElement send = driver.findElements(By.xpath("//button")).get(1);
		Thread.sleep(200);
		//scroll into view
		jsExecutor.executeScript("arguments[0].scrollIntoView();", send);
		Thread.sleep(200);
		wait.until(d -> send.isDisplayed());
		Thread.sleep(200);
		
		WebElement footerTitle = driver.findElement(By.xpath("//footer/div/p"));
		utilElements.highlightElement(driver, footerTitle);

		
	}
}
