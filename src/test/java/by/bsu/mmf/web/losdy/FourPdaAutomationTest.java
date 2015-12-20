package by.bsu.mmf.web.losdy;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.bsu.mmf.web.losdy.steps.Steps;

public class FourPdaAutomationTest
{
	private Steps steps;
	private final String USERNAME = "tempBsu";
	private final String PASSWORD = "Waizh5tadV";

	private final String MESSAGE = "ќжидайте письмо со ссылкой";
	private final String COMMENT = "Hello, 4pda!";
	private final String QUERY = "Google Nexus 5";

	@BeforeMethod(description = "Init browser")
	public void setUp()
	{
		steps = new Steps();
		steps.initBrowser();
	}

//	@Test(description = "Login to 4pda")
//	public void oneCanLoginWithoutCapcha()
//	{
//		steps.loginWihoutCapcha(USERNAME, PASSWORD);
//		Assert.assertTrue(steps.isLoggedWithoutCapcha(MESSAGE));
//	}
//
//	@Test
//	public void oneGuestCanCommentPost()
//	{
//		Assert.assertTrue(steps.guestComment(COMMENT));
//	}

//	@Test
//	public void oneCanFindInDevdb()
//	{
//		Assert.assertTrue(steps.searchInDevdb(QUERY));
//	}

    @Test
    public void oneCanTakePartInSurvey()
    {
        Assert.assertTrue(steps.takePartInSurvey());
    }

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser()
	{
		steps.closeDriver();
	}

}
