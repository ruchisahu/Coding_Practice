import java.util.*;

//https://aaronice.gitbook.io/lintcode/sweep-line/number_of_airplanes_in_the_sky
public class AirPlanesInSky {
	public static int countOfAirplanes(List<Interval> airplanes) {
        if (airplanes == null || airplanes.size() == 0) {  
            return 0;  
        }
        List<Point> timePoints = new ArrayList<Point>(airplanes.size() * 2);
        for (Interval flight : airplanes) {
            timePoints.add(new Point(flight.start, 1));
            timePoints.add(new Point(flight.end, -1));
        }

        // Sort the flight time intervals
        Collections.sort(timePoints, new Comparator<Point>() {
            public int compare(Point a, Point b) {
                if (a.time == b.time) {
                    return a.delta - b.delta;
                } else {
                    return a.time - b.time;
                }
            }
        });

        int max = 0;
        int sum = 0;

        // Go through the time points
        for (Point p : timePoints) {
            sum += p.delta;
            max = Math.max(sum, max);
        }

        return max;
    }

	public static void main(String[] args) {
		ArrayList<Interval> input = new ArrayList<Interval>() {
            {
                add(new Interval(4, 5));
                add(new Interval(2, 3));
                add(new Interval(2, 4));
                add(new Interval(3, 5));
            }
        };
        int result = AirPlanesInSky.countOfAirplanes(input);
        System.out.println("Number of airplanes in sky: " + result);


	}

}
