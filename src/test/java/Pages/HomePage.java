package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * <h1>Home Page Object Class</h1>
 * This class has methods that are associated to the home page.
 *
 * @author Mohammed Fidaa Ul Mahboob
 * @version 1.0
 * @since 2019-08-27
 *
 * */

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);
    }

    private static final By TRU_NARRATIVE_LINK = By.cssSelector("h3.LC20lb div.ellip");

    /**
     * This method navigates to the TruNarrative home page.
     * */
    public void GoToTruNarrativeHomePage(){
        driver.navigate().to("https://www.google.co.uk/search?hl=en&source=hp&ei=OKNjXaD5MrSK1fAPwKaHoAM&q=trunarrative&oq=truna&gs_l=psy-ab.3.0.0l5j0i10j0l3j0i10.822371.823022..824002...0.0..0.156.454.5j1......0....1..gws-wiz.....0..0i131.jsYnbauTO1Y");
        IdentifyAndClick(TRU_NARRATIVE_LINK, "TruNarrative");
    }

    /**
     * This method is used to aid in the extraction of strap line message from the home page.
     * */
    public Confirmation getStrapLineMsg(){
        return new Confirmation(driver.findElement(By.cssSelector("section.breakout.group.home-banner")));
    }

    public class Confirmation{
        private final WebElement element;

        public Confirmation(WebElement element){
            this.element= element;
        }

        public String getMsg(){
            return element.findElement(By.cssSelector("h4.bigger")).getText().trim();
        }

    }
}
