package com.test.Injension;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class VendorTest {

	static WebDriver driver;
	static JavascriptExecutor jsExecutor;
	static WebDriverWait wait;
	static Actions actions;
	static UtilTypes utilElements;
	static ChromeOptions chromeOptions = new ChromeOptions();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		chromeOptions.addArguments("disable-infobars");
//		chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
		driver = new ChromeDriver();
		actions = new Actions(driver);
		utilElements = new UtilTypes();
		jsExecutor = (JavascriptExecutor) jsExecutor;
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		driver.get("http://localhost:8081/home");
		driver.manage().window().maximize();
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1"))));

		// click on sign in button/link
		WebElement signInLink = driver.findElement(By.xpath("//a[contains(text(),'SIGN IN')]"));
		utilElements.mouseHoverJScript(signInLink, driver);
		signInLink.click();

		wait.until(ExpectedConditions.urlToBe("http://localhost:8081/home/login"));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1"))));

		// Login with valid credentials
		WebElement emailInput = driver.findElement(By.xpath("//input[contains(@name,'username')]"));
		WebElement psdInput = driver.findElement(By.xpath("//input[contains(@name,'password')]"));
		WebElement loginButton = driver.findElement(By.xpath("//input[contains(@name,'signin')]"));

		utilElements.highlightElement(driver, emailInput);
		emailInput.sendKeys("testvendor@gmail.com");

		utilElements.highlightElement(driver, psdInput);
		psdInput.sendKeys("Testvendor@1216");

		utilElements.highlightElement(driver, loginButton);
		loginButton.click();

		wait.until(ExpectedConditions.urlToBe("http://localhost:8081/home/user/vendor-dashboard"));
		System.out.println("Vendor dashboard Url: " + driver.getCurrentUrl());

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
		WebElement logouticon = driver.findElements(By.xpath("//a[contains(@href,'#')]")).get(1);
		utilElements.highlightElement(driver, logouticon);
		logouticon.click();

		WebElement logout = driver.findElement(By.xpath("//a[contains(@href,'/home/user/logout')]"));
		utilElements.highlightElement(driver, logout);
		logout.click();
		driver.quit();
	}
	
	@Test
	void downloadsTabtest() {
		System.out.println(
				"Vendor Dashboard Heading: " + driver.findElement(By.xpath("//div//h1")));

		WebElement downloadsTabElement = driver.findElement(By.xpath("//button[contains(@id,'pills-downloads-tab')]"));
		utilElements.highlightElement(driver, downloadsTabElement);
		utilElements.mouseHoverJScript(downloadsTabElement, driver);
		downloadsTabElement.click();

		utilElements.highlightElement(driver,
				driver.findElement(By.xpath("//div[contains(@id,'pills-downloads')]//h1")));

		List<WebElement> tablehead = driver
				.findElements(By.xpath("//div[contains(@id,'pills-downloads')]//table//tr/th"));
		List<WebElement> datatablerows = driver
				.findElements(By.xpath("//div[contains(@id,'pills-downloads')]//table//tr"));

		System.out.println("Downloads table headings: ");
		for (WebElement head : tablehead) {
			utilElements.highlightElement(driver, head);
			System.out.println(head.getText());
		}

		for (WebElement row : datatablerows) {
			int index = datatablerows.indexOf(row);
			jsExecutor.executeScript("arguments[0].scrollIntoView();", row);

			if (index > 0) {
				List<WebElement> columns = row.findElements(By.xpath("td"));
				for (WebElement col : columns) {
					utilElements.highlightElement(driver, col);
					System.out.println(col.getText());

					if (index == 5 && col.getText().equals("download")) {
						utilElements.mouseHoverJScript(col, driver);
						col.click();
					}
				}
			}
		}
		driver.navigate().refresh();
//		WebElement uploadsTabElement = driver.findElement(By.xpath("//button[contains(@id,'pills-uploads-tab')]"));
//		jsExecutor.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//nav")));
//		wait.until(ExpectedConditions.elementToBeClickable(uploadsTabElement));
//		utilElements.highlightElement(driver, uploadsTabElement);
//		utilElements.mouseHoverJScript(uploadsTabElement, driver);
//		uploadsTabElement.click();
	}

}
