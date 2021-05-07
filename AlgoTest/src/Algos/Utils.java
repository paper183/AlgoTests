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
	
	//generates times amount of arrays with random numbers
	public static int[][] generateArrays(int minLength, int maxLength, int minVal, int maxVal, int times) {
		
		int[][] arrays = new int[times][];
		
		for (int i = 0; i < times; i++) {
			arrays[i] = Utils.randomArray(minLength, maxLength, minVal, maxVal);
		}
		
		return arrays;
	}
	
	private Utils() {
		
	}
	
}
