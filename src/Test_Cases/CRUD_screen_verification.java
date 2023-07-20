package Test_Cases;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.RemoteWebDriver;

import Base_Scripts.WebDriverControl;
import Screens.CRUD_Screen;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

public class CRUD_screen_verification {

protected WebDriver driver;
	
	private CRUD_Screen crudpage;
	

	@BeforeClass(alwaysRun = true)
	public void setUp() {

		RemoteWebDriver driver = WebDriverControl.getDriver();

		crudpage = PageFactory.initElements(driver, CRUD_Screen.class);
}
	
	@SuppressWarnings("static-access")
	@Test(groups = "CRUD_Screen")
	public void verifyHomePage() throws InterruptedException {
		crudpage.ClickViewIronman();
		crudpage.ClickDeleteBookroom();
}
}
