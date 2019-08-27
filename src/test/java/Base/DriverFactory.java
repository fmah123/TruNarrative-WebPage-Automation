package Base;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * <h1>Driver Factory Class</h1>
 * This class is used for the setting up of the webDriver instance. This class allows the auto-management of the ChromeDriver.
 * <p>
 * <b>Note:</b> This class should not be modified.
 */

public class DriverFactory {

    public WebDriver driver;

    static {
        ChromeDriverManager.chromedriver().setup();
    }

    public WebDriver getDriver() {
        if(driver == null){
            setDriver();
        }
        return driver;
    }

    private void setDriver(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
}
