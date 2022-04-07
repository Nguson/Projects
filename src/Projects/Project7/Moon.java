/*
*
* Moon.java
*
* Creation of the moon object
*
* Minh Nguyen
* 12/9/21
* CMSC 255-001
 */

package Projects.Project7;

public class Moon {

    private String name;
    private double radius;
    private double density;
    private double distance;

    public Moon(){
        this.name = "";
        this.radius = 0;
        this.density = 0;
        this.distance = 0;
    }

    public Moon(String aName, double aRadius, double aDensity, double aDistance){
        name = aName;
        radius = aRadius;
        density = aDensity;
        distance = aDistance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
    public String toString() {
        String name1 = name;
        String output = name1 + " " + String.format("%.2f", this.radius) + " " + String.format("%.2f", this.density) + " " + String.format("%.2f", this.distance);
        return output;
    }
}
