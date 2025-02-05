package testscript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsAdd;
import pages.ManageUsersSearchPage;
import utilities.ExcelUtilities;

public class ManageUsersSearchTest extends Base {
	HomePage homepage;
	ManageNewsAdd managenewsaddpage;
	ManageUsersSearchPage manageSearch;

	@Test
	@Parameters({ "username", "password", "newsTitle" })
	public void verifySearchingAValidNews(String username, String Password, String newsTitle) throws IOException {
		// Log in
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameField(username).enterPasswordField(Password);
		homepage = loginPage.clickSignInButton();
		managenewsaddpage = homepage.clickManageNews();
		manageSearch = homepage.clickSearchButton();
		manageSearch.enterNewsTitle(newsTitle);
		manageSearch.clickSearchButton2();
		boolean isSearchFound = manageSearch.searchNewsTitle(newsTitle);
		assertTrue(isSearchFound, Constants.NOMATCHFOUND);
	}

}
