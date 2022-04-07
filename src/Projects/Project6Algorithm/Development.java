/*
*Development.java
*
* Development that holds the houses
*
* Minh Nguyen
* 11/11/21
* CMSC 255-001
 */


package Projects.Project6Algorithm;

import java.util.ArrayList;

public class Development {
    /*
    Variables
     */
    private String name;
    private String location;
    private int yearEst;
    private int numLots;
    private ArrayList<House> houses;
    /*
    default Constructor
     */
    public Development(){
        name = "";
        location = "";
        yearEst = 0;
        numLots = 0;
        houses = new ArrayList<>();
    }
    /*
    Parameterized Constructor
     */
    public Development(String aName, String aLocation, int aYearEst, int aNumLots){
        name = aName;
        location = aLocation;
        yearEst = aYearEst;
        numLots = aNumLots;
        houses = new ArrayList<>();
    }
    /*
    Getter
     */
    public String getName() {
        return name;
    }
    /*
    Setter
     */
    public void setName(String name) {
        this.name = name;
    }
    /*
    Getter
     */
    public String getLocation() {
        return location;
    }
    /*
    Setter
     */
    public void setLocation(String location) {
        this.location = location;
    }
    /*
    Getter
     */
    public int getYearEst() {
        return yearEst;
    }
    /*
    Setter
     */
    public void setYearEst(int yearEst) {
        this.yearEst = yearEst;
    }
    /*
    Getter
     */
    public int getNumLots() {
        return numLots;
    }
    /*
    Setter
     */
    public void setNumLots(int numLots) {
        this.numLots = numLots;
    }
    /*
    Method that adds 1 house into house array
     */
    public void addHouse(House one){
        houses.add(one);
    }
    /*
    Array that gets the amount of houses in the array
     */
    public int getNumHouses(){
        return houses.size();
    }
    /*
    returns house ArrayList
     */
    public ArrayList<House> getHouses(){
        return houses;
    }
    /*
    ToString Method returns data variables using for loop
    goes through ArrayList and adds it into output, then returns it.
     */
    public String toString() {
        String output = name + "\n" + location + "\n" + yearEst + "\n" + numLots + "\n" + "Houses:\n";
        for (int i = 0; i < houses.size(); i++) {
            output += houses.get(i).toString();
        }
        return output;
    }
}
