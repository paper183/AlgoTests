import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import Algos.Algo;
import Algos.AlgoOne;
import Algos.AlgoTwo;
import Algos.Utils;

public class AlgoTest {
	


	public static void main(String[] args) {
		final int minLength = 20;
		final int maxLength = 40;
		final int minVal = 1;
		final int maxVal = 1000;
		final int repeat = 10000000;
		final boolean debug = false;
		
		int[][] arrays = generateArrays(minLength, maxLength, minVal, maxVal, repeat);
		
		System.out.println("==== Algo One ====");
		runBench(new AlgoOne(null, true), arrays, debug);
		
		System.out.println("==== Algo Two ====");
		runBench(new AlgoTwo(null, true), arrays, debug);
		
	}
	
	private static void runBench(Algo algo, int[][] arrays, boolean debug) {
		long itTime = 0;
		long itOps = 0;
		int times = arrays.length;

		for (int i = 0; i < times; i++) {
			
			algo.setArrInt(arrays[i].clone());
			
			if (debug) System.out.println("Start : " + Arrays.toString(algo.getArrInt()));
			
			algo.startBench();
			algo.run();
			algo.endBench();
			
			if (debug) System.out.println("End : " + Arrays.toString(algo.getArrInt()));
			
			itOps += algo.getNbOps();
			itTime += algo.getDuration();
		}
		
		System.out.println("Time total : " + itTime + " || " + itTime/1000000 + " ms");
		System.out.println("Ops total : " + itOps);
		itOps = itOps/times;
		itTime = itTime/times;
		System.out.println("Time AVG : " + itTime);
		System.out.println("Ops AVG : " + itOps);
	}
	
	private static int[][] generateArrays(int minLength, int maxLength, int minVal, int maxVal, int times) {
		int[][] arrays = new int[times][];
		
		for (int i = 0; i < times; i++) {
			arrays[i] = Utils.randomArray(minLength, maxLength, minVal, maxVal);
		}
		return arrays;
	}

}
