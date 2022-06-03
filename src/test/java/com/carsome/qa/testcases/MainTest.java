package com.carsome.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.carsome.qa.base.TestBase;
import com.carsome.qa.pages.PeroduaSearchPage;
import com.carsome.qa.pages.HomePage;

public class MainTest extends TestBase {
	public PeroduaSearchPage Peroduasearchpage;
	public HomePage homePage;

	String homeurl = prop.getProperty("url");

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser
	// @test -- execute test case
	// after each test case -- close the browser
	public MainTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
		initialization();
		setUrl(homeurl);
		homePage = new HomePage();
	}

// TestCase1 
	@Test
	public void GetSearcCountPerAxia() {
		String homePageTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "Carsome - #1 Online Used Cars Buying & Selling Platform");
		System.out.println("HomePage Loaded: Passed");
		Peroduasearchpage = homePage.gotosearchpage();
		Peroduasearchpage.validateSearchCount();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement Srchcout = driver.findElement(By.xpath("//*[@id=\"page-list\"]/div[3]/div[2]/div[1]/div/div[1]"));
		Assert.assertEquals(Srchcout.getText(), "175 result(s)");
// TestCase 2
		Peroduasearchpage.sortLowtoHigh();

	}

	@AfterClass
	public void tearDown() {
		 driver.quit();
	}

}
