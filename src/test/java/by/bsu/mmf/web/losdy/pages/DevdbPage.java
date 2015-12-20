package by.bsu.mmf.web.losdy.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DevdbPage extends AbstractPage
{
	private final Logger logger = Logger.getLogger(LoginPage.class);
	private final String BASE_URL = "http://4pda.ru/devdb/";

	@FindBy(css = ".holder-no-hidden .search-form input[type=text]")
	private WebElement inputSearch;

	@FindBy(css = ".holder-no-hidden .search-form input[type=submit]")
	private WebElement submitSearch;

	public DevdbPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public String submitSearchForm(String query)
	{
		inputSearch.sendKeys(query);
		submitSearch.click();
		return driver.getCurrentUrl();
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
		logger.info("DevDB page opened");
	}
}
