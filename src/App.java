import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.print("Please enter a password: ");
        Scanner passwordAsker = new Scanner(System.in);
        String password = passwordAsker.nextLine();
        

        Collection<Character> passwordArray = new ArrayList<Character>();
        for (int i = 1; i < password.length() - 1; i++){
            passwordArray.add(password.charAt(i));
        }
        if (passwordScreen(passwordArray) >= 3) {
            System.out.println("\nThe password meets the requirements\n");
        }
        else {
            System.out.println("\nThe password does not meet requirements\n");
        }
        passwordAsker.close();

    }

    public static int passwordScreen(Collection<Character> passwordArray) {
        if (passwordArray.size() < 8 || passwordArray.size() > 16) {
            return 0;
        }
        else {
            char[] lowercaseChar = "qwertyuiopasdfghjklzxcvbnm".toCharArray();
            char[] uppercaseChar = "QWERTYUIOPASDFGHJKLZXCVBNM".toCharArray();
            char[] numbers = "0123456789".toCharArray();
            char[] specialChar = "~!@#$%^&*()-=+_".toCharArray();
            int passwordPoints = 0;

            if (comparator(passwordArray, lowercaseChar)) {
                passwordPoints += 1;
            }
            if (comparator(passwordArray, uppercaseChar)) {
                passwordPoints += 1;
            }
            if (comparator(passwordArray, numbers)) {
                passwordPoints += 1;
            }
            if (comparator(passwordArray, specialChar)) {
                passwordPoints += 1;
            }
            
            return passwordPoints;
        }
    }

    public static boolean comparator(Collection<Character> passwordArray, char[] comparisonArray) {
        
        for (char object: comparisonArray) {
            if (passwordArray.contains(object)) {
                return true;
            }
        }
        return false;
    }
}
