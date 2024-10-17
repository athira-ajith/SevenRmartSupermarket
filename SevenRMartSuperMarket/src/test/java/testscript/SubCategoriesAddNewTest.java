package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.SubCategoriesAddNewPage;

public class SubCategoriesAddNewTest extends Base {
	HomePage homepage;
	SubCategoriesAddNewPage addSubCategoriesPage;

	@Test(retryAnalyzer=retry.Retry.class)
	@Parameters({ "username", "password", "imagePath","categoryToSelect","subCategory"}) // Added imagePath as parameter
	public void verifyAddingNewSubCategoryWithValidDetails(String username, String password, String imagePath,String categoryToSelect,String subCategory)
			throws IOException, AWTException {

		// Login actions
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserNameField(username).enterPasswordField(password);
		homepage = loginpage.clickSignInButton();

		// Navigate to SubCategories page
		
		addSubCategoriesPage = homepage.clickSubCategory();

		// Add new sub-category with valid details
		addSubCategoriesPage.clickAddNewButton().selectCategory(categoryToSelect) 
				.enterSubCategory(subCategory) // You can make this dynamic as well
				.chooseFile(imagePath) // Use the image path from XML parameter
				.clickSaveButton();
	}
}
