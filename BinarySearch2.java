
public class BinarySearch2 {

	public static int binarySearch2(int n, int[] array, int lowBound, int highBound) {
		int middleIndex = (int)Math.floor((highBound + lowBound)/2);
		
		if (highBound - lowBound == 0) {
			if (array.length == 0) {
				return -1;
			}
			
			else if (array[middleIndex] == n ) {
				return middleIndex;
			}
			
			else {
				return -1;
			}
		}
		
		if (array[middleIndex] < n) {
			lowBound = middleIndex + 1;
		}
		if (array[middleIndex] > n) {
			highBound = middleIndex -1;
		}
		return binarySearch2(n, array, lowBound, highBound);
	}

}
