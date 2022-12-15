package service.provider;

public class UserManager {
	
	private static final ThreadLocal<String> currentUser = new ThreadLocal<>();
	
	private UserManager() {
	}
	
	public static String getUser() {
		return currentUser.get();
	}
	
	public static void setUser(String username) {
		if(username==null) {
			currentUser.remove();
		}else {
			currentUser.set(username);
		}
	}

}
