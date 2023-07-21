# RoomracoonAssesment
Automation Explanation
The LaunchBrowser class:

It contains a method called launchPage, which takes an input parameter appURL.
The method gets a WebDriver instance using the WebDriverControl.getDriver() method, which is defined in the WebDriverControl class (explained below).
However, there is a minor issue in this class.
The WebDriverControl class:

This class implements the ISuiteListener interface, which means it listens to TestNG suite events.
When the suite starts (onStart method is called), it reads the browser type and application URL parameters from the TestNG suite and based on the browser type, it initializes a corresponding WebDriver instance (Chrome or Internet Explorer).
The initialized WebDriver instance is then stored as an attribute in the TestNG suite context for later use (suite.setAttribute(DRIVER, driver)).
When the suite finishes (onFinish method is called), it retrieves the stored WebDriver instance from the suite context and quits the WebDriver.
The CRUD_Screen class:

This class represents a specific page (screen) in the web application.
It uses PageObjects class for initializing web elements using @FindBy annotations.
The PageObjects class:

This class is a base class for all page objects.
It contains a constructor that initializes the WebDriver and web elements using PageFactory.
The CRUD_screen_verification class:

This is a TestNG test class for performing the CRUD operations.
In the setUp method, it gets the WebDriver instance using WebDriverControl.getDriver().
The test method verifyHomePage is annotated with @Test, which means it will be executed as a TestNG test.
The test method interacts with the CRUD_Screen page object to perform the CRUD operations (ClickViewIronman and ClickDeleteBookroom).
The testng.xml file:

This XML file is the TestNG test suite configuration.
It specifies the test suite name as "Suite" and one test named "Test."
The test parameters appURL and browserType are specified here.
The test class Test_Cases.CRUD_screen_verification is included in this suite.
Overall, the framework follows a modular structure with separate classes for browser control (WebDriverControl), page objects (CRUD_Screen), and test cases (CRUD_screen_verification). TestNG is used to manage the test execution, and Selenium WebDriver is used to interact with the web application.
