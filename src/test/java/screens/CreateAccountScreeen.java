package screens;

import java.util.List;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import parameters.User;
import util.screens.BaseRobot;

/**
 * @author william.bejarano
 *
 */
public class CreateAccountScreeen extends BaseRobot{

	@AndroidFindBy(className="android.widget.EditText")
	private List<AndroidElement> fields;
	
	@AndroidFindBy(className="android.widget.Button")
	private AndroidElement btnSignUp;

	
	public CreateAccountScreeen(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}
	
	/**
	 * @description Fill create user form with user data
	 * @param user User
	 */
	public void fillCreateForm(User user) {
		
		getCustomWait().waitInSeconds(5);
		
		for (AndroidElement androidElement : fields) {
			
			switch (androidElement.getText()) {
			case "First Name":
				androidElement.sendKeys(user.getFirstName());
				break;
			case "Last Name":
				androidElement.sendKeys(user.getLastName());
				break;
			case "Email Address":
				androidElement.sendKeys(user.getEmail());
				break;
			default:
				androidElement.sendKeys(user.getPassword());
				break;
			}
		} 
		btnSignUp.click();
	}

}
