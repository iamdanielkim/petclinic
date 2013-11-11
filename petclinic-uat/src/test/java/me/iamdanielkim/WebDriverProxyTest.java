package me.iamdanielkim;

import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static org.junit.Assert.assertEquals;

/**
 * Simple {@link RemoteWebDriver} test that demonstrates how to run your
 * Selenium tests with <a href="http://saucelabs.com/ondemand">Sauce
 * OnDemand</a>. *
 * 
 * @author Ross Rowe
 */
@Ignore
public class WebDriverProxyTest {

	private static final String SAUCE_PROXY_URL = "http://iamdanielkim:3b12cec0-0058-42d5-a79d-d56a834e8d22@localhost:4445/wd/hub";
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {

		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("version", "17");
		capabilities.setCapability("platform", Platform.XP);
		this.driver = new RemoteWebDriver(new URL(SAUCE_PROXY_URL), capabilities);
	}

	@Test
	@Ignore
	public void goPetClinic() throws Exception {
		driver.get("http://127.0.0.1:8081/petclinic/");
		assertEquals("PetClinic :: a Spring Framework demonstration",
				driver.getTitle());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
