public class TestPasswordGeneration {

    public double testPasswordEntropy (String testPassword) {
       
        PasswordEntropy entropyTest = new PasswordEntropy();
        return entropyTest.calculateEntropy(testPassword);
    }
    
    public static void main(String[] args)  {
        TestPasswordGeneration testRun = new TestPasswordGeneration();
        System.out.println(testRun.testPasswordEntropy("abcde123456"));
    }

    
}
