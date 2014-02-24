package me.iamdanielkim;

import static org.junit.Assert.assertEquals;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Simple {@link RemoteWebDriver} test that demonstrates how to run your
 * Selenium tests with <a href="http://saucelabs.com/ondemand">Sauce
 * OnDemand</a>. *
 * 
 * @author Ross Rowe
 */
public class WebDriverTest {

	private static final String SAUCELAB_URL = "http://iamdanielkim:3b12cec0-0058-42d5-a79d-d56a834e8d22@ondemand.saucelabs.com:80/wd/hub";
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {

		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("version", "17");
		capabilities.setCapability("platform", Platform.XP);
		this.driver = new RemoteWebDriver(new URL(SAUCELAB_URL),
				capabilities);
	}

	@Test
	public void webDriver() throws Exception {
		driver.get("http://www.amazon.com/");
		assertEquals(
				"Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more",
				driver.getTitle());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
