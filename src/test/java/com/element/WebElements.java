package com.element;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElements {


	Faker data = new Faker();
	
	
	
	WebDriver driver;

	@BeforeClass // runs once for all tests
	public void setUp() {
		System.out.println("Setting up WebDriver in BeforeClass...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.manage().window().fullscreen();
	}

	@Test
	public void WebElementExamples() throws InterruptedException {
		driver.get(
				"https://forms.zohopublic.com/murodil/form/SeleniumWebElements/formperma/eCecYgX4WMcmjxvXVq6UdhA2ABXIoqPAxnAF8H8CCJg");

		List<WebElement> names= driver.findElements(By.xpath("//input[@type='text']"));
		for (WebElement each : names) {
			each.sendKeys(data.name().firstName() + " " + data.name().lastName());
		
		}


		Select select = new Select(driver.findElement(By.tagName("select")));
		List<WebElement> dropDown = select.getOptions();

		for (int i = 0; i < 4; i++) {
			select.selectByIndex((i));
		}

		List<WebElement> checkBox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (WebElement check : checkBox) {
			Thread.sleep(1000);
			check.click();

		}

		List<WebElement> radioButton = driver.findElements(By.xpath("//input[@type='radio']"));

		for (WebElement circle : radioButton) {
			Thread.sleep(1000);
			circle.click();
		}
	}
}