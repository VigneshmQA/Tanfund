package com.qa.tf_scst.test;

import com.qa.base.BaseTest;
import com.qa.tf_scst.Pages.TFLoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginpageTest extends BaseTest {

    @Test
    public void testValidLoginAndLogout() {
    	TFLoginPage loginPage = new TFLoginPage(page);
        loginPage.navigateToLoginPage("http://startuptn-tanfund-qa2.s3-website.ap-south-1.amazonaws.com/");
        loginPage.clickLogin();
        loginPage.enterUsername("ramstartuptn.in");
        loginPage.enterPassword("Test@123");
        loginPage.signin();

        String title = loginPage.getPageTitle();
        System.out.println("Page title after login: " + title);

        // Sample assertion
        Assert.assertTrue(title.contains("Dashboard") || title.contains("Home"), "Login might have failed");
    }
}
