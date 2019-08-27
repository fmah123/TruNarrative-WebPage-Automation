package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * <h1>Team Page Object Class</h1>
 * This is the class tht manages methods that relate to the TruNarrative team page.
 *
 * @author Mohammed Fidaa Ul Mahboob
 * @version 1.0
 * @since 2019-08-27
 * */

public class TeamPage extends BasePage {

    public TeamPage(WebDriver driver){
        super(driver);
    }

    private static final By MENU_OPTIONS = By.cssSelector("li#menu-item-6055 a");
    private static final By SUBMENU_OPTIONS = By.cssSelector("a[href*=meet-the-team]");

    /**
     * This will navigate to the TruNarrative home page.
     */
    public void GoToHomePage(){
        driver.navigate().to("https://www.trunarrative.com/");
    }

    /**
     * This will navigate to the TruNarrative team page.
     */
    public void GoToTeamPage(){
        driver.navigate().to("https://www.trunarrative.com/about-us/meet-the-team/");
    }

    /**
     * The objective of this methods is to navigate to the team page by accessing the submenu option via TruNarrative website dropdown menu.
     */
    public void SelectTruNarrativeTeamOptionInSubMenu(){
        HooverAndClick(MENU_OPTIONS, SUBMENU_OPTIONS);
    }

    /**
     * This method will identify if a specific TruNarrative leadership team member has correct role assigned to his/her name.
     * @param name
     * @param role
     */
    public void VerifyNameAndRoleOfThreeMembersOfLeadershipTeam(String name, String role){
        List<WebElement> element = driver.findElements(By.cssSelector("div.content:nth-child(1)"));
        TeamPage.getText txt;
        for(int i = 1; i < element.size(); i++){
            txt = new getText(element.get(i));
            if(txt.getNameTxt().equals(name) && txt.getRoleTxt().equals(role)){
                return;
            }
        }
        Assert.fail();
    }


    /**
     * This method confirms if there are eight members of team or not.
     * */
    public int ConfirmEightMembersOfLeadershipTeam(){
        List<WebElement> elementList = driver.findElements(By.cssSelector("p.sub"));
        int count = 0; //counter to get the number of members in the team.
        for(WebElement element: elementList){
            count++;
        }

        return count;
    }

    public class getText{
        private WebElement element;

        public getText(WebElement element) {
            this.element = element;
        }

        public String getNameTxt(){
            return element.findElement(By.tagName("h2")).getText().trim();
        }

        public String getRoleTxt(){
            return element.findElement(By.cssSelector("p.sub")).getText().trim();
        }
    }

}
