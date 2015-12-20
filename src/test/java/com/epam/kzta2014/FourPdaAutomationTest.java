package com.epam.kzta2014;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.kzta2014.steps.Steps;

public class FourPdaAutomationTest
{
	private Steps steps;
	private final String USERNAME = "tempBsu";
	private final String PASSWORD = "Waizh5tadV";

	private final String MESSAGE = "ќжидайте письмо со ссылкой";

	@BeforeMethod(description = "Init browser")
	public void setUp()
	{
		steps = new Steps();
		steps.initBrowser();
	}

	@Test(description = "Login to 4pda")
	public void oneCanLoginWithoutCapcha()
	{
		steps.loginWihoutCapcha(USERNAME, PASSWORD);
		Assert.assertTrue(steps.isLoggedWithoutCapcha(MESSAGE));
	}

//	@Test
//	public void oneGuestCanCommentPost()
//	{
//		steps.loginWihoutCapcha(USERNAME, PASSWORD);
//		Assert.assertTrue(steps.createNewRepository("testRepo", "auto-generated test repo"));
//		Assert.assertTrue(steps.currentRepositoryIsEmpty());
//		// do not use lots of asserts
//	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser()
	{
		steps.closeDriver();
	}

}
