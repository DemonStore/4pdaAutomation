package by.bsu.mmf.web.losdy.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DevdbSearchPage extends AbstractPage
{
	private final Logger logger = Logger.getLogger(LoginPage.class);
	private String searchtUrl;

	@FindBy(css = ".find-items li:first-child .name a")
	private WebElement firstResult;

	public DevdbSearchPage(WebDriver driver, String searchUrl)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
		this.searchtUrl = searchUrl;
	}

	public String getFirstResult()
	{
		return firstResult.getText();
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(searchtUrl);
		logger.info(searchtUrl + " opened");
	}
}
