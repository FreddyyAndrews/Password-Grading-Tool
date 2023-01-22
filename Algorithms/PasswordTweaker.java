import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;

public class PasswordTweaker {
    
    //User entered password
    String userEnteredPassword;
    //Recomended password
    String recomendedPassword;
    //Recomended length
    int recomendedLength = 15;
    
    //Constructor
    PasswordTweaker(String userEnteredPassword){
        this.userEnteredPassword = userEnteredPassword;
        recomendedPassword = userEnteredPassword;
    }
    //Tests Password quality with entropy
    

    public void testPassword(){

        PasswordEntropy passwordEnthropy = new PasswordEntropy();
        double enthropy= passwordEnthropy.calculateEntropy(userEnteredPassword);

        if(enthropy>30){
            System.out.println("Your Password is strong :) ."); 
            makeRecomendation();
        }else if(enthropy<= 30 && enthropy>= 20){

            System.out.println("Your Password is intermediate :/ I recomend the following: "); 
            makeRecomendation();
            
        }else {
            System.out.println("Your Password is weak :( I strongly recomend the following: ");
            makeRecomendation();
        }
        
    }
    //Makes recomendations and creates a suggested password
    private void makeRecomendation() {

        //Check password length

        if(userEnteredPassword.length() < recomendedLength){
            System.out.println("    - Increase your password length.");
            
            //Make recomended password longer with extra random characters
            RandomStringGenerator addedChars = new RandomStringGenerator(recomendedLength-userEnteredPassword.length());
            //Concatonate String
            recomendedPassword = userEnteredPassword + addedChars.getString();
            
        }

        //Check if password contains special chars

        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(recomendedPassword);
        boolean isStringContainsSpecialCharacter = matcher.find();
        if(!isStringContainsSpecialCharacter){
            System.out.println("    - Add a special character.");
            String chars = "!@#$%&*^()";
            Random rnd = new Random();
            char c = chars.charAt(rnd.nextInt(chars.length()));
            recomendedPassword = addChar(recomendedPassword, c, rnd.nextInt(recomendedPassword.length()));
        }

        //Check if password contains upper and lower case characters

        if(recomendedPassword.toLowerCase().equals(recomendedPassword)){
            String uppers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            Random rnd = new Random();
            char c = uppers.charAt(rnd.nextInt(uppers.length()));
            recomendedPassword = addChar(recomendedPassword, c, rnd.nextInt(recomendedPassword.length()));
            System.out.println("    - Add upercase letters.");
        }

        if(recomendedPassword.toUpperCase().equals(recomendedPassword)){
            String lowers = "abcdefghijklmnopqrstuvwxyz";
            Random rnd = new Random();
            char c = lowers.charAt(rnd.nextInt(lowers.length()));
            recomendedPassword = addChar(recomendedPassword, c, rnd.nextInt(recomendedPassword.length()));
            System.out.println("    - Add lowercase letters.");
        }

        //Check if password contains letters and numbers

        char[] chars = recomendedPassword.toCharArray();
        boolean containsDigit = false;
        for(char c : chars){
            if(Character.isDigit(c)){
                containsDigit = true;
            }   
        }
        if(!containsDigit){
            String nums = "0123456789";
            Random rnd = new Random();
            char c = nums.charAt(rnd.nextInt(nums.length()));
            recomendedPassword = addChar(recomendedPassword, c, rnd.nextInt(recomendedPassword.length()));
            System.out.println("    - Add numbers.");
        }

        //Checks if password is similar to other popular passwords

        if(findPasswordSimilarity("wordlist.txt") < userEnteredPassword.length()-userEnteredPassword.length()/2){
            System.out.println("    - You have used a known password. I recommend you do not build a password with these keywords.");
        }

    }
    //Insert character into string at index
    private String addChar(String str, char ch, int position) {
        int len = str.length();
        char[] updatedArr = new char[len + 1];
        str.getChars(0, position, updatedArr, 0);
        updatedArr[position] = ch;
        str.getChars(position, len, updatedArr, position + 1);
        return new String(updatedArr);
    }

    //Get recommended password
    public String getRecommendedPassword() {
        return recomendedPassword;
    }

    private int findPasswordSimilarity(String fileName) {


        LevenshteinDistanceDP distance = new LevenshteinDistanceDP();
        int minDistance = 999;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
               int value = distance.compute_Levenshtein_distanceDP(userEnteredPassword, line);
               if(value<minDistance){
                    minDistance = value;
               }
            }
        }catch(Exception e) {

        }

        return minDistance;
  
    }

}
