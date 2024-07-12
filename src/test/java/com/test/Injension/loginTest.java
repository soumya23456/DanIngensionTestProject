package com.test.Injension;

import static org.junit.jupiter.api.Assertions.*;

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
import org.openqa.selenium.support.ui.WebDriverWait;

class loginTest {
	
	static WebDriver driver;
	static WebDriverWait wait;
	static Actions actions;
	static UtilTypes utilElements;
	static JavascriptExecutor jsExecutor;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		driver = new ChromeDriver();
		actions = new Actions(driver);
		utilElements = new UtilTypes();
		jsExecutor = (JavascriptExecutor) driver;
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
//		driver.quit();
	}
	
	@BeforeEach
	void setUp() {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		driver.get("http://localhost:8081/home/login");
	}
	
	@AfterEach
	void closeUp() {
		
	}
	
	
	  @Test 
	  void navigateTest() throws InterruptedException {
		   
		  
	 
	  wait = new WebDriverWait(driver, Duration.ofMillis(1000)); 
	  
	  assertTrue(driver.getCurrentUrl().equals("http://localhost:8081/home/login"));
	  System.out.println(driver.getCurrentUrl());

	  WebElement SignInHeading = driver.findElement(By.xpath("//h2"));
	  utilElements.highlightElement(driver, SignInHeading);
	  utilElements.removeHighlightElement(driver, SignInHeading);
	  
	  WebElement email = driver.findElements(By.xpath("//input")).get(0);
	  utilElements.highlightElement(driver, email);
	  
	  WebElement password = driver.findElements(By.xpath("//input")).get(1);
	  utilElements.highlightElement(driver, password);
	  
	  WebElement loginBtn = driver.findElements(By.xpath("//input")).get(2);
	  utilElements.highlightElement(driver, loginBtn);
	  
	  WebElement forgetpwd = driver.findElement(By.xpath("//a[contains(text(),' Forgot Password?')]"));
	  utilElements.highlightElement(driver, forgetpwd);
	  
	  WebElement accountCreate = driver.findElement(By.xpath("//span/a"));
	  utilElements.highlightElement(driver, accountCreate);
	  
	  WebElement facebook = driver.findElements(By.xpath("//ul[contains(@class,'socials')]/li")).get(0);
	  utilElements.highlightElement(driver, facebook);
	  
	  WebElement twitter = driver.findElements(By.xpath("//ul[contains(@class,'socials')]/li")).get(1);
	  utilElements.highlightElement(driver, twitter);
	  
	  WebElement gmail = driver.findElements(By.xpath("//ul[contains(@class,'socials')]/li")).get(2);
	  utilElements.highlightElement(driver, gmail);
	  
	  
	  }
	  
	  
	
	  @Test void failedLogintest() throws InterruptedException {
	  
	  WebElement SignInHeading =  driver.findElement(By.xpath("//h2"));
	  utilElements.highlightElement(driver, SignInHeading);
//	  wait.until(ExpectedConditions.visibilityOf(SignInHeading));
//	  highlightElement(driver, SignInHeading);
	  
	  assertEquals("http://localhost:8081/home/login", driver.getCurrentUrl());
	  
	  WebElement inputEmailElement = driver.findElements(By.xpath("//input")).get(0); 
	  WebElement inputPasswordElement = driver.findElements(By.xpath("//input")).get(1);
	  WebElement signInBtn = driver.findElements(By.xpath("//input")).get(2);
	  
	  inputEmailElement.sendKeys(""); 
	  inputPasswordElement.sendKeys("");
	  System.out.println("Email: " + inputEmailElement.getDomProperty("value")); 
	  System.out.println("Password: " + inputPasswordElement.getDomProperty("value"));

//	  actions.moveToElement(signInBtn).perform();
	  signInBtn.click();
	  
	  WebElement errorMsg = driver.findElement(By.xpath("//div[contains(@class,'alert')]/strong"));
//	  elementWait.until(d-> driver.findElement(By.xpath("//div[contains(@class,'alert')]")).isDisplayed()); 

	  System.out.println("With Empty Credentials:"); 
	  
	  System.out.println("Error message: " + errorMsg.getText());
//	  utilElements.highlightElement(driver, errorMsg);
	  assertEquals("http://localhost:8081/home/login?error", driver.getCurrentUrl());
	  
	  WebElement inputEmailElement1 = driver.findElements(By.xpath("//input")).get(0); 
	  WebElement inputPasswordElement1 = driver.findElements(By.xpath("//input")).get(1);
	  WebElement signInBtn1 = driver.findElements(By.xpath("//input")).get(2);
	  
	  inputEmailElement1.sendKeys("test@www.d");
	  inputPasswordElement1.sendKeys("test");
	  actions.moveToElement(signInBtn1).perform(); 
	  System.out.println("Email: " + inputEmailElement1.getDomProperty("value")); 
	  System.out.println("Password: " + inputPasswordElement1.getDomProperty("value"));
	  signInBtn1.click();
	  System.out.println("With Invalid Credentials:"); 
	  
	  
	  
	  WebElement errorMsg1 = driver.findElement(By.xpath("//div[contains(@class,'alert')]/strong"));
//	  elementWait.until(d-> driver.findElement(By.xpath("//div[contains(@class,'alert')]")).isDisplayed()); 
	  System.out.println("Error message: " +errorMsg1.getText());
	  
	  System.out.println("With Empty Credentials:"); 
	  
	  System.out.println("Error message: " + errorMsg1.getText());
//	  utilElements.highlightElement(driver, errorMsg1);
	  assertEquals("http://localhost:8081/home/login?error", driver.getCurrentUrl());
	  
	  }
	  
	//success logins
	
	  @Test 
	  void adminLogintest() throws InterruptedException {
		    
	  WebElement inputEmailElement = driver.findElements(By.xpath("//input")).get(0); 
	  WebElement inputPasswordElement = driver.findElements(By.xpath("//input")).get(1);
	  WebElement signInBtn = driver.findElements(By.xpath("//input")).get(2);
	  
	  WebElement footerTitle = driver.findElement(By.xpath("//div/p"));
	  jsExecutor.executeScript("arguments[0].scrollIntoView();", footerTitle);
	  
	  System.out.println("With Valid Credentials:");
	  inputEmailElement.sendKeys("testadmin1@gmail.com"); 
//	  highlightElement(driver,inputEmailElement); 
	  System.out.println("Email: " +inputEmailElement.getDomProperty("value"));
	  
	  inputPasswordElement.sendKeys("Testadmin@1216");
//	  highlightElement(driver,inputPasswordElement); 
	  System.out.println("Password: " + inputPasswordElement.getDomProperty("value"));
	  
	  actions.moveToElement(signInBtn).perform(); 
//	  highlightElement(driver, signInBtn); 
	  signInBtn.click();
	  
	  System.out.println("Admin logged in");
	  
	  wait.until(ExpectedConditions.urlToBe("http://localhost:8081/home/user/admin-dashboard"));
	  System.out.println(driver.getCurrentUrl());
	  
	  WebElement logouticon = driver.findElements(By.xpath("//a[contains(@href,'#')]")).get(1);
	  utilElements.highlightElement(driver, logouticon);
	  logouticon.click();
	  
	  WebElement logout = driver.findElement(By.xpath("//a[contains(@href,'/home/user/logout')]"));
	  utilElements.highlightElement(driver, logout);
	  logout.click();
	  
	  wait.until(ExpectedConditions.urlToBe("http://localhost:8081/home/login?logout"));
	  System.out.println(driver.getCurrentUrl());
	  
	  
	  }
	  
}
