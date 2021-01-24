package com.facebook.qe.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.facebook.qe.base.BaseTest;
import com.facebook.qe.jira.JiraPolicy;
import com.facebook.qe.page.HomePage;
import com.facebook.qe.page.LoginPage;


public class LoginPageTest extends BaseTest {

	@JiraPolicy(logTicketReady=false)
	@Test(priority=1, enabled=true)
	public void verifyLoginPageTitle() {
		Boolean actualResult = page.getInstance(LoginPage.class).loginHeaderTitle();
		System.out.println("Am I on Login Page ?: "+actualResult);
		Assert.assertTrue(actualResult, "Facebook - Log In or Sign Up");
	}
	
	@JiraPolicy(logTicketReady=false)
	@Test(priority=2, enabled=true)
	public void doLogin() {
		page.getInstance(LoginPage.class).doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Boolean actualResult = page.getInstance(HomePage.class).homeHeaderTitle();
		System.out.println("Am I on Home Page ?: "+actualResult);
		Assert.assertTrue(actualResult, "(2) Facebook");
	}
}


