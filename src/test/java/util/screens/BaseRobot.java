package util.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import util.CustomWait;

import static java.lang.String.format;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Base class for all screens Objects.
 * 
 * @author Arley.Bolivar
 *
 */
public abstract class BaseRobot {
	protected CustomWait customWait = new CustomWait();
	protected final AndroidDriver<AndroidElement> driver;
	public Logger log = Logger.getLogger(BaseRobot.class);
	private static final int PERCENT = 100;

	/**
	 * Constructor method for standard screens object.
	 * 
	 * @author Arley.Bolivar
	 * 
	 * @param driver
	 *            : AndroidDriver
	 */
	public BaseRobot(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);
	}

	/**
	 * Tab on back button.
	 * 
	 * @author Arley.Bolivar
	 */
	public void tapBack() {
		// driver.pressKeyCode(AndroidKeyCode.BACK);
		driver.navigate()
			.back();
	}

	/**
	 * Swipe from top to bottom of screen or vice versa.
	 * 
	 * @author Arley.Bolivar
	 */
	public void swipeVertical(double startY, double endY, double startX) {
		Dimension size = driver.manage()
			.window()
			.getSize();
		int starty = (int) (size.height * (startY / PERCENT));
		int endy = (int) ((size.height * endY / PERCENT));
		int startx = (int) (size.width * startX / PERCENT);
		driver.swipe(startx, starty, startx, endy, 1200);
	}

	/**
	 * Scroll to the text attribute received by parameter.
	 *
	 * @author Arley.Bolivar
	 *
	 * @param text
	 *            : String
	 */
	public void scrollToText(String text) {
		String automator = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().textContains(\"%s\"))";
		AndroidElement textOnElement = driver.findElementByAndroidUIAutomator(format(automator, text));
		log.info(textOnElement.getText());
	}
	
	public CustomWait getCustomWait() {
		return customWait;
	}
}
