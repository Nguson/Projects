/*
*MoonSamples.java
*
*Martians want a program to help them analyze the soil on Mars. They want to determine the
best areas to grow crops.
*
*Minh Nguyen
* 10/25/21
*CMSC 255-001
 */


package Projects.MoonSample;

public class MoonSamples {
    public static void main(String[] args) {
        //String of the samples needed for project.
        String samples = "8.3,4.5,6.7,2.3,12.5,4.5<>" +
                        "3.9,1.8,34.7,23.5,1.2,14.3<>" +
                        "6.7,7.4,1.5,18.4,7.2,23.7<>" +
                        "23.4,5.6,2.9,18.5,39.5,18.2<>" +
                        "15.4,5.3,27.4,9.8,3.8,27.4";

        //This stores the data from the getElements method into a new string
        String[] elements = getElements("carbon-dioxide,magnesium,sodium,potassium,chloride,water");

        //This all stores data from methods into new arrays
        double[][] sample1 = getSamples(samples);
        int[] life = searchForLife(sample1);

        //This is the sample run
        System.out.print("The samples that contain life are: ");
        //I used a for each loop to print out the data in the array. The array only has 2 elements so it will only print
        //2 values
        for(int test : life){
            System.out.print(test + " ");
        }
        //prints out the rest of the sample run. I put the method inside the System.out.println
        System.out.println(" ");
        System.out.println(("The highest elements for sample 1 are " + searchHighestElements(sample1, elements, 1)));
        System.out.println("The sample with the highest value of the element water is " + searchHighestSample(sample1, elements, "water"));



    }
    //First method breaks apart a string "" into a String array. each string separated by "," is an element in the array
    public static String[] getElements(String inputElementString) {
            //This is the split
        String[] newElements = inputElementString.split(",");


        return newElements;
    }
    //This method I used to get a 2d array of the samples. Each row was separated by <> and each column was separated by ,
    public static double[][] getSamples(String inputSamplesString) {
        //I first the string by <>, then split the already split string by ,
        //I might have mixed up variable names, for columns and rows
        String[] columns = inputSamplesString.split(("<>"));
        String[] row = columns[0].split(",");
        //I created a new array to return with the length of it being the strings I split up.
        double[][] newSample = new double[columns.length][row.length];
        //For loop goes through all the data for columns and rows
        for (int i = 0; i < columns.length; i++) {
            for (int j = 0; j < row.length; j++) {
                //I copied data into my new array
                newSample[i][j] = Double.parseDouble(row[j]);
            }
            //also checks if i is less than the columns length, then splits row
            if (i < columns.length - 1) {
                row = columns[i + 1].split(",");
            }
        }

        return newSample;
    }
        //This method searches each row if it is compatible with the life formula.
    public static int[] searchForLife(double[][] samples) {
        //declaring variables to save
        double life = 300;
        double lifeTest;
        double[] newLife = new double[samples.length];
        int count = 0;
        //For loops to go through the array
        for (int i = 0; i < samples.length; i++) {
            //saved formula data into newlife
            lifeTest = (8 * samples[i][0]) + (2 * samples[i][1]) + samples[i][2] + (4 * samples[i][3]) + samples[i][4] + (5 * samples[i][5]);
            newLife[i] = lifeTest;
            //tests if the formula for that array is bigger than 300
            if (lifeTest >= life) {
                count++;
            }
        }
        //declared the Int array so It can be returned
        int[] array = new int[count];
        int j = 0;
        for (int i = 0; i < newLife.length; i++) {
            if (newLife[i] >= life) {
                array[j] = i + 1;
                j++;
            }
        }

        return array;
    }
        //This returns a string of the 2 highest elements
    public static String searchHighestElements(double[][] samples, String[] elements, int sampleNum) {
        // creation of variables
        double highest = samples[0][0];
        double secondhighest = samples[0][0];
        int o = 0;
        int p = 0;
        //loop goes through every column for the sample number to find the highest value
        for (int i = 0; i < samples[sampleNum-1].length; i++) {
            if (samples[sampleNum-1][i] > highest) {
                highest = samples[sampleNum-1][i];
                //record what value i is when it is the max value for samples array
                o = i;
            }
        }
        //same loop as first but added != o so i don't get the same values twice
        for (int i = 0; i < samples[sampleNum-1].length; i++) {
            if (samples[sampleNum-1][i] > secondhighest && i != o) {
                secondhighest = samples[sampleNum-1][i];
                p = i;
            }
        }
            //this is the string that's returned using the variables that were saved.
        return elements[o] + " and " + elements[p];
    }
        //This loop finds the highest sample by searching a column of data of a specific element
        public static int searchHighestSample (double[][] samples, String[] elements, String element){
        //declaration of variables
            double max = 0;
            int whereElement = -1;
            int whereSample = 0;
            //first loop looks for the specific column that correlates with the element name
            //and saves that column number into where element
            for (int i = 0; i < elements.length; i++) {
                if (element.equals(elements[i])) {
                    whereElement = i;
                }
            }
            // this is a check for non existent data
            if (whereElement == -1) {
                return -1;
            }
            //This loop checks for the largest number in the specific column of the element
            //and sets the row location of that biggest number in the specific column
            //into whereSample and it is returned.
            for (int i = 0; i < samples.length; i++) {
                if (max < samples[i][whereElement]) {
                    max = samples[i][whereElement];
                    whereSample = i+1;
                }
            }

            return whereSample;
        }

}


