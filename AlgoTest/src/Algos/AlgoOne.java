package Algos;

public class AlgoOne extends Algo {
	
	private int nbLoops = 0;
	
	public AlgoOne() {
		super();
	}
	
	public AlgoOne(int[] arrInt) {
		super(arrInt);
	}
	
	public AlgoOne(int[] arrInt, boolean isBench) {
		super(arrInt, isBench);
	}
	
	@Override
	public void run() {
		
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
				if (isBench) nbOps++;
			}
			nbLoops++;
		}
		//System.out.println("Number of operations 1 : " + nbOps);
	}
	
	@Override
	public void setArrInt(int[] arrInt) {
		this.arrInt = arrInt;
		loopState = true;
		nbLoops=0;
	}

}
