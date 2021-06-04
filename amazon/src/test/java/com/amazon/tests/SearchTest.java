package com.amazon.tests;

import com.amazon.data.DataProvidersForTest;
import com.amazon.pages.HomePage;
import com.pnt.base.TestBase;
import com.pnt.base.report.ExtentTestManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SearchTest  extends TestBase {

    private static Logger LOGGER = Logger.getLogger(SearchTest.class);
@Test (enabled=false) // tomorrow hw : to move all tour exiting test cases
    public void validateUserBeingAbleToSearchForAnItem () {
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java Books");
    ExtentTestManager.log("Java Books typed in the search bar", LOGGER);

    driver.findElement(By.id("nav-search-submit-button")).click();
    ExtentTestManager.log("Clicked on the search button", LOGGER);

}
@Test(enabled = false) // net week hw : to move all your existing test cases to  use page object Model
public void validateUserBeingAbleToSearchForJavaBooks() {
    HomePage homePage = PageFactory.initElements(driver,HomePage.class);
    homePage.typeOnSearchBar("Java Books");
    ExtentTestManager.log("Java Books typed in the search bar", LOGGER);

    homePage.clickOnSearchButton();
    ExtentTestManager.log("Clicked on the search button", LOGGER);
}
   //dataprovider

    @Test(dataProviderClass = DataProvidersForTest.class,dataProvider ="getDataForSearchData" )
    public void validateUserBeingAbleToSearchForSeleniumBooks(String bookName) {
        HomePage homePage = PageFactory.initElements(driver,HomePage.class);
        homePage.typeOnSearchBar(bookName);
        ExtentTestManager.log(bookName+ " typed in the search bar", LOGGER);

        homePage.clickOnSearchButton();
        ExtentTestManager.log("Clicked on the search button", LOGGER);
    }


}
