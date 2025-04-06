package org.cleidson.coding;

import java.util.Arrays;

/**
 * This class is used to find the smallest number in a given sequence.
 */
public class FindTheMinorNumber {

    /**
     * The main method which tests a few sequences for finding the smallest number.
     * @param args command line arguments, not used in this method.
     */
    public static void main(String[] args) {
        printMinorNumber(new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        printMinorNumber(new int[]{ 20, 3, 9, 14 });

        printMinorNumberUsingSort(new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        printMinorNumberUsingSort(new int[]{ 20, 3, 9, 14 });
    }

    /**
     * This method prints the smallest number in a given sequence.
     * @param sequence the sequence to be tested for finding the smallest number.
     */
    private static void printMinorNumber(int[] sequence) {
        int minorNumber = findMinorNumber(sequence);
        String output = String.format("The minor number in the sequence is: %s", minorNumber);
        System.out.println(output);
    }

    /**
     * This method finds the smallest number in a given sequence.
     * @param sequence the sequence to be tested for finding the smallest number.
     * @return the smallest number in the sequence.
     */
    private static int findMinorNumber(int[] sequence) {
        int min = sequence[0];
        for (int i = 1; i < sequence.length; i++) {
            if (sequence[i] < min) {
                min = sequence[i];
            }
        }
        return min;
    }

    /**
     * This method prints the smallest number in a given sequence using sorting.
     * @param sequence the sequence to be tested for finding the smallest number.
     */
    private static void printMinorNumberUsingSort(int[] sequence) {
        Integer minorNumber = findMinorNumberUsingSort(sequence);
        String output = String.format("The minor number in the sequence is: %s", minorNumber);
        System.out.println(output);
    }

    /**
     * This method finds the smallest number in a given sequence using sorting.
     * @param sequence the sequence to be tested for finding the smallest number.
     * @return the smallest number in the sequence.
     */
    private static Integer findMinorNumberUsingSort(int[] sequence) {
        Integer result = null;
        if(sequence.length > 0) {
            Arrays.sort(sequence);
            result = sequence[0];
        }
        return result;
    }
}
