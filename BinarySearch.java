
public class BinarySearch {

	public static int binarySearch(int n, int[] array) {
		// return the index of the target number in a sorted array of integers in logarithmic time
		
		int length = array.length;
		
		if (length == 0) {
			return -1;
		}
		
		int lowBound = 0;
		int highBound = length -1 ;
		int middleIndex = (int)Math.floor((lowBound + highBound)/2);
		while(highBound - lowBound > 0) {
			if (n > array[middleIndex]) {
				lowBound = (int)Math.floor(array.length/2) + 1;
				middleIndex = (int)Math.floor((lowBound + highBound)/2);
			}
			else if (n < array[middleIndex]) {
				highBound = (int)Math.floor(array.length/2) - 1;
				middleIndex = (int)Math.floor((lowBound + highBound)/2);
			}
			else {
				return middleIndex;
			}
		}
		
		if (n == array[middleIndex]) {
			return middleIndex;
		}
		else {
			return -1;
		}
		
		
		//1 2 4 5
		//1 2 3 4			
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
