package Screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjects {

	protected WebDriver driver;
	   
	public void PageObject(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
