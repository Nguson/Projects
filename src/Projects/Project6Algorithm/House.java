/*
 *House.java
 *
 *class that creates the houses
 *
 * Minh Nguyen
 * 11/11/21
 * CMSC 255-001
 */

package Projects.Project6Algorithm;

public class House {
    /*
    Variables declared for houses
     */
    private String owner;
    private int lotNumber;
    private double squareFootage;
    private Bedrooms bedrooms;
    private Baths baths;
    private Color color;
    /*
    Default constructor
     */
    public House(){
        owner = "";
        lotNumber = 1;
        squareFootage = 500.0;
        bedrooms = Bedrooms.ONE_BEDROOM;
        baths = Baths.ONE;
        color = Color.WHITE;
    }
    /*
    parameterized constructor
     */
    public House(String anOwner, int aLotNumber, double
            aSquareFootage, Bedrooms aBedrooms, Baths aBaths, Color aColor){
        owner = anOwner;
        lotNumber = aLotNumber;
        squareFootage = aSquareFootage;
        bedrooms = aBedrooms;
        baths = aBaths;
        color = aColor;
    }
    /*
     Getters and setters for each variable
     */
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(int lotNumber) {
        this.lotNumber = lotNumber;
    }

    public double getSquareFootage() {
        return squareFootage;
    }

    public void setSquareFootage(double squareFootage) {
        this.squareFootage = squareFootage;
    }

    public Bedrooms getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(Bedrooms bedroom) {
        this.bedrooms = bedroom;
    }

    public Baths getBaths() {
        return baths;
    }

    public void setBaths(Baths bath) {
        this.baths = bath;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    /*
    toString method returns a string with all variables on different lines and rounds squareFootage
     */
    @Override
    public String toString() {
            String output = "\n\t" + owner + "\n\t" + lotNumber + "\n\t" + String.format("%.2f", squareFootage) + "\n\t" + bedrooms + "\n\t" + baths + "\n\t" + color + "\n";
            return output;
    }
}
