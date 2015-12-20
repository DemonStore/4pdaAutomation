package by.bsu.mmf.web.losdy.steps;

import java.util.concurrent.TimeUnit;

import by.bsu.mmf.web.losdy.pages.CreateNewRepositoryPage;
import by.bsu.mmf.web.losdy.pages.LoginPage;
import by.bsu.mmf.web.losdy.pages.PostPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import by.bsu.mmf.web.losdy.pages.MainPage;

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

		return lastComment == comment;
	}

	public boolean currentRepositoryIsEmpty()
	{
		CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
		return createNewRepositoryPage.isCurrentRepositoryEmpty();
	}

}
