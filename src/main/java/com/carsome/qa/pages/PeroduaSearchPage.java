package com.carsome.qa.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.carsome.qa.base.TestBase;

public class PeroduaSearchPage extends TestBase {
	// Page Factory -OR
	@FindBy(id = "input-54")
	@CacheLookup
	public WebElement searchfield;
	@FindBy(xpath = "//*[@id=\"list-item-468-0\"]/div/div/span")
	@CacheLookup
	public WebElement peroduaaxia;

	@FindBy(xpath = "//*[@id=\"page-list\"]/div[3]/div[2]/div[1]/div/div[2]/div/div[1]/div[1]/div[1]/div[2]/div/i")
	@CacheLookup
	public WebElement RecommentSelection;
	@FindBy(xpath = "//*[@id=\"page-list\"]/div[3]/div[2]/div[2]/div/div[1]/article/div/div/div[4]/div[1]/strong")
	@CacheLookup
	public WebElement lowestprice1;
	@FindBy(xpath = "//*[@id=\"page-list\"]/div[3]/div[2]/div[2]/div/div[2]/article/div/div/div[4]/div[1]/strong")
	@CacheLookup
	public WebElement lowestprice2;
	// *[@id="input-65"]

	// Initializing the Page Objects:
	public PeroduaSearchPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public void validateSearchCount() {
		searchfield.sendKeys(" Perodua Axia" + "\n");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public void sortLowtoHigh() {
		RecommentSelection.click();
		List<WebElement> options = driver.findElements(By.cssSelector("div#list-65[role='listbox']"));
		for (WebElement option : options) {
			if (option.getText().trim().contains("Lowest Price")) {
				System.out.println(option.getText());
				option.click();
				driver.get("https://www.carsome.my/buy-car/perodua/axia?sortKey=2");
			}
		}
		String Pri1 = lowestprice1.getText();
		Pri1 = Pri1.replaceAll(",", "");
		String Pri2 = lowestprice2.getText();
		Pri2 = Pri2.replaceAll(",", "");

		Integer Price1 = Integer.valueOf(Pri1);
		Integer Price2 = Integer.valueOf(Pri2);
		if (Price2 > Price1) {
			System.out.println("Sort Works great: Listing displays Low price to High price");
		} else
			System.out.println("Sort seems to be incorrect,Kindly validate");

	}

}
