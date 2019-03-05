package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseRobot;

/**
 * Screen of Login screen
 * @author william.bejarano
 *
 */
public class LoginScreen extends BaseRobot {
	
	@AndroidFindBy(xpath="//android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.EditText")
	private AndroidElement usernameText;
	
	@AndroidFindBy(xpath="//android.view.View[2]/android.view.View/android.widget.EditText")
	private AndroidElement passwordText; 
	
	@AndroidFindBy(xpath="//android.widget.Button[@content-desc=\"Log In\"]")
	private AndroidElement logInButton;
	
	@AndroidFindBy(xpath="//android.view.View[@content-desc=\"Sign Up\"]")
	//@AndroidFindBy(id="Sign Up")
	private AndroidElement logUpButton;
	
	public LoginScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}
	
	/**
	 * @descripton Autenthicate on app
	 * @param username
	 * @param password
	 * @return EditionScreen
	 */
	public EditionScreen loginApplication(String username, String password) {
		usernameText.sendKeys(username);
		passwordText.sendKeys(password);
		getCustomWait().waitAndroidElementToBeClickable(driver, logInButton, 10);
		logInButton.click();
		getCustomWait().waitInSeconds(5);
		return new EditionScreen(driver);
	}
	
	/**
	 * @description click on SignUp button
	 * @return CreateAccountScreeen
	 */
	public CreateAccountScreeen clickOnSignUpButton() {
		
		getCustomWait().waitAndroidElementToBeClickable(driver, logInButton, 10);
		logUpButton.click();
		return getCreateAccount();
	}
	
	/**
	 * @description return a new CreateAccount screen
	 * @return CreateAccountScreeen
	 */
	public CreateAccountScreeen getCreateAccount() {
		return new CreateAccountScreeen(driver);
	}
}
