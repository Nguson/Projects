/*
*
*MoonStudy.java
*
*MoonStudy takes in files and contains methods that will return values
* based on the data inside the file.
*
*Minh Nguyen
* 12/9/21
*CMSC 255-001
*
 */
package Projects.Project7;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MoonStudy {

    public static ArrayList<String> openFile(File inputFile) throws FileNotFoundException {
        /*
        Takes in file object and reads data line by line
         */
        Scanner input = new Scanner(inputFile);
        ArrayList<String> File = new ArrayList<>();
        try {
            while(input.hasNextLine())
            {
                File.add(input.nextLine().trim());
            }
        }
        catch(Exception e) {
            System.out.println("Incorrect input filename");
        }
        System.out.println("Input file correct");
        return File;
    }

    public static ArrayList<Moon> createObjects(ArrayList<String> lines) {
        /*
        Creating variables
         */
        ArrayList<Moon> Moons = new ArrayList<>();
        String Name;
        double radius;
        double density;
        double distance;
        String[] TempData;
        for(int i = 0; i < lines.size(); i++)
        {
            TempData = lines.get(i).split("\t");
            Name = TempData[0];
            /*
            If there is incorrect data, it will set the value to 0.0
            It will also catch errors in conversion
             */
            try {
                radius = Double.parseDouble(TempData[1]);
                if(radius < 0)
                {
                    radius = 0.0;
                }
            }
            catch (NumberFormatException e) {
                radius = 0.0;
            }

            try {
                density = Double.parseDouble(TempData[2]);
                if(density < 0)
                {
                    density = 0.0;
                }
            }
            catch (NumberFormatException e) {
                density = 0.0;
            }

            try {
                distance = Double.parseDouble(TempData[3]);
                if(distance < 0)
                {
                    distance = 0.0;
                }
            }
            catch (NumberFormatException e) {
                distance = 0.0;
            }

            Moon moonObjects = new Moon(Name,radius,density,distance);
            Moons.add(moonObjects);
        }
        return Moons;
    }

    public static double findMean(ArrayList<Moon> moons, MoonAttributes attribute) {
        /*
        This method finds the mean of the given moon attributes
         */
        double meanSums = 0.0;
        double mean;

        if (attribute.equals(MoonAttributes.RADIUS)) {
            for(int i = 0; i < moons.size(); i++) {
                meanSums += moons.get(i).getRadius();
            }
        }
        else if (attribute.equals(MoonAttributes.DENSITY)) {
            for(int i = 0; i < moons.size(); i++) {
                meanSums += moons.get(i).getDensity();
            }
        }
        else if (attribute.equals(MoonAttributes.DISTANCE)) {
            for(int i = 0; i < moons.size(); i++) {
                meanSums += moons.get(i).getDistance();
            }
        }
        mean = meanSums / moons.size();
        return mean;
    }

    public static double findHighValue(ArrayList<Moon> moons, MoonAttributes attribute) {
        /*
        Return moons highest attribute as a double
         */
        double highestMoon = 0.0;
        for(int i = 0; i < moons.size(); i++)
        {
            if(attribute.equals(MoonAttributes.RADIUS)) {
                if(moons.get(i).getRadius() > highestMoon) {
                    highestMoon = moons.get(i).getRadius();
                }
            }
            else if (attribute.equals(MoonAttributes.DENSITY)) {
                if(moons.get(i).getDensity() > highestMoon) {
                    highestMoon = moons.get(i).getDensity();
                }
            }
            else if (attribute.equals(MoonAttributes.DISTANCE)) {
                if(moons.get(i).getDistance() > highestMoon) {
                    highestMoon = moons.get(i).getDistance();
                }
            }
        }
        return highestMoon;
    }

    public static Moon findMeanMoon(ArrayList<Moon> moons, MoonAttributes attribute, double meanValue) {
        /*
        Returns the moon attribute that is closest to the mean of the given attribute
         */
        double closest = 100000;
        double distance;
        Moon mMoon = null;
        for (int i = 0; i < moons.size(); i++) {

            if(attribute.equals(MoonAttributes.RADIUS)) {

                distance = Math.abs(moons.get(i).getRadius() - meanValue);
                if (distance < closest) {
                        closest = distance;
                        mMoon = moons.get(i);
                    }
            }
            else if (attribute.equals(MoonAttributes.DENSITY)) {

                distance = Math.abs(moons.get(i).getDensity() - meanValue);
                    if (distance < closest) {
                        closest = distance;
                        mMoon = moons.get(i);
                    }
            }
            else if (attribute.equals(MoonAttributes.DISTANCE)) {

                distance = Math.abs(moons.get(i).getDistance() - meanValue);
                    if (distance < closest) {
                        closest = distance;
                        mMoon = moons.get(i);
                    }
            }
        }
        return mMoon;
    }

    public static ArrayList<Moon> findLowestMoons(ArrayList<Moon> moons, double value, MoonAttributes attribute) {
        /*
        Returns array list with values lower than the values passed in for an attribute
         */
        ArrayList<Moon> lowestMoon = new ArrayList<>();
        for(int i = 0; i < moons.size(); i++) {

            if(attribute.equals(MoonAttributes.RADIUS)) {
                if (moons.get(i).getRadius() < value) {
                    lowestMoon.add(moons.get(i));
                }
            }
            else if (attribute.equals(MoonAttributes.DENSITY)){

                if(moons.get(i).getDensity() < value) {
                    lowestMoon.add(moons.get(i));
                }
            }
            else if (attribute.equals(MoonAttributes.DISTANCE)) {

                if(moons.get(i).getDistance() < value) {
                    lowestMoon.add(moons.get(i));
                }
            }
        }
        return lowestMoon;
    }

    /*
    These 3 methods are WriteOutData methods
     */
    public static void outputToFile(String outputMessage, ArrayList<Moon> moons, PrintWriter out) throws FileNotFoundException {

        out.print(outputMessage);
        for(int i = 0; i < moons.size(); i++) {
            out.print(moons.get(i).toString() + " ");
        }
        out.println("\n");
    }

    public static void outputToFile(String outputMessage, Moon moon, PrintWriter out) throws FileNotFoundException {

        out.println(outputMessage + moon.toString() + "\n");
    }

    public static void outputToFile(String outputMessage, double value, PrintWriter out) throws FileNotFoundException {

        out.println(outputMessage + String.format("%.2f\n", value));
    }

    public static void main(String[] args) {


        File inputFile;
        File outputFile = null;
        ArrayList<String> list = new ArrayList<>();
        try{
            inputFile = new File(args[0]);
            outputFile = new File(args[1]);
            System.out.println("Input file correct");
            list = openFile(inputFile);
        }
        catch (FileNotFoundException e) {
            System.out.println("Incorrect input filename");
        }

        ArrayList<Moon> moons = createObjects(list);
        double meanRadius = findMean(moons,MoonAttributes.RADIUS);
        double highDensity = findHighValue(moons,MoonAttributes.DENSITY);
        Moon meanMoon = findMeanMoon(moons,MoonAttributes.RADIUS,meanRadius);
        try{
            PrintWriter out = new PrintWriter(outputFile);
            System.out.print("Output file correct");
            outputToFile("The mean of radii is: ",meanRadius,out);
            outputToFile("The highest density value is: ",highDensity,out);
            outputToFile("The moon closest to the mean is: ",meanMoon,out);
            outputToFile("The moons below the mean value of radii are: ",findLowestMoons(moons,meanRadius,MoonAttributes.RADIUS),out);
            out.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Incorrect output filename");
        }
    }
}
