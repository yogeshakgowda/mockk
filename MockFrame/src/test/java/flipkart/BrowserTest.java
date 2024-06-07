package flipkart;

import org.testng.annotations.Test;

import commclass.BrowsserBaseclass;

public class BrowserTest extends BrowsserBaseclass
{
@Test
public void Scriptbrowser()
{
	driver.get("https://www.facebook.com/");
	System.out.println(driver.getTitle());
}
}
