package screens;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.testng.Assert;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import util.screens.BaseRobot;

/**
 * @author william.bejarano
 *
 */
public class HomeScreen extends BaseRobot {

	@AndroidFindBy(id = "com.espn.score_center:id/menu_settings")
	private AndroidElement btnConfiguration;

	@AndroidFindBy(id = "com.espn.score_center:id/xLabelTextView")
	private List<AndroidElement> listConfMenu;

	public HomeScreen(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}

	/**
	 * @description 
	 */
	public void clickOnConfiturationButton() {
		btnConfiguration.click();
	}

	/**
	 * @description 
	 * @param itemToSelect tring[]
	 */
	public void selectItem(String[] itemToSelect) {

		AndroidElement menuElement = listConfMenu.stream()
				.filter(conf -> ArrayUtils.contains(itemToSelect, conf.getText())).findAny().get();
		Assert.assertFalse(listConfMenu.isEmpty());

		if (listConfMenu != null && !listConfMenu.isEmpty()) {
			AndroidElement bottomElement = listConfMenu.get(listConfMenu.size() - 1);
			TouchAction touchAction = new TouchAction(driver).press(menuElement).moveTo(bottomElement).release();
			touchAction.perform();
		}

		menuElement.click();

	}

	/**
	 * @return FeedBackScreen
	 */
	public FeedBackScreen getFeedBackScreen() {
		return new FeedBackScreen(driver);
	}

}
