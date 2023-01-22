//Testing for password generation classes
public class TestPasswordGeneration {

    //Testing password enthopy calculations
    public double testPasswordEntropy (String testPassword) {
       
        PasswordEntropy entropyTest = new PasswordEntropy();
        return entropyTest.calculateEntropy(testPassword);
    }
    //Testing random password generation
    public String testRandomPasswordGeneration(){
        RandomPasswordGeneration passwordMaker = new RandomPasswordGeneration();
        return passwordMaker.getPassword();
    }

    public String testTweaker() {
        PasswordTweaker tweaker = new PasswordTweaker("L6OVE1");
        System.out.println(testPasswordEntropy("L6OVE1"));
        System.out.println();
        tweaker.testPassword();
        System.out.println(testPasswordEntropy(tweaker.getRecommendedPassword()));
        return tweaker.getRecommendedPassword();
    }
    
    public static void main(String[] args)  {
        TestPasswordGeneration testRun = new TestPasswordGeneration();
       // String testPassword = testRun.testRandomPasswordGeneration();
       // System.out.println(testPassword);
       // System.out.println(testRun.testPasswordEntropy(testPassword));
        System.out.println(testRun.testTweaker());
    }

    
}
