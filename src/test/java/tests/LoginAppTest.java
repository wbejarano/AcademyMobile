package tests;

import org.springframework.context.annotation.Description;
import org.testng.annotations.Test;

import parameters.Parameters;
import parameters.User;
import screens.CreateAccountScreeen;
import screens.EditionScreen;
import screens.FavoriteLeagueScreen;
import screens.FavoriteTeamsScreen;
import screens.FeedBackScreen;
import screens.HomeScreen;
import screens.LoginScreen;
import screens.SignUpOrLogInScreen;
import util.tests.BaseMobileTest;

public class LoginAppTest extends BaseMobileTest {

	/**
	 * @description 
	 * @param edition : String[]
	 * @param user : Parameter.User
	 */
	@Description(value = "Login assertive ID:0001")
	@Test(groups={"login_assertive"}, dataProvider="user_data", dataProviderClass=Parameters.class )
	public void testLogin(User user) {
		
		log.info("1. Failed assertive login test");
		LoginScreen loginScreen = getLogInScreeen();
		loginScreen.loginApplication(user.getEmail(), user.getBadPassword());
		log.info("1.3 End");
	}
	
	
	/**
	 * @description navegate on ESPN edition list
	 * @param edition
	 * @param user
	 */
	@Description(value = "Navigation bar test ID:0002")
	@Test(groups={"navigate_bar_test"}, 
			dataProvider="edition_user_data", 
			dataProviderClass=Parameters.class )
	public void testNavigatorBar(String[] edition, User user) {
		
		log.info("2. Navigation bar test");
		LoginScreen loginScreen = getLogInScreeen();	
		EditionScreen editionScreen = 
				loginScreen.loginApplication(user.getEmail(), user.getPassword());
		editionScreen.selectEdition(edition);
		log.info("2.3 End");
	}
	
	
	/**
	 * @param edition String[]
	 * @param user User
	 */
	@Description(value = "Create account test ID:0003")
	@Test(	groups={"create_account_test"}, 
			dataProvider="edition_user_data", 
			dataProviderClass=Parameters.class )
	public void testCreateAccount(String[] edition, User user) {
		
		log.info("3. Create account");
		SignUpOrLogInScreen loginOrCreateAccount = loadAppOnSignUpOrLoginScreen();
		EditionScreen editionScreen = loginOrCreateAccount.clickOnSignLater();
		editionScreen.selectEdition(edition);
		
		log.info("3.1 Get edition screen");
		FavoriteLeagueScreen fvteLeagueScreen = editionScreen.getFavoriteLeagueScreen();
		fvteLeagueScreen.clickOnSkiptButton();
		FavoriteTeamsScreen fvteTeamScreen = fvteLeagueScreen.getFavoriteTeamsScreen();
		
		log.info("3.2 Finish configuration");
		fvteTeamScreen.clickOnFinishButton();
		fvteTeamScreen.clickOnAlertOk();
		
		log.info("3.3 Go to home screen");
		HomeScreen homeScreen = fvteTeamScreen.getHomeScreen();
		homeScreen.clickOnConfiturationButton();
		String[] item = {"Log In to ESPN Account"};
		homeScreen.selectItem(item);
		
		log.info("3.4 Go to login screen");
		LoginScreen loginScreen = loginOrCreateAccount.getLoginScreen();
		CreateAccountScreeen createAccount = loginScreen.clickOnSignUpButton();
		createAccount.fillCreateForm(user);
		log.info("3.5 End");
		
	}
	
	@Description(value = "Create account test ID:0004")
	@Test(	groups={"feed_back_test"}, 
			dataProvider="edition_data", 
			dataProviderClass=Parameters.class )
	public void testFeedBack(String[] edition) {
		log.info("4. Feedback page test");
		
		log.info("4.1 Login page");
		SignUpOrLogInScreen loginOrCreateAccount = loadAppOnSignUpOrLoginScreen();
		EditionScreen editionScreen = loginOrCreateAccount.clickOnSignLater();
		editionScreen.selectEdition(edition);
		
		log.info("4.2 Select fixtures");
		FavoriteLeagueScreen fvteLeagueScreen = editionScreen.getFavoriteLeagueScreen();
		fvteLeagueScreen.clickOnSkiptButton();
		FavoriteTeamsScreen fvteTeamScreen = fvteLeagueScreen.getFavoriteTeamsScreen();
		
		fvteTeamScreen.clickOnFinishButton();
		fvteTeamScreen.clickOnAlertOk();
		
		log.info("4.3 Configuration button");
		HomeScreen homeScreen = fvteTeamScreen.getHomeScreen();
		homeScreen.clickOnConfiturationButton();
		String[] item = {"ESPN App Feedback"};
		homeScreen.selectItem(item);
		
		log.info("4.4 Go to feedback screen");
		FeedBackScreen feedBackScreen = homeScreen.getFeedBackScreen();
		feedBackScreen.iskScreenLoaded();
	}
	
	/**
	 * @description 
	 * @param edition
	 */
	@Description(value = "Settings while not logged in test ID:0005")
	@Test(	groups={"settings_test"}, 
			dataProvider="edition_data", 
			dataProviderClass=Parameters.class )
	public void testNotLogged(String[] edition) {
		log.info("5 Settings while not logged in test");
		
		log.info("5.1 Login");
		SignUpOrLogInScreen loginOrCreateAccount = loadAppOnSignUpOrLoginScreen();
		EditionScreen editionScreen = loginOrCreateAccount.clickOnSignLater();
		editionScreen.selectEdition(edition);
		
		log.info("5.2 Fixtures");
		FavoriteLeagueScreen fvteLeagueScreen = editionScreen.getFavoriteLeagueScreen();
		fvteLeagueScreen.clickOnSkiptButton();
		FavoriteTeamsScreen fvteTeamScreen = fvteLeagueScreen.getFavoriteTeamsScreen();
		fvteTeamScreen.clickOnFinishButton();
		fvteTeamScreen.clickOnAlertOk();
		
		log.info("5.4 Home screen");
		HomeScreen homeScreen = fvteTeamScreen.getHomeScreen();
		homeScreen.clickOnConfiturationButton();
		
		log.info("5.5 LogIn screen");
		String[] item = {"Log In to ESPN Account"};
		homeScreen.selectItem(item);
		
		log.info("5.6 End");
	}
	
	/**
	 * @description init login screen
	 * @return LoginScreen
	 */
	private LoginScreen getLogInScreeen() {
		SignUpOrLogInScreen loginOrCreateAccount = loadAppOnSignUpOrLoginScreen();
		 return loginOrCreateAccount.clickOnLoginButton();
	} 

}
