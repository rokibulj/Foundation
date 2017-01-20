package base;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestBase extends Driver {

	@BeforeSuite
	public void setUp() {

		setDriver();
	}

	@Test
	public void dummyTest() {
		String pageUrl = driver.getCurrentUrl();
		Assert.assertEquals(pageUrl, "http://elitecareer.net/");
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
