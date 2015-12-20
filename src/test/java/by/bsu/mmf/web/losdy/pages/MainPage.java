package by.bsu.mmf.web.losdy.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage
{
	private final Logger logger = Logger.getLogger(LoginPage.class);
	private final String BASE_URL = "http://4pda.ru/";

	@FindBy(css = "article.post:first-child .list-post-title a")
	private WebElement firstPostLink;

	public MainPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public String getLinkForFirstPost()
	{
		return firstPostLink.getAttribute("href");
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
		logger.info("Main page opened");
	}
}
