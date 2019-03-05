package screens;

import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseRobot;

/**
 * @author william.bejarano
 *
 */
public class FeedBackScreen extends BaseRobot{
	
	
	@AndroidFindBy(id="com.espn.score_center:id/toolbar_title")
	private AndroidElement tittle;
	
	@AndroidFindBy(id="request_anonymous_requester_email")
	private AndroidElement email;
	
	public FeedBackScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	/**
	 *  @description check if the Feedback screen is loaded
	 */
	public void iskScreenLoaded() {	
		getCustomWait().waitAndroidElementVisibility(driver, email, 30);
		Assert.assertTrue(email.isDisplayed());
	}

}
