package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseRobot;

/**
 * Screen of SignUp or LogIn screen.
 * 
 * @author Arley.Bolivar
 *
 */
public class SignUpOrLogInScreen extends BaseRobot {

	private AndroidDriver<AndroidElement> myDriver;
	/**
	 * Constructor method.
	 * 
	 * @author Arley.Bolivar
	 * 
	 * @param androidDriver
	 *            : AndroidDriver
	 */
	public SignUpOrLogInScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
		myDriver = driver;
	}

	// AndroidElements
	@AndroidFindBy(id = "com.espn.score_center:id/btn_signup")
	protected AndroidElement singUpButton;
	
	@AndroidFindBy(id = "com.espn.score_center:id/btn_login")
	private AndroidElement logInButton;
	
	@AndroidFindBy(id= "com.espn.score_center:id/btn_sign_up_later")
	private AndroidElement linkSignUpLater;

	/**
	 * @author Helberth.Bolivar
	 *
	 * @description: returns a new screen after click on login button.
	 *
	 */
	public LoginScreen clickOnLoginButton() {
		
		logInButton.click();	
		getCustomWait().waitInSeconds(20);
		return getLoginScreen();
		
	}

	/**
	 * @decription return Edition screen
	 * @return EditionScreen
	 */
	public EditionScreen clickOnSignLater() {
		linkSignUpLater.click();
		return new EditionScreen(myDriver);
	} 
	
	/**
	 * @description return Login screen
	 * @return LoginScreen
	 */
	public LoginScreen getLoginScreen() {
		return new LoginScreen(myDriver);
	}
	
}
