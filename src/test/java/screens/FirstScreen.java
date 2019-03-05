package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import util.screens.BaseRobot;

/**
 * Object of the first screen that appears when we open the application.
 * 
 * @author Arley.Bolivar
 *
 */
public class FirstScreen extends BaseRobot {

	/**
	 * Constructor method.
	 * 
	 * @author Arley.Bolivar
	 * 
	 * @param androidDriver
	 *            : AndroidDriver
	 */
	public FirstScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	/**
	 * Returns AlertsOnAppRobot.
	 * 
	 * @author Arley.Bolivar
	 * 
	 * @return AlertsOnAppRobot
	 */
	public AlertsOnAppScreen getAnyAlert() {
		return new AlertsOnAppScreen(driver);
	}

}
