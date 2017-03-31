public class TurretDefense {
	public int firstMiss(int[] xs, int[] ys, int[] times) {

		int shootdowns = 0;
		int numberofelements = xs.length;		
		int currentx = 0;
		int currenty = 0;
		int currenttime = 0;
		int time_to_move = 0;
		int time_to_aim = 0;

		for (int i = 0; i < numberofelements; i++) {
			int deltax = Math.abs(xs[i] - currentx);
			int deltay = Math.abs(ys[i] - currenty);
			time_to_aim = times[i] - currenttime;
			time_to_move = deltax + deltay;

			if (time_to_move <= time_to_aim) {
				shootdowns+=1;
			} 
			currentx = xs[i];	
			currenty = ys[i];
			currenttime = times[i];			
		}
		if (shootdowns == numberofelements) {
			return -1;
		} else {
			return shootdowns;
		}
		
	}
}