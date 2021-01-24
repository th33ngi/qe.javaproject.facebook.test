package com.facebook.qe.utility;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.facebook.qe.base.BasePage;


public class WebElements extends BasePage{

	public WebElements(WebDriver driver) {
		super(driver);
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public void sendKeys(By locator, String text) {
		driver.findElement(locator).sendKeys(text);
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	public List<WebElement> findElements(By locator){
		List<WebElement> element = driver.findElements(locator);
		return element;	
	}
	
	public Boolean waitForElementBoolean(By locator, String text, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.textToBe(locator, text));
	}
	
	public String waitForElementString(By locator, String text, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.textToBe(locator, text));
		return text;
	}
	
	public void waitForElementToBeClickable(By locator, String text, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime))
				.ignoring(NoSuchElementException.class);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
}
