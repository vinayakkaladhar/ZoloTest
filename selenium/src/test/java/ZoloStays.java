import POM.GoogleSearchPage;
import Utilities.SearchParametersDataProvider;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import org.testng.Reporter;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

@Listeners(Utilities.ListenerTest.class)

public class ZoloStays extends GoogleSearchPage {
    public GoogleSearchPage googleSearchPage;
    boolean result;

    @BeforeMethod
    public void setUp() {
        driver = getDriver();
        googleSearchPage = new GoogleSearchPage();

    }

    @Test(description = "Verify search results in google based on the inputs" , dataProviderClass = SearchParametersDataProvider.class,dataProvider = "searchCombinations")
    public void testTheSearchResults(String searchKeyword, int autoSuggestion, int linkNumber ,int pageNumber ,int linkNumberAfterPageChanged) throws InterruptedException, IOException, InvalidFormatException {
        googleSearchPage.Login("https://www.google.co.in/");
        Reporter.log("Navigated to Google.com");
        googleSearchPage.enterInput(searchKeyword);
        result = googleSearchPage.selectAutoSuggestion(autoSuggestion,searchKeyword);
        Assert.assertTrue(result, String.format("Expected count %s of auto suggestions is not displayed",autoSuggestion));
        Reporter.log("Initiated search for: " + searchKeyword + " Clicked on the suggestion number: " + autoSuggestion);
        result = result && googleSearchPage.selectSpecificLink(linkNumber,searchKeyword);
        Reporter.log("Suggested link: " + linkNumber + " clicked");
        driver.navigate().back();
        result = result && googleSearchPage.switchToPage(linkNumber);
        Assert.assertTrue(result, String.format("Expected page: %s is not available",autoSuggestion));
        Reporter.log("Switched to page number: " + pageNumber);
        result = result && googleSearchPage.selectSpecificLink(linkNumberAfterPageChanged,searchKeyword);
        Reporter.log("Suggested link: " + linkNumberAfterPageChanged + " clicked");
        Assert.assertTrue(result, "Verified search results");
    }

}