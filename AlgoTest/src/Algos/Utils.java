package Algos;
import java.util.concurrent.ThreadLocalRandom;

public final class Utils {
	
	public static int[] randomArray(int minLength, int maxLength, int minVal, int maxVal) {
		int length = ThreadLocalRandom.current().nextInt(minLength, maxLength + 1);
		int[] rArray = new int[length];
		
		for (int i = 0; i < length; i++) {
			rArray[i] = ThreadLocalRandom.current().nextInt(minVal, maxVal + 1);
		}
		
		return rArray;
	}
	
	private Utils() {
		
	}
}
