
public class HowManyBits {

	public static int howManyBits(int x) {
		// TODO Auto-generated constructor stub
		int count = 0;
		
		while (x != 0) {
			if ((x&1) == 1) {
				count ++;
			}
			x >>>= 1;
			// x = x >>> 1
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(howManyBits(7));
		System.out.println(Integer.toBinaryString(-16>>>2));
		System.out.println(Integer.toBinaryString(-16>>2));
	}

}
