package screens;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseRobot;

/**
 * @author william.bejarano
 *
 */
public class EditionScreen extends BaseRobot {
	
	@AndroidFindBy(id="com.espn.score_center:id/edition_radio")
	private List<AndroidElement> editionItems;
	
	@AndroidFindBy(id="com.espn.score_center:id/nextText")
	private AndroidElement btnNext;

	public EditionScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}
	
	/**
	 * @description
	 * @param element String
	 */
	public void selectEdition(String[] elements) {
		
		Assert.assertFalse(editionItems.isEmpty());
		AndroidElement editionElement =
				editionItems.stream().filter(item -> ArrayUtils.contains(elements, item.getText())).findAny().get();
		editionElement.click();
        btnNext.click();
	}
	
	
	/**
	 * @return FavoriteLeagueScreen
	 */
	public FavoriteLeagueScreen getFavoriteLeagueScreen() {
		return new FavoriteLeagueScreen(driver);
	}
	
	
}
