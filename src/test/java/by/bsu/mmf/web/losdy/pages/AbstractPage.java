package by.bsu.mmf.web.losdy.pages;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage
{
	protected WebDriver driver;

	public abstract void openPage();

	public AbstractPage(WebDriver driver)
	{
		this.driver = driver;
	}
}
