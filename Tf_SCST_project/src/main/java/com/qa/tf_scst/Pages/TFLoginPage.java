package com.qa.tf_scst.Pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TFLoginPage {

	private Page page;

	// Locators
	private String usernameField = "Enter Username / Email"; // Replace with actual locator
	private String passwordField = "Enter Password"; // Replace with actual locator
	private String loginButton = "Login"; // Replace with actual locator
	private String signin = "Sign In";

	// Constructor
	public TFLoginPage(Page page) {
		this.page = page;
	}

	// Actions
	public void navigateToLoginPage(String url) {
		page.navigate(url);
	}
	
	public void signin() {
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(signin)).click();
	}

	public void enterUsername(String username) {
//		page.locator(username).click();
//		page.locator(usernameField).fill(username);
		page.locator(usernameField).waitFor(new Locator.WaitForOptions().setTimeout(5000));
	    page.locator(usernameField).fill(username);
	}

	public void enterPassword(String password) {
		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(passwordField)).click();
		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(passwordField)).fill(password);
	}

	public void clickLogin() {
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(loginButton)).nth(1).click();
	}

	public String getPageTitle() {
		return page.title();
	}
}
