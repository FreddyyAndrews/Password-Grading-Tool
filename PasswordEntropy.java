//import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class PasswordEntropy {

    public double calculateEntropy(String password) {
        Map<Character, Integer> charFrequency = new HashMap<>();
        int passwordLength = password.length();

        for (int i = 0; i < passwordLength; i++) {
            char c = password.charAt(i);
            charFrequency.merge(c, 1, Integer::sum);
        }

        double entropy = 0.0;
        for (int frequency : charFrequency.values()) {
            double probability = (double) frequency / passwordLength;
            entropy += probability * (Math.log(probability) / Math.log(2));
        }

        return entropy;
    }

    public static boolean checkStrength(double entropy) {
        // The entropy threshold can be adjusted as per the requirement
        double threshold = 40; 
        return entropy >= threshold;
    }

}