package Screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRUD_Screen extends PageObjects {

	private final String DeleteButton = "/html/body/div[1]/div[2]/div/div/div/div[7]/div[4]/a"; 
	@FindBy(xpath = DeleteButton)
	private WebElement DeleteBookroom;
	
	private final String YesPopButton = "//*[@id=\"myModal\"]/div/div/div[2]/form/div/div/div/div[1]/button"; 
	@FindBy(xpath = YesPopButton)
	private WebElement YesButton;
	
	private final String ViewButton = "/html/body/div[1]/div[2]/div/div/div/div[5]/div[2]/a"; 
	@FindBy(xpath = ViewButton)
	private WebElement ViewIronmanButton;
	
	private final String Viewtext = "//*[@id=\\\"myModal\\\"]/div/div/div[2]/div[1]/div"; 
	@FindBy(xpath = Viewtext)
	private WebElement ViewIronmantext;

	
	public CRUD_Screen(WebDriver driver) {
		super(driver);
}
public void ClickDeleteBookroom(){
		
 		this.DeleteBookroom.click();
 		this.YesButton.click();


 	    }

public void ClickViewIronman(){
	
		this.ViewIronmanButton.click();
		
        // Get the text from the element
        String actualText = ViewIronmantext.getText();

        // Expected text that you want to verify
        String expectedText = "Iron man";

        // Use TestNG assertion to verify the text
        Assert.assertEquals(actualText, expectedText, "Text verification failed!");


	    }
}
