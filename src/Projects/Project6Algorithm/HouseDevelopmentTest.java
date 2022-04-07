package Projects.Project6Algorithm;

public class HouseDevelopmentTest {
    public static void main(String[]args){
        Development development1 = new Development("freeze zone", "north polar ice cap", 2023, 20);
        Development development2 = new Development("Crater Field", "Korolev crater", 2072, 100);
        House houses1 = new House("Caroline Budwell", 15, 2754.99, Bedrooms.TWO_BEDROOM, Baths.TWO, Color.GREEN);
        House houses2 = new House("Zach Whitten", 27, 789.45, Bedrooms.STUDIO, Baths.ONE, Color.GRAY);
        House houses3 = new House("Sam Zu", 2, 2500.00, Bedrooms.THREE_BEDROOM, Baths.THREE, Color.WHITE);
        System.out.println(development1.toString());
        System.out.println(development2.toString());
        System.out.println(houses1.toString());
        System.out.println(houses2.toString());
        System.out.println(houses3.toString());

    }

}
