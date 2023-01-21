import java.util.Random;

public class RandomPasswordGeneration {

    //Instance Variables
    PasswordEntropy entropy = new PasswordEntropy();
    String password;
    //Generate random length for password
    Random rand = new Random();
    int randomLength = rand.nextInt(15-12) + 12;

    //Constructor that generates random password with an enthropy over 15
    RandomPasswordGeneration(){
        
        boolean isValid = false;
        String potentialPassword="";
        //Generates random passwords until a valid password is acheived
        while(!isValid){
            RandomStringGenerator generation = new RandomStringGenerator(randomLength);
            potentialPassword = generation.getString();

            //Checks Password Enthropy
            if(entropy.calculateEntropy(potentialPassword) > 15){
                isValid = true;
            }

        }
        //Sets password
        password = potentialPassword;
    }

    //Get Valid Password
    public String getPassword() {
        return password;
    }
}
    
    
