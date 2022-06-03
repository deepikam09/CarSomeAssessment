package com.carsome.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.carsome.qa.base.TestBase;

public class HomePage extends TestBase {
//Page Factory -OR
	@FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/dl/dd[1]/ul/li[1]/div/span/span")
	@CacheLookup
	public WebElement BuyCar;
	@FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div[2]/div[1]/dl/dd[1]/ul/li[1]/div/div/div[16]")
	@CacheLookup
	public WebElement peroduaselection;
	
	

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateHomePageTitle() {
		return driver.getTitle();
	}

	public PeroduaSearchPage gotosearchpage() {
		BuyCar.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		peroduaselection.click();
		return new PeroduaSearchPage();

	}

}
