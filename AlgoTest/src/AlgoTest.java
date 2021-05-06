import java.util.Arrays;
import Algos.Algo;
import Algos.AlgoOne;
import Algos.AlgoTwo;
import Algos.Utils;

public class AlgoTest {

	public static void main(String[] args) {
		final int minLength = 20; 		//minimum length of the arrays to sort
		final int maxLength = 40; 		//maximum length of the arrays to sort
		final int minVal = 1;			//min value of numbers in the arrays
		final int maxVal = 1000;		//max value of numbers in the array
		final int repeat = 1000000;		//number of arrays to sort for the test
		final boolean debug = false;	//true shows more info in the console
		
		int[][] arrays = Utils.generateArrays(minLength, maxLength, minVal, maxVal, repeat);
		
		System.out.println("==== Algo One ====");
		runBench(new AlgoOne(), arrays, debug);
		
		System.out.println("==== Algo Two ====");
		runBench(new AlgoTwo(), arrays, debug);
		
	}
	
	//Run test on Algo object using run() method for all the arrays in second argument
	//Starts bench variables of the object to get number of operations and time in nanoseconds
	//if debug is true it shows initial array and result array
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

}
