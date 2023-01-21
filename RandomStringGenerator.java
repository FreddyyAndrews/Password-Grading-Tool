import java.util.Random;

// Class for generating random strings
public class RandomStringGenerator {

	private String password;
	//Constructor
	public RandomStringGenerator(int randomLength) {
		password= generateRandomString(randomLength);
	}
	//Method to generate completely randomized passwords of a given length
	public static String generateRandomString(int len) {
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
          +"lmnopqrstuvwxyz!@#$%&";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}
	//Get passcode
	public String getString() {
		return this.password;
	}
}