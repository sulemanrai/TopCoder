public class WidgetRepairs {
	int days_to_operature = 0;
	int remaining_work = 0;

	public int days(int[] arrivals, int numPerDay) {
		for (int count = 0; count <= arrivals.length - 1; count++) {

			arrivals[count] += remaining_work;
			if (count <= arrivals.length - 2 && arrivals[count] >= numPerDay) {				
					days_to_operature++;
				
			} else if (count <= arrivals.length - 2 && arrivals[count] < numPerDay) {
				if (arrivals[count] != 0) {
					days_to_operature++;
				}
			} else if (count == arrivals.length - 1) {
				days_to_operature += returnlastcount(arrivals[count],numPerDay);
			}
			if (arrivals[count] > numPerDay) {
				remaining_work = arrivals[count] - numPerDay;
			} else {
				remaining_work = 0;
			}

		}

		// days_to_operature = count;
		return days_to_operature;
	}

	int returnlastcount(int number, int numPerDay) {
		int result=0;
		if (number % numPerDay == 0) {
			result = (number/numPerDay);			
		} else {
			result = (number/numPerDay) + 1 ;
		}
		return result;
	}
}
