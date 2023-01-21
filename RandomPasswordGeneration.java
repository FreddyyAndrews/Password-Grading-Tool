import java.util.Random;

public class RandomPasswordGeneration {

    //Instance Variables
    PasswordEntropy entropy = new PasswordEntropy();

    //Generate random length for password
    Random rand = new Random();
    int randomLength = rand.nextInt(15-12) + 12;

    RandomPasswordGeneration(){
        
        boolean flag = false;

        while(!flag){
            RandomStringGenerator generation = new RandomStringGenerator(randomLength);
            String potentialPassword = generation.getString();

            

        }
    }
}
    
    
