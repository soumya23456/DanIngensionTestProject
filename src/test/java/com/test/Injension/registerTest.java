package com.test.Injension;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

class registerTest {

	static WebDriver driver;
	static JavascriptExecutor jsExecutor;
	static WebDriverWait wait;
	static Actions actions;
	static UtilTypes utilElements;
	static WebElement name, email, number, pwd, repwd, address, zipcode, state, country, admin, vendor, client,
			registerbtn;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		driver = new ChromeDriver();
		actions = new Actions(driver);
		utilElements = new UtilTypes();
		jsExecutor = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofMillis(2000));

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		driver.quit();
	}

	@BeforeEach
	void setUp() {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		driver.get("http://localhost:8081/home/register");

		assertEquals("http://localhost:8081/home/register", driver.getCurrentUrl());
		System.out.println(driver.getCurrentUrl());

		driver.getTitle();
		assertEquals("Novo ProSo, Inc", driver.getTitle());

		utilElements.highlightElement(driver, driver.findElement(By.xpath("//h1")));// welcome to nps
		utilElements.highlightElement(driver, driver.findElement(By.xpath("//h4")));// dan ingension project
		utilElements.highlightElement(driver, driver.findElement(By.xpath("//h2")));// signup

		name = driver.findElements(By.xpath("//input")).get(0);
		email = driver.findElements(By.xpath("//input")).get(1);
		number = driver.findElements(By.xpath("//input")).get(2);
		pwd = driver.findElements(By.xpath("//input")).get(3);
		repwd = driver.findElements(By.xpath("//input")).get(4);
		address = driver.findElements(By.xpath("//input")).get(5);
		zipcode = driver.findElements(By.xpath("//input")).get(6);
		state = driver.findElement(By.xpath("//select[contains(@id,'state')]"));
		country = driver.findElement(By.xpath("//select[contains(@id,'country')]"));

		admin = driver.findElement(By.xpath("//label[contains(text(),'Admin')]"));
		client = driver.findElement(By.xpath("//label[contains(text(),'Client')]"));
		vendor = driver.findElement(By.xpath("//label[contains(text(),'Vendor')]"));

//		recaptcha = driver.findElement(By.xpath("//div[contains(@class,'recaptcha-checkbox-border')]"));//2
//		recaptcha = driver.findElement(By.cssSelector("recaptcha challenge expires in two minutes"));//2

//		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));

		registerbtn = driver.findElements(By.xpath("//input")).get(10);

	}

	@Disabled
	@Test
	void withreCaptcha() throws InterruptedException {

		utilElements.highlightElement(driver, name);
		name.sendKeys("rishiA");
		utilElements.highlightElement(driver, email);
		email.sendKeys("rishiA@gmailcom");
		utilElements.highlightElement(driver, number);
		number.sendKeys("9704570475");
		utilElements.highlightElement(driver, pwd);
		pwd.sendKeys("Rishi@1216");
		utilElements.highlightElement(driver, repwd);
		repwd.sendKeys("Rishi@1216");
		utilElements.highlightElement(driver, address);
		address.sendKeys("dc");
		utilElements.highlightElement(driver, zipcode);
		zipcode.sendKeys("20001");
		Select stateElements = new Select(state);
		stateElements.selectByVisibleText("Washington");
		Select countryElements = new Select(country);
		countryElements.selectByVisibleText("America");
		
		jsExecutor.executeScript("arguments[0].scrollIntoView();",
		driver.findElement(By.xpath("//input[contains(@id,'radio1')]")));
		Thread.sleep(200);
		wait.until(ExpectedConditions.elementToBeClickable(admin));
		Thread.sleep(200);
		admin.click();
		Thread.sleep(200);
		//input[contains(@id,'radio1')]
		//label[contains(text(),'Admin')]
		utilElements.highlightElement(driver, admin);

		utilElements.highlightElement(driver, client);
		utilElements.highlightElement(driver, vendor);

		// recaptcha
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
//		 Thread.sleep(5000);
		driver.findElement(By.className("recaptcha-checkbox-border")).click();
//		 recaptcha.click();
//		 Thread.sleep(5000);
		driver.switchTo().defaultContent();

		utilElements.highlightElement(driver, registerbtn);
//		 registerbtn.click();

		assertEquals("http://localhost:8081/home/register", driver.getCurrentUrl());
	}


	@Test
	void withsignedInUsersNoReCaptcha() throws InterruptedException{
		utilElements.highlightElement(driver, name);
		name.sendKeys("rishiA");
		utilElements.highlightElement(driver, email);
		email.sendKeys("rishiA@gmailcom");
		utilElements.highlightElement(driver, number);
		number.sendKeys("9704570475");
		utilElements.highlightElement(driver, pwd);
		pwd.sendKeys("Rishi@1216");
		utilElements.highlightElement(driver, repwd);
		repwd.sendKeys("Rishi@1216");
		utilElements.highlightElement(driver, address);
		address.sendKeys("dc");
		utilElements.highlightElement(driver, zipcode);
		zipcode.sendKeys("20001");
		Select stateElements = new Select(state);
		stateElements.selectByVisibleText("Washington");
		Select countryElements = new Select(country);
		countryElements.selectByVisibleText("America");
		utilElements.highlightElement(driver, admin);
		utilElements.highlightElement(driver, client);
		utilElements.highlightElement(driver, vendor);
		jsExecutor.executeScript("arguments[0].scrollIntoView();",
		driver.findElement(By.xpath("//input[contains(@id,'radio3')]")));
		Thread.sleep(200);
		wait.until(ExpectedConditions.elementToBeClickable(vendor));
		Thread.sleep(200);
		vendor.click();
		Thread.sleep(200);
		// recaptcha

		System.out.println("With existing Credentials:");
//		WebElement errorMsg1 = driver.findElements(By.xpath("//span[contains(@class,'text-danger')]")).get(0);
//		WebElement errorMsg2 = driver.findElements(By.xpath("//span[contains(@class,'text-danger')]")).get(2);
//		WebElement errorMsg3 = driver.findElements(By.xpath("//span[contains(@class,'text-danger')]")).get(4);

//		System.out.println("Error message: " + errorMsg1.getText());
//		System.out.println("Error message: " + errorMsg2.getText());
//		System.out.println("Error message: " + errorMsg3.getText());

		assertEquals("http://localhost:8081/home/register", driver.getCurrentUrl());
		
		utilElements.highlightElement(driver, registerbtn);
		registerbtn.click();

		assertEquals("http://localhost:8081/home/register/adduser", driver.getCurrentUrl());
	}



	@Test
	void failedSignup() throws InterruptedException{

		utilElements.highlightElement(driver, name);
		name.sendKeys("");
		utilElements.highlightElement(driver, email);
		email.sendKeys("");
		utilElements.highlightElement(driver, number);
		number.sendKeys("");
		utilElements.highlightElement(driver, pwd);
		pwd.sendKeys("");
		utilElements.highlightElement(driver, repwd);
		repwd.sendKeys("");
		utilElements.highlightElement(driver, address);
		address.sendKeys("");
		utilElements.highlightElement(driver, zipcode);
		zipcode.sendKeys("");
		Select stateElements = new Select(state);
		stateElements.selectByVisibleText("Washington");
		Select countryElements = new Select(country);
		countryElements.selectByVisibleText("America");
		utilElements.highlightElement(driver, admin);
		utilElements.highlightElement(driver, client);
		utilElements.highlightElement(driver, vendor);

		// recaptcha
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
		Thread.sleep(5000);
		driver.findElement(By.className("recaptcha-checkbox-border")).click();
//		recaptcha.click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		
		utilElements.highlightElement(driver, registerbtn);
//		registerbtn.click();

//		System.out.println("Full Name: " + name.getDomProperty("value"));
//		System.out.println("Email: " + email.getDomProperty("value"));
//		System.out.println("Phone Number: " + number.getDomProperty("value"));

		utilElements.highlightElement(driver, registerbtn);
//		registerbtn.click();

//		System.out.println("With empty Credentials:");
//		WebElement errorMsg1 = driver.findElements(By.xpath("//span[contains(@class,'text-danger')]")).get(0);
//		WebElement errorMsg2 = driver.findElements(By.xpath("//span[contains(@class,'text-danger')]")).get(1);
//		WebElement errorMsg3 = driver.findElements(By.xpath("//span[contains(@class,'text-danger')]")).get(2);

//		System.out.println("Error message: " + errorMsg1.getText());
//		System.out.println("Error message: " + errorMsg2.getText());
//		System.out.println("Error message: " + errorMsg3.getText());

		assertEquals("http://localhost:8081/home/register", driver.getCurrentUrl());
	}


	@Test
	void navigate() {
		WebElement accountExists = driver.findElement(By.xpath("//a[contains(@class,'signup-image-link')]"));
		accountExists.click();
		assertEquals("http://localhost:8081/home/login", driver.getCurrentUrl());
		driver.navigate().back();

	}

}
