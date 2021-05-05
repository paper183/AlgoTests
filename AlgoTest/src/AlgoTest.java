import java.util.concurrent.ThreadLocalRandom;

public class AlgoTest {

	//static int[] arOne = {99, 11, 2, 30, 40, 5, 17, 77, 6, 1, 183, 2000, 42, 3};
	//static int[] arOne = {99, 11, 2, 30, 40, 5};
	static int[] arOne = randomArray();
	static int nbOps, nbLoops;
	static boolean loopState;
	static long startTime, endTime, duration;
	static long itTime, itOps;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int times = 100000;
		
		itOps = 0;
		itTime = 0;
		System.out.println("==== Algo One ====");
		for (int i = 0; i < times; i++) {
			arOne = randomArray();
			setup();
			end(algoOne(arOne.clone()));
			itOps += nbOps;
			itTime += duration;
		}
		System.out.println("Time total : " + itTime);
		itOps = itOps/times;
		itTime = itTime/times;
		System.out.println("Time AVG : " + itTime);
		System.out.println("Ops AVG : " + itOps);
		
		itOps = 0;
		itTime = 0;
		System.out.println("==== Algo Two ====");
		for (int i = 0; i < times; i++) {
			arOne = randomArray();
			setup();
			end(algoTwo(arOne.clone()));	
			itOps += nbOps;
			itTime += (duration);
		}
		System.out.println("Time total : " + itTime);
		itOps = itOps/times;
		itTime = itTime/times;
		System.out.println("Time AVG : " + itTime);
		System.out.println("Ops AVG : " + itOps);
		
		
	}
	
	public static void setup() {
		nbOps = 0;
		nbLoops = 0;
		loopState = true;
		startTime = System.nanoTime();
	}
	
	public static void end(int[] arrInt) {
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		//System.out.println("Time : " + duration);
		//System.out.println("Number of operations: " + nbOps);
		//System.out.println("End : " + Arrays.toString(arrInt));
	}
	
	public static int[] randomArray() {
		int length = ThreadLocalRandom.current().nextInt(20, 100 + 1);
		int[] rArray = new int[length];
		
		for (int i = 0; i < length; i++) {
			rArray[i] = ThreadLocalRandom.current().nextInt(1, 1000 + 1);
		}
		
		return rArray;
	}
	
	public static int[] algoOne(int[] arrInt) {
		
		//System.out.println("Start 1 : " + Arrays.toString(arrInt));
		
		while (loopState) {
			loopState = false;
			for (int i = 0; i < arrInt.length - nbLoops; i++) {
				if ((i + 1 != arrInt.length) && (arrInt[i] > arrInt[i+1])) {
					int temp = arrInt[i];
					arrInt[i] = arrInt[i + 1];
					arrInt[i + 1] = temp;
					loopState = true;
				}
				//System.out.println("For " + i + " : " + Arrays.toString(arrInt));
				nbOps++;
			}
			nbLoops++;
		}
		
		//System.out.println("Number of operations 1 : " + nbOps);
		return arrInt;
	}
	
	public static int[] algoTwo(int[] arrInt) {
		
		//System.out.println("Start 2 : " + Arrays.toString(arrInt));
		
		while (loopState) {
			loopState = false;
			for (int i = 0, j = arrInt.length - 1; i < j; i++, j--) {
				if (arrInt[i] > arrInt[j]) {
					int temp = arrInt[i];
					arrInt[i] = arrInt[j];
					arrInt[j] = temp;
					loopState = true;
				}
				//System.out.println("For " + i + " : " + Arrays.toString(arrInt));
				nbOps++;
			}
			nbLoops++;
		}
		
		//System.out.println("Number of operations 2 : " + nbOps);
		
		loopState = true;
		nbLoops = 0;
		//nbOps = 0;
		algoOne(arrInt);
		
		return arrInt;
	}

}
