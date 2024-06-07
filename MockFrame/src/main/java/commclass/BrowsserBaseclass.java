package commclass;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BrowsserBaseclass {
	public WebDriver driver;
    static WebDriver sdriver;
    public GestureUtlis gutlis;
    public AndroidDriverUtils Adutlis;
    public FileUtility futlis=new FileUtility();
    public PomPage.flipkartjava flip;
  
    @BeforeClass
    public void startApp() throws IOException
    {
    	
    	
    	String username = futlis.readDataFromPropertyFile("username");
    	String password = futlis.readDataFromPropertyFile("password");
    	String device_name = futlis.readDataFromPropertyFile("device_name");
    	String browser = futlis.readDataFromPropertyFile("browser");
    	
    	
    	String url="https://"+username+":"+password+"@hub-cloud.browserstack.com/wd/hub";
    	
    	
    	MutableCapabilities capabilities = new MutableCapabilities();
    	HashMap<String, Object> browserstackOptions=new HashMap<String, Object>();
    	browserstackOptions.put("deviceName",device_name);
    	browserstackOptions.put("browser", browser);
    	capabilities.setCapability("bstack:options", browserstackOptions);
    	
    	driver=new RemoteWebDriver(new URL(url),capabilities);
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    
    @AfterClass
    public void closeApp()
    {
    	
    	driver.quit();
    	
    }
    
}
