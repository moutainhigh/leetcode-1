public class Solution {
	public int minRefuelStops(int target, int startFuel, int[][] stations) {
		int[] refuelTimeToMaxDistance = new int[stations.length + 1];
		refuelTimeToMaxDistance[0] = startFuel;
		for (int i = 0; i < stations.length; i++) {
			for (int refuelTime = refuelTimeToMaxDistance.length - 2; refuelTime >= 0; refuelTime--) {
				if (refuelTimeToMaxDistance[refuelTime] >= stations[i][0]) {
					refuelTimeToMaxDistance[refuelTime + 1] = Math.max(refuelTimeToMaxDistance[refuelTime + 1],
							refuelTimeToMaxDistance[refuelTime] + stations[i][1]);
				}
			}
		}

		for (int refuelTime = 0; refuelTime < refuelTimeToMaxDistance.length; refuelTime++) {
			if (refuelTimeToMaxDistance[refuelTime] >= target) {
				return refuelTime;
			}
		}
		return -1;
	}
}
