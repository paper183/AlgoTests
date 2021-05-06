package Algos;

public class AlgoTwo extends Algo {
	
	public AlgoTwo() {
		super();
	}
	
	public AlgoTwo(int[] arrInt) {
		super(arrInt);
	}

	public AlgoTwo(int[] arrInt, boolean isBench) {
		super(arrInt, isBench);
	}
	
	@Override
	public void run() {
		
		//System.out.println("Start 1 : " + Arrays.toString(arrInt));
		
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
				if (isBench) nbOps++;
			}
		}
		
		AlgoOne algoOne = new AlgoOne(arrInt, isBench);
		
		if (isBench) algoOne.startBench();
		
		algoOne.run();
		
		if (isBench) {
			algoOne.endBench();
			nbOps += algoOne.getNbOps();
			duration += algoOne.getDuration();
		}
		
	}

}
