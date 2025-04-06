package org.cleidson.coding;

/**
 * This class is used to test if a given string is a palindrome.
 */
public class PalindromeTest {

    /**
     * The main method which tests a few strings for being a palindrome.
     * @param args command line arguments, not used in this method, but it is required in the Java main method.
     */
    public static void main(String[] args) {
        printPalindromeTest("ovo");
        printPalindromeTest("ana");
        printPalindromeTest("ovoo");
        printPalindromeTest("oovoo");
        printPalindromeTest("banana");
        printPalindromeTest("121");
        printPalindromeTest("1221");
        printPalindromeTest("12121");
        printPalindromeTest("123454321");
    }

    /**
     * This method prints the result of the palindrome test for a given input string.
     * @param input the string to be tested for being a palindrome.
     */
    private static void printPalindromeTest(String input) {
        boolean isPalindrome = isPalindrome(input);
        String printOutput = String.format("The input '%s' is a palindrome: %s", input, isPalindrome);
        System.out.println(printOutput);
    }

    /**
     * This method checks if a given string is a palindrome.
     * A palindrome is a word, phrase, number, or other sequence of characters that reads the same forward and backward, ignoring spaces, punctuation, and capitalization.
     * @param str the string to be tested for being a palindrome.
     * @return true if the input string is a palindrome, false otherwise.
     */
    private static boolean isPalindrome(String str) {
        String clean = str.replaceAll("\\W", "").toLowerCase();
        String reverse = new StringBuilder(clean).reverse().toString();
        return clean.equals(reverse);
    }

}
