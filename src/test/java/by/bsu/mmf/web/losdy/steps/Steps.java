package by.bsu.mmf.web.losdy.steps;

import java.util.concurrent.TimeUnit;

import by.bsu.mmf.web.losdy.pages.*;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import sun.applet.Main;

public class Steps
{
	private WebDriver driver;

	private final Logger logger = Logger.getLogger(Steps.class);

	public void initBrowser()
	{
		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		logger.info("Browser Firefox started");
	}

	public void closeDriver()
	{
		driver.quit();
	}

	public void loginWihoutCapcha(String username, String password)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(username, password);
	}

	public boolean isLoggedWithoutCapcha(String message)
	{
		LoginPage loginPage = new LoginPage(driver);
		return (loginPage.getMessage().trim().equals(message));
	}

	public boolean guestComment(String comment)
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		String postUrl = mainPage.getLinkForFirstPost();

		PostPage postPage = new PostPage(driver, postUrl);
		postPage.openPage();
		postPage.publishComment(comment);
		String lastComment = postPage.getLastComment();

		return lastComment.equals(comment);
	}

	public boolean searchInDevdb(String query)
	{
		DevdbPage devdbPage = new DevdbPage(driver);
		devdbPage.openPage();
		devdbPage.submitSearchForm(query);

		WebElement firstResult = driver.findElement(By.cssSelector(".find-items li:first-child .name a"));

		return query.equals(firstResult.getText());
	}

	public boolean takePartInSurvey()
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		mainPage.submitFirstOptionOfPoll();

		WebElement slider = driver.findElement(By.cssSelector(".poll-list .slider"));
		return slider != null;
	}

	public boolean searchNews(String newsName)
	{
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		mainPage.submitSearchForm(newsName);

		WebElement firstResult = driver.findElement(By.cssSelector(".search-list li:first-child h1 a"));

		return firstResult.getText().equals(newsName);
	}

}
