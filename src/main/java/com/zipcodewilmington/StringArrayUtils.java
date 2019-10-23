package com.zipcodewilmington;

import java.sql.SQLOutput;
import java.util.*;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length - 1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length - 2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        for (int i = 0; i <= array.length - 1; i++) {
            //only finding the value once is necessary since we then know it is included
            if (array[i].equals(value)) {
                return true;
            }
        }
        return false;
        //List<String> arrayList = Arrays.asList(array);
        //return arrayList.contains(value);
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        List<String> reverseList = Arrays.asList(array);
        Collections.reverse(reverseList);
        return reverseList.toArray(new String[reverseList.size()]);
    }


        /*//create a new array that you intend to be reversed
        String[] reversedArray = new String[array.length];
        //create a decling counter that starts the the length of the array - 1
        int decliningCounter = array.length - 1;
        for (int i = 0; i <= array.length - 1; i++) {
            //move through the array and add the value at the declining counter position to the reversed array
            reversedArray[i] = array[decliningCounter];
            //decline the declining counter
            decliningCounter--;
        }
        return reversedArray;

        //List<String> arrayList = Arrays.asList(array);
        //return arrayList.reverse();
    }*/


    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        //create a String array intended to reverse
        String[] reverseArray = new String[array.length];
        //create a int to count up through array
        int valueCounter = 0;
        //use a forloop backwards through the array to create the reverse string
        for (int i = array.length - 1; i >= 0; i--) {
            reverseArray[i] = (array[valueCounter]);
            valueCounter++;
        }

        return Arrays.equals(array, reverseArray);
    }



    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        //create an array of UPPERCASE and LOWERCASE alphabet
        String[] alpha = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
                "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        ;
        //turn the array into an String, remove the spaces, and change everything to a lower case
        String arrayString = String.join(" ", array).replaceAll(" ", "").toLowerCase();

        //search through the alphabet array
        for (int i = 0; i <= alpha.length - 1; i++) {
            //see if the array list DOESN'T contain the current letter
            //arrayString.indexOf(alpha[i]) == -1 also works since indexOf() = -1 means the value is not in the array
            if (!arrayString.contains(alpha[i])) {
                //return false if it does not
                return false;
            }
        }
        //if the loop finishes without returning false, return true;
        return true;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        //create occurrence counter
        int occurrenceCounter = 0;
        for (int i = 0; i <= array.length - 1; i++) {
            //test if the value at i is equal to the value you are looking for
            if (array[i].equals(value)) {
                //add to the occurrence counter if it does
                occurrenceCounter++;
            }
        }
        return occurrenceCounter;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        //make a list since you'll have to change the length
        List<String> removedString = new ArrayList<>();
        //create a counter that matches how many times
        int valueCounter = 0;
        //run a forEach loop checking each String within the array
        for (String value : array) {
            //if the current value is NOT equal to the valueToRemove
            if (!valueToRemove.equals(value)) {
                //add it to your list
                removedString.add(value);
            } else {
                //up your counter
                valueCounter++;
            }
        }
        /*initialize a new array that you want your list to be converted into
        the dimensions will be equal to the length of the original array
        minus the number of times valueToRemove appeared, seeing that
        it will be that much shorter.
        our tests are always equal to one, but other examples beyond our test
        might have more than one occurrence*/
        String[] finalArray = new String[array.length - valueCounter];
        //convert your new list back into an array and return it
        return removedString.toArray(finalArray);
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        //create a list
        List<String> removedString = new ArrayList<>();
        //add the first element of the array to the list since it is ALWAYS guaranteed to be in there
        removedString.add(array[0]);
        //move through the array starting at 1 since we already added element zero
        for(int i = 1 ; i <= array.length - 1;i++){
            //check to see if the current position is NOT equal to the previous
            if(!array[i].equals(array[i - 1])) {
                //if it's not, add the element to the array
                removedString.add(array[i]);
            }
        }
        return removedString.toArray(new String[removedString.size()]);
    }
        /*This does not work because it removes ALL duplicates, not just consecutive ones
        Still, it is interesting and worth keeping around thanks to alumni help

        create an empty Set
        Set<String> removedSet = new LinkedHashSet<>();
        //create a for loop to search through the array
        removedSet.addAll(Arrays.asList(array));

        String[] finalArray = new String[removedSet.size()];
        return removedSet.toArray(finalArray);*/


    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        //create a list
        List<String> removedString = new ArrayList<>();
        //create a temporary string to assign values to
        //assign the first value to it to start
        String tempString = array[0];
        //start from 1 in the for loop since we've already looked at the first value
        for(int i = 1; i <= array.length; i++){
            //test to see if the current value in the array is equal to the previous
            if(array[i].equals(array[i - 1])){
                //if they are equals, all the value to the temp string
                tempString += array[i];
                } else {
                //if they are not equal, add it to the list
                removedString.add(tempString);
                //change the value of temp string to the new non-consecutive value
                tempString = array[i];
            }
        }
        //add the final value to your array
        removedString.add(tempString);
        //return the final list converted into an array
        return removedString.toArray(new String[removedString.size()]);
    }
}