package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseRobot;

public class FavoriteTeamsScreen extends BaseRobot {

	@AndroidFindBy(id="com.espn.score_center:id/nextText")
	private AndroidElement btnFinish;
	
	@AndroidFindBy(id="android:id/button1")
	private AndroidElement btnAlertOk;

	
	public FavoriteTeamsScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}
	
	/**
	 * 
	 */
	public void clickOnFinishButton() {
		btnFinish.click();
	}
	
	/**
	 * 
	 */
	public void clickOnAlertOk() {
		btnAlertOk.click();
	}
	
	/**
	 * @return HomeScreen
	 */
	public HomeScreen getHomeScreen() {
		return new HomeScreen(driver);
	}

}
