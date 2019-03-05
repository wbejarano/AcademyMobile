package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseRobot;

/**
 * @author william.bejarano
 *
 */
public class FavoriteLeagueScreen extends BaseRobot{

	@AndroidFindBy(id="com.espn.score_center:id/nextText")
	private AndroidElement btnSkip;
	
	public FavoriteLeagueScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	/**
	 * 
	 */
	public void clickOnSkiptButton() {
		btnSkip.click();
	}
	
	/**
	 * @return FavoriteTeamsScreen
	 */
	public FavoriteTeamsScreen getFavoriteTeamsScreen() {
		return new FavoriteTeamsScreen(driver);
	}
	
}
