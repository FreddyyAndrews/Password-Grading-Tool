import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        boolean flag = true;
        System.out.println("Hi I'm Entrepass. How can I help you today?");
        System.out.println();

        while(flag){

            
            System.out.println("    1. to generate random password");
            System.out.println("    2. to have your password reviewed");
            System.out.println("    3. to compute a password's entropy");
            System.out.println("    4. to quit" +"\n");
            

            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            String choice = myObj.nextLine();  // Read user input
            choice = choice.replaceAll("\\s+","");

            if(choice.equals("1"))  {

                RandomPasswordGeneration rando = new RandomPasswordGeneration();
                System.out.println("Here is your random password: "+rando.getPassword());
                System.out.println();
                System.out.println("Anything else?");
                System.out.println();

            }
            if(choice.equals("2"))  {
                System.out.println();
                System.out.println("Let's see your password.");
                System.out.println();
                Scanner scan = new Scanner(System.in);  // Create a Scanner object
                String password = scan.nextLine();  // Read user input
                
                PasswordTweaker tweaker = new PasswordTweaker(password);
                
                tweaker.testPassword();
                System.out.println();
                System.out.println("Based on what you gave me this is the password I recommend: " + tweaker.getRecommendedPassword());
                System.out.println();
                System.out.println("Anything else?");
                System.out.println();
                 

            }
            if(choice.equals("3"))  {
                System.out.println();
                System.out.println("Let's see your password.");
                System.out.println();
                Scanner scan = new Scanner(System.in);  // Create a Scanner object
                String password = scan.nextLine();  // Read user input
                PasswordEntropy entropy = new PasswordEntropy();
                System.out.println("This is the calculated entropy for that password: " + entropy.calculateEntropy(password));
                System.out.println();
                System.out.println("Anything else?");

            }
            if(choice.equals("4"))  {

                flag = false;

            }
        }
        
        
        
        
    }

    
    
}
