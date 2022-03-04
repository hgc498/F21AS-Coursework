package base;

import util.DistanceUtils;

public class GPScoordlinate {
	
	public  Double getDistance(Airport a1,Airport a2) {
		return DistanceUtils.getDistance(a1.getLongitude(), a1.getLatitude(), a2.getLongitude(), a2.getLatitude());
		
	}

}
