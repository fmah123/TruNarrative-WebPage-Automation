package Steps;

import Base.DriverFactory;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
/**
 * <h1>Hooks Class</h1>
 *
 * The methods contained in this class manage the WebDriver to implement tests.
 *
 * <p>
 *
 *     <b>Note:</b> Do not modify this class.
 *
 * @author Mohammed Fidaa Ul Mahboob
 * @version 1.0
 * @since 2019-08-27
 *
 * */
public class Hooks {

    private DriverFactory driverFactory;
    private WebDriver driver;

    public Hooks(DriverFactory driverFactory){
        this.driverFactory = driverFactory;
    }


    /**
     * This method initialises the WebDriver instance variable and sets implicit waiting times for the webDriver instance.
     */
    @Before
    public void InitialiseTest(){
        driver = driverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    /**
     * This method closes the driver instance after the test has completed.
     **/
    @After
    public void TearDownTest(){
        driver.quit();
    }
}
