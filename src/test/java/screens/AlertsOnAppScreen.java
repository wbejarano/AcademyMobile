package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseRobot;

/**
 * Screen of alerts on application.
 * 
 * @author helberth.bolivar
 *
 */
public class AlertsOnAppScreen extends BaseRobot {

	/**
	 * Constructor method.
	 * 
	 * @author Arley.Bolivar
	 * 
	 * @param driver
	 *            : AndroidDriver
	 */
	public AlertsOnAppScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	// Locators
	private static final String ALLOW_ACCESS_MESSAGE_ID = "com.android.packageinstaller:id/permission_message";
	private static final String ALLOW_BUTTON_ID = "com.android.packageinstaller:id/permission_allow_button";

	// AndroidElements
	@AndroidFindBy(id = ALLOW_ACCESS_MESSAGE_ID)
	private AndroidElement allowAccessMessage;
	@AndroidFindBy(id = ALLOW_BUTTON_ID)
	private AndroidElement allowButton;

	/**
	 * @author Helberth.Bolivar
	 *
	 * @description: Returns the sign up or login screen after click on allow
	 *               button.
	 *
	 * @return SignUpOrLogInScreen
	 */
	public SignUpOrLogInScreen openSignUpOrLoginScreen() {
		// TODO: improve and complete this method.	
		try {
			while (allowAccessMessage.isDisplayed() && allowButton.isDisplayed()) {
				allowButton.click();
			}
		} catch (Exception e) {
			
		}
		return new SignUpOrLogInScreen(driver);
	}
}
