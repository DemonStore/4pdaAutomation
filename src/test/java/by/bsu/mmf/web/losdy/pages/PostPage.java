package by.bsu.mmf.web.losdy.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PostPage extends AbstractPage
{
	private final Logger logger = Logger.getLogger(LoginPage.class);
	private String postUrl;

	@FindBy(css = "textarea[name=comment]")
	private WebElement commentTextArea;

	@FindBy(css = ".comment-form button[type=submit]")
	private WebElement buttonSubmit;

	@FindBy(css = ".comment-list li:last-child .content")
	private WebElement lastComment;

	public PostPage(WebDriver driver, String postUrl)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
		this.postUrl = postUrl;
	}

	public void publishComment(String comment)
	{
		commentTextArea.sendKeys(comment);
		buttonSubmit.click();
	}

	public String getLastComment()
	{
		return lastComment.getText();
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(postUrl);
		logger.info(postUrl + " opened");
	}
}
