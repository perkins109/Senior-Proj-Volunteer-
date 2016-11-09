import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class haversine {
    public static final double R = 6372.8; // In kilometers
    public static double haversine(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
 
        double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return R * c;
    }
    public static void main(String[] args) {
    	Map<Double,Double> locations = new HashMap<Double,Double>();
    	locations.put(36.12, -86.67);
    	locations.put(33.94, -118.40);
    	locations.put(32.84, -94.74);
    	locations.put(39.8314, 75.0977);
    	locations.put(39.3501, 74.8913);
    	locations.put(38.9102, -118.9341);
    	locations.put(37.31, -119.1230);
    	locations.put(40.4123, -118.1239);
    	Set<Double> keys = locations.keySet();
    	double baselat = 36.12;
    	double baselong = -86.67;
    	for(Double d : keys)
    		System.out.println("Location 2: " + d + " " + locations.get(d) + " \nDistance between: " + haversine(baselat, baselong,d,locations.get(d)) + " km.");
    }
}