
public class PasswordEntropy {

    //Class to test password enthropy
    public double calculateEntropy(String password) {
        long uniqueChars = password.chars().distinct().count();
        int passwordLength = password.length();
        //Enthropy = log2(R^L) where R is the number of unique characters and L is the length of the string
        return Math.log(Math.pow(uniqueChars, passwordLength));
    }

}