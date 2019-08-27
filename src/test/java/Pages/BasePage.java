package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * <h1>Base Page Object Class</h1>
 * This class is the base for all page object classes, and is where all generic methods common to all page objects are contained.
 *
 * @author Mohammed Fidaa Ul Mahboob
 * @version 1.0
 * @since 2019-08-27
 */

public class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    /**
     * This method waits for a period of 30 seconds to allow an element to become visible before clicking the element.
     * @param Selector A css or Xpath selector specific to a clickable element (e.g.button) can be used.
     */
    public void WaitAndClick(By Selector){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(Selector));
        element.click();
    }

    /**
     * This method finds an entry box by selector and send strings to that entry box.
     * @param input This is the string that needs to be entered.
     * @param Selector This is a selector/Xpath specific to an entry box
     */
    public void FindAndType(String input, By Selector){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(Selector));
        element.sendKeys(input);
    }

    /**
     * This method allows hoover and clicking of an element like a submenu of a dropdown list menu.
     * @param Selector_Menu The selector/Xpath of the dropdown menu button.
     * @param Selector_Option The selector/Xpath of the submenu button.
     */

    public void HooverAndClick(By Selector_Menu, By Selector_Option){
        WebElement element_menu = wait.until(ExpectedConditions.presenceOfElementLocated(Selector_Menu));
        WebElement element_option = wait.until(ExpectedConditions.presenceOfElementLocated(Selector_Option));
        Actions action = new Actions(driver);
        action.moveToElement(element_menu).click(element_option).build().perform();

    }

    /**
     * This method allows a search link from search page like google be identified and clicked
     * @param Selector A selector/Xpath for a link page text.
     * @param name A name specific to the link text of interest.
     */
    public void IdentifyAndClick(By Selector, String name){
        try{
            List<WebElement> elementList = driver.findElements(Selector);
            for(WebElement element: elementList){
                if(element.getText().trim().equals(name)){
                    WaitAndClick(Selector);
                    return;
                }
            }
        }catch (ElementNotVisibleException e){
            System.out.println("Web element not found or incorrect name specified for element.");
        }

    }
}
