package Steps;

import Base.DriverFactory;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import Pages.GoogleSearchPage;
import Pages.HomePage;
import Pages.TeamPage;

/**
 * This test script automates a user journey from searching on google ending at the leadership team page. The step methods in this class are glue code
 * for the scenario steps in the feature file.
 *
 * @author Mohammed Fidaa Ul Mahboob
 * @version 1.0
 * @since 2019-08-27
 * */

public class LoadUpSteps {


    private HomePage homePage;
    private GoogleSearchPage googleSearchPage;
    private TeamPage teamPage;

    private DriverFactory driverFactory;
    public LoadUpSteps(DriverFactory driverFactory){
        this.driverFactory = driverFactory;
    }

    @Given("^I navigate to google homepage$")
    public void iNavigateToGoogleHomepage() {
        googleSearchPage = new GoogleSearchPage(driverFactory.driver);
        googleSearchPage.GoToGoogleHomePage();
    }

    @When("^I enter key term \"([^\"]*)\" in the google search box$")
    public void iEnterKeyTermInTheGoogleSearchBox(String searchEntry) throws Throwable {
        googleSearchPage.ClickAndTypeInToSearchBox(searchEntry);
    }

    @Then("^I should see TruNarrative website as the first result$")
    public void iShouldSeeTruNarrativeWebsiteAsTheFirstResult() {
        googleSearchPage.VerifyTruNarrativeWebsiteAsFirstSearchResult("TruNarrative");
    }

    @And("^points to the TruNarrative website link \"([^\"]*)\"$")
    public void pointsToTheTruNarrativeWebsiteLink(String linkText) throws Throwable {
        googleSearchPage.VerifyTruNarrativeWebsiteLink(linkText);
    }


    @Given("^I navigate to the TruNarrative web page$")
    public void iNavigateToTheTruNarrativeWebPage() {
        homePage = new HomePage(driverFactory.driver);
        homePage.GoToTruNarrativeHomePage();
    }

    @Then("^I should see the TrueNarrative strap line \"([^\"]*)\"$")
    public void iShouldSeeTheTrueNarrativeStrapLine(String text) throws Throwable {
        HomePage.Confirmation confirmation = homePage.getStrapLineMsg();
        Assert.assertEquals(text, confirmation.getMsg());
    }

    @Given("^I am on the TruNarrative homepage$")
    public void iAmOnTheTruNarrativeHomepage() {
        teamPage = new TeamPage(driverFactory.driver);
        teamPage.GoToHomePage();
    }

    @When("^I navigate to the TruNarrative Team page$")
    public void iNavigateToTheTruNarrativeTeamPage() {
        teamPage.SelectTruNarrativeTeamOptionInSubMenu();
    }

    @Then("^I should see \"([^\"]*)\" as \"([^\"]*)\"$")
    public void iShouldSeeAs(String name, String role) throws Throwable {
        //If the subject of test namely the member of management team is added or changed, you can add or change on feature file
        //scenario without changing this method.
        teamPage.VerifyNameAndRoleOfThreeMembersOfLeadershipTeam(name, role);
    }

    @Given("^that I am on the TruNarrative team page$")
    public void thatIAmOnTheTruNarrativeTeamPage() {
        teamPage = new TeamPage(driverFactory.driver);
        teamPage.GoToTeamPage();
    }

    @Then("^I should see eight members of leadership team$")
    public void iShouldSeeEightMembersOfLeadershipTeam() {
        Assert.assertEquals("8", Integer.toString(teamPage.ConfirmEightMembersOfLeadershipTeam()));
    }



}
