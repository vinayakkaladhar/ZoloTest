package POM;

import Utilities.Utilities;
import org.asynchttpclient.uri.Uri;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import java.net.MalformedURLException;
import java.util.List;

public class GoogleSearchPage extends Utilities {

    public GoogleSearchPage() {
        driver = getDriver();
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = ".//input[@name='q']")
    public WebElement _inputData;


    public void Login(String url) throws InterruptedException {
        driver.get(url);
        Thread.sleep(2000);
    }

    public void enterInput(String searchText) throws InterruptedException {
        _inputData.sendKeys(searchText);
        //_submitButton.click();
        Utilities.takeScreenShot(driver,searchText);
    }

    public boolean selectAutoSuggestion(int resultNumber,String searchText) throws InterruptedException {
        List<WebElement> suggestions = driver.findElements(By.xpath(".//div/ul[@role='listbox']/li"));
        if(resultNumber > suggestions.size()){
           return false;
        }else{
            suggestions.get(resultNumber).click();
            Utilities.takeScreenShot(driver,searchText);
            return true;
        }
    }

    public boolean selectSpecificLink(int resultNumber,String searchText) throws InterruptedException {
        List<WebElement> suggestions = driver.findElements(By.xpath(".//div[@class='rc']//div[@class='r']/a"));
        List<WebElement> ads = driver.findElements(By.xpath(".//div[@class='xpdopen']//div[@class='rc']//div[@class='r']/a"));
        if(resultNumber > suggestions.size()){
            return false;
        }else{
            suggestions.get(ads.size() + resultNumber).click();
            if(!driver.getCurrentUrl().toLowerCase().contains("google")){
                Utilities.takeScreenShot(driver,searchText + resultNumber);
            }
            return true;
        }
    }

    public boolean switchToPage(int pageNumber) throws InterruptedException {
        if(pageNumber> 1){
            try{
                driver.findElement(By.xpath(String.format(".//div//tr/td/a[@aria-label='Page %s']",pageNumber))).click();
                explicitwait(String.format(".//div[@id='result-stats'][contains(text(),'Page %s')]",pageNumber));
            }catch (Exception e){
return false;
            }

        }
        return true;
    }

}
