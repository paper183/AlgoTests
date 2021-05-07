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
		
		while (loopState) {
			loopState = false;
			for (int i = 0; i < arrInt.length - nbLoops; i++) {
				if ((i + 1 != arrInt.length) && (arrInt[i] > arrInt[i+1])) {
					int temp = arrInt[i];
					arrInt[i] = arrInt[i + 1];
					arrInt[i + 1] = temp;
					loopState = true;
				}
				if (isBench) nbOps++;
			}
			nbLoops++;
		}

	}
	
	@Override
	public void setArrInt(int[] arrInt) {
		this.arrInt = arrInt;
		loopState = true;
		nbLoops=0;
	}

}
