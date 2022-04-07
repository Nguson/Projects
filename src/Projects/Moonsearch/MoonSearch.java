/*
* MoonSearch
*
*Calculates the values in each array, and prints it out.
*Minh Nguyen
* 10/17/2021
*CMSC 255-001
 */


package Projects.Moonsearch;
import java.util.Scanner;
public class MoonSearch {
    public static void main(String[]args){
    Scanner input = new Scanner(System.in);
    String[] moon =  {"Phobus","Deimos","Adrastea","Aitne","Amalthea","Ananke","Aoede","Arche" };
    double[] radii = {11.3, 6.2, 68.9, 33.6, 71.2, 26.8, 255.9, 47.4};
    double[] density = {1.8, 1.4, 14.2, 33.3, 16.4, 68.1, 121.3, 38.2};
    double[] distance = {3.7, 23.4, 550391.6, 277894.9, 778893.6, 143323.5, 287223.5, 449655.1};
    //I made a new string to save the data from the method and used it to print the moons
    String[] high2 = findHighestTwo(moon, radii);
    String[] low2 = findLowestTwo(moon, density);
        System.out.printf("The average radius is: %.1f%n",calcAvg(radii));
        System.out.printf("The average density is: %.1f%n", calcAvg(density));
       System.out.printf("The highest radius is: %.1f%n", findHighValue(radii));
       System.out.printf("The lowest distance is: %.1f%n", findLeastValue(distance));
       System.out.println("The highest two moons for radii are:");
       System.out.println(high2[0]);
       System.out.println(high2[1]);
       System.out.println("The lowest two moons for density are:");
       System.out.println(low2[0]);
       System.out.println(low2[1]);
       System.out.println("Enter a moon:");
       String moonName = input.nextLine();
       //Asks user to input a moon name
       findMoon(moon, moonName);
       //This will tell the user if the moon inputed is in the array or not
       if(findMoon(moon, moonName) == true) {
           System.out.println(moonName + " is a moon in the array.");
       }
       else {
           System.out.println(moonName + " is not a moon in the array.");

       }

    }
    // first method calculates the average of the array that gets passed into it.
    public static double calcAvg(double[] array) {
        double average = 0;
        //this for loop goes through every element inside of the array and adds it into a variable.
        for(int i = 0; i < array.length; i++) {
            average += array[i];

        }
        //total amount divided by how many numbers there are = average
        average /= array.length;
        return average;

    }
    // This method finds the highest value of the double arrays
    public static double findHighValue (double[] array) {
       double high = array[0];
       //This for loop checks every element and will only assign the highest number to "high" when the number at i is bigger
       for(int i = 0; i < array.length; i++) {
           if (array[i] > high) {
            high = array[i];
           }
       }
       return high;
    }
    // This method finds the lowest value in the arrays
    public static double findLeastValue(double[] array) {
        double low = array[0];
        //checks which value is lower
        for(int i = 0; i < array.length; i++) {
            if (array[i] > low) {
            }
            //this assigns new value if low is actually bigger than array
            else {
                low = array[i];
            }
        }
        return low;
    }
    //This method returns the name of the moons with the highest values
 public static String[] findHighestTwo(String[] names, double[] array) {
    double firstHigh = array[0];
    double secondHigh = array[0];
    int o = 0;
    int i = 0;
    int y = 0;
    for(i = 0; i < array.length; i++) {
        if (array[i] > firstHigh) {
            firstHigh = array[i];
            o = i;
            //This is the same as findHighValue but i also added another variable "o" and set it equal to i
            //I did this so I can save the value of i into something
        }
    }
    for (i = 0; i < array.length; i++) {
        if(array[i] > secondHigh) {
            if (firstHigh != i && i != o){
                secondHigh = array[i];
                y = i;
                //This is the same for loop, but I added another if statement to not have i in this loop be the same
                // as the i in the other loop
            }
        }
    }
    //I used the values of the passed array and the
     // i values which are [o] and [y] which i saved from the loops
     //and I copied the data at those elements into a new string and returned the new string.
       String[] are = new String[2];
    are[0] = names[o];
    are[1] = names[y];
    return are;
    }
    //This is the same as the highest two but reversed signs
    public static String[] findLowestTwo(String[] names, double[] array) {
        double firstLow = array[0];
        double secondLow = array[0];
        int o = 0;
        int i = 0;
        int y = 0;
        for(i = 0; i < array.length; i++) {
            //reversed sign
            if (array[i] < firstLow) {
                firstLow = array[i];
                o = i;
            }
        }
        for (i = 0; i < array.length; i++) {
            //reversed sign
            if(array[i] < secondLow) {
                if (firstLow != i && i != o){
                    secondLow = array[i];
                    y = i;
                }
            }
        }
            String[] are = new String[2];
        are[0] = names[o];
        are[1] = names[y];
        return are;
    }
    //Method checks if the name of the moon is in the array
    public static boolean findMoon(String[] names, String moon){
        boolean value = false;
        //This goes through every element and if the name is actually in the array
        //it will return true, otherwise it stays false
        for(int i = 0; i < names.length; i++){
            if(names[i].equals(moon)){
                value = true;
            }
        }
        return value;
    }
}
