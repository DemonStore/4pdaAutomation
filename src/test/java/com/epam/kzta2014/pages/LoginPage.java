package com.epam.kzta2014.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage
{
	private final Logger logger = Logger.getLogger(LoginPage.class);
	private final String BASE_URL = "http://4pda.ru/forum/index.php?act=login&CODE=00&return=http%3A%2F%2F4pda.ru%2F";

	@FindBy(name = "UserName")
	private WebElement inputLogin;

	@FindBy(name = "PassWord")
	private WebElement inputPassword;

	@FindBy(name = "cap_skip")
	private WebElement checkBox;

	@FindBy(xpath = "//input[@value='Войти!']")
	private WebElement buttonSubmit;

	@FindBy(className = "formsubtitle")
	private WebElement message;

	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
		logger.info("Login page opened");
	}

	public void login(String username, String password)
	{
		inputLogin.sendKeys(username);
		inputPassword.sendKeys(password);
		checkBox.click();
		buttonSubmit.click();
		logger.info("Login performed");
	}

	public String getMessage()
	{
		return message.getText();
	}

}
