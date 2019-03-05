package parameters;

import org.testng.annotations.DataProvider;

public class Parameters {
	
	@DataProvider(name="edition_user_data")
	public static Object[][] authData(){
		String[] edition = {"U.S. - English", "EE.UU - Inglés"};
		return new Object[][] {{edition, Parameters.createUser()}};
	}
	
	@DataProvider(name="user_data")
	public static Object[][] getUser(){
		return new Object[][] {{Parameters.createUser()}};
	}
	
	@DataProvider(name="edition_data")
	public static Object[][] editionData(){
		String[] edition = {"U.S. - English", "EE.UU - Inglés"};
		return new Object[][] {{edition}};
	}
	
	public static User createUser() {
		User user = new User();
		user.setEmail("wandrew007@gmail.com");
		user.setPassword("Mira11012005*");
		user.setBadPassword("Prueba123*");
		user.setFirstName("William");
		user.setLastName("Bejarano");
		return user;
	}

}
