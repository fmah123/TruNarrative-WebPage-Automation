package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * <h1>Google Search Page Object Class</h1>
 * This class contains methods relating to scenario involving google search for TruNarrative web link.
 *
 * @author Mohammed Fidaa Ul Mahboob
 * @version 1.0
 * @since 2019-08-27*/

public class GoogleSearchPage extends BasePage{

    public GoogleSearchPage(WebDriver driver){
        super(driver);
    }

    private static final By SEARCH_BOX = By.cssSelector("input.gLFyf");
    private static final By GOOGLE_SEARCH_BUTTON = By.cssSelector("input.gNO89b:nth-child(1)");

    /**
     * This method navigates to google home page.
     * */
    public void GoToGoogleHomePage(){
        driver.navigate().to("http://www.google.com");
    }

    /**
     * This method is used to enter text into search box and click search button. This has been used to do a google search for "TruNarrative".
     * @param input A search string to be used by the google search engine.
     * */
    public void ClickAndTypeInToSearchBox(String input){
        FindAndType(input, SEARCH_BOX);
        WaitAndClick(GOOGLE_SEARCH_BUTTON);
    }

    /**
     * This method is used to identify if TruNarrative is the first search result on google search page.
     * @param searchName The value of the search result name. */
    public void VerifyTruNarrativeWebsiteAsFirstSearchResult(String searchName) {
        try{
            List<WebElement> searchElement = driver.findElements(By.cssSelector("h3"));
            int count = 0; //checks the search rank number
            for(WebElement element: searchElement){
                if(element.getText().trim().equals(searchName) && count == 0){
                    return;
                }
                count++;
            }
            Assert.fail();
        } catch (AssertionError e){
            System.out.println("TruNarrative is not the first search result." +
                    "\nAssertionError: " + e.getMessage());
        }
    }

    /**
     * This method verifies if TruNarrative web search result has the correct page link.
     * */
    public void VerifyTruNarrativeWebsiteLink(String link){
        try{
            List<WebElement> searchElement = driver.findElements(By.cssSelector("cite"));
            for(WebElement element: searchElement){
                if(element.getText().trim().equals(link)){
                    return;
                }
            }
            Assert.fail();
        } catch (AssertionError e){
            System.out.println("TruNarrative link is not associated with the TruNarrative search result in" +
                    "\nAssertionError: " + e.getMessage());
        }

    }



}
