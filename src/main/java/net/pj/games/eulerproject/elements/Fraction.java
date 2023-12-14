package net.pj.games.eulerproject.elements;

import java.util.Arrays;

public class Fraction {

    private String decimalPart = null;

    private final String integerPart;

    private int recurrenceLength = 0;

    private static final Integer MAX_DECIMAL_PART_LENGTH = 1000;

    public Fraction(Integer numerator, Integer denominator) {
        if(denominator == 0) throw new IllegalArgumentException("Denominator cannot be 0");
        this.integerPart = Integer.valueOf(numerator/denominator).toString();
        Integer rest = numerator%denominator;
        getDecimalPart(rest, denominator);
    }

    private void getDecimalPart(Integer rest, Integer denominator) {

        char[] decimals = new char[MAX_DECIMAL_PART_LENGTH];
        int index = 0;
        int[] rests = new int[MAX_DECIMAL_PART_LENGTH];
        int indexRecurrence = -1;
        while(rest != 0 && index < MAX_DECIMAL_PART_LENGTH) {
            int nextRest = rest * 10;
            // if rests contains rest, we have a recurrence
            int existingRestIndex = Arrays.binarySearch(rests, 0, index, nextRest);
            if(existingRestIndex >= 0) {
                // we have a recurrence
                // we have to find the index of the first occurrence of nextRest
                indexRecurrence = existingRestIndex;
                break;
            }
            decimals[index] = (char) (nextRest/denominator + '0');
            rest = nextRest%denominator;
            rests[index] = nextRest;
            index++;
        }
        if(indexRecurrence != -1) {
            // we have a recurrence
            // we have to find the index of the first occurrence of nextRest
            recurrenceLength = index - indexRecurrence;
            // copy the recurrence in a new array
            char[] recurrence = new char[recurrenceLength];
            System.arraycopy(decimals, indexRecurrence, recurrence, 0, recurrenceLength);
            char[] decimalPartWithoutRecurrence = new char[indexRecurrence];
            System.arraycopy(decimals, 0, decimalPartWithoutRecurrence, 0, indexRecurrence);
            //assemble the decimal part with recurrence into parenthesis

            decimalPart = String.valueOf(decimalPartWithoutRecurrence) + "(" + String.valueOf(recurrence) + ")";
        } else {
            char[] decimalPartWithoutRecurrence = new char[index];
            System.arraycopy(decimals, 0, decimalPartWithoutRecurrence, 0, index);
            decimalPart = String.valueOf(decimalPartWithoutRecurrence);
        }
    }

    public int getRecurrenceLength () {
        return recurrenceLength;
    }

    /**
     * Returns the decimal value of the fraction, omitting the decimal delimiter if the decimal part is empty
     */
    public String getStringValueWithRecurrence () {
        if(decimalPart.isEmpty()) {
            return integerPart;
        } else {
            return integerPart + "." + decimalPart;
        }
    }
}
