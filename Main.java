import java.lang.Math;

public class Main {

    // The radius of the Earth is 6,371 km. This value will be used throughout, so it's class scoped and not limited to a specific method
    public static double R = 6371;

    public static void main(String[] args) {

        // list variables to be used
        double distParisToSF;
        double dist1To2;
        double dist2To3;
        double dist3To4;
        double dist4To5;
        double dist5To6;
        double dist6To7;
        double dist7To8;
        double dist8To9;
        double dist9To10;
        double dist10To11;
        double dist11To12;
        double dist12To13;
        double totalDist;

        // Display radius of the Earth for reference
        System.out.println("R = " + R + " km");
        System.out.println("------------------------------------------------------------------------");

        // Calculate the distance between Paris and SF to check against given value. We'll call one day "Day ?"
        distParisToSF = calcDist("Day ?",48.8567, 2.3508, 37.783333, -122.41667);
        System.out.printf("The distance from Paris to San Francisco is %.1f km\n", distParisToSF);
        System.out.println("------------------------------------------------------------------------");

        // Coordinate points come from grid on map
        dist1To2 = calcDist("Day 1",25, 15, 23, 20);
        dist2To3 = calcDist("Day 2",23, 20, 21, 24);
        dist3To4 = calcDist("Day 3",21, 24, 20, 27);
        dist4To5 = calcDist("Day 4",20, 27, 19, 35);
        dist5To6 = calcDist("Day 5",19, 35, 21, 46);
        dist6To7 = calcDist("Day 6",21, 46, 23, 56);
        dist7To8 = calcDist("Day 7",23, 56, 25, 65);
        dist8To9 = calcDist("Day 8",25, 65, 28, 70);
        dist9To10 = calcDist("Day 9",28, 70, 32, 73);
        dist10To11 = calcDist("Day 10",32, 73, 34, 74);
        dist11To12 = calcDist("Day 11",34, 74, 36, 74);
        dist12To13 = calcDist("Day 12",36, 74, 39, 74);

        // Calculate the total distance traveled by the hurricane over the course of the 13 days. Display answer to 4 decimal places
        totalDist = dist1To2 + dist2To3 + dist3To4 + dist4To5 + dist5To6 + dist6To7 + dist7To8 + dist8To9 + dist9To10 + dist10To11 + dist11To12 + dist12To13;
        System.out.printf("The total distance traveled by Hurricane Gloria= %.4f km\n", totalDist);
        System.out.println("------------------------------------------------------------------------");
    }

    // Use a method called calcDist to find the distance between two points (called point 1 and point 2) based on the latitude and longitude coordinates from the map
    // Degrees must be converted to radians!

    // Here, latitude and longitude coordinates for points 1 and 2 are in degrees
    public static double calcDist(String dayNumber, double dlat1, double dlong1, double dlat2, double dlong2) {

        // Latitude and longitude coordinates for points 1 and 2 in radians
        double rlat1;
        double rlat2;
        double rlong1;
        double rlong2;
        //Values for a, c, and d (distance)
        double a;
        double c;
        double d;

        // Display point 1 and 2 coordinates in degrees
        System.out.println("The point 1 coordinate in degrees is (" +dlat1 + ", " + dlong1 + ")");
        System.out.println("The point 2 coordinate in degrees is (" +dlat2 + ", " + dlong2 + ")");

        // Convert point 1 and 2 coordinates from degrees to radians. Display in radians
        rlat1 = Math.toRadians(dlat1);
        rlong1 = Math.toRadians(dlong1);
        System.out.println("The point 1 coordinate in radians is (" +rlat1 + ", " + rlong1 + ")");
        rlat2 = Math.toRadians(dlat2);
        rlong2 = Math.toRadians(dlong2);
        System.out.println("The point 2 coordinate in radians is (" +rlat2 + ", " + rlong2 + ")");

        // Solve for "a" using given equation. Display "a" value to 4 decimal places
        a = Math.pow(Math.sin((rlat1-rlat2)/2),2) + Math.cos(rlat1)*Math.cos(rlat2)*Math.pow(Math.sin((rlong1-rlong2)/2),2);
        System.out.printf("a= %.4f\n",a);

        // Solve for "c" using given equation. Display "c" value to 4 decimal places
        c = 2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        System.out.printf("c= %.4f\n", c);

        // Solve for the distance (d) traveled on each day by multiplying R (earth's radius) times c. Return and display "d" value
        d = R*c;
        System.out.println("The distance traveled on " +dayNumber+"= " +d+ " km");
        System.out.println("------------------------------------------------------------------------");
        return d;
    }
}