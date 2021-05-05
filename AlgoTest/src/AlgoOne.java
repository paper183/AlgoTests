
public class AlgoOne {
	
	private boolean loopState;
	
	public AlgoOne(int[] arrInt) {
		setLoopState(true);
		
	}
	
	public int[] run() {
		
		//System.out.println("Start 1 : " + Arrays.toString(arrInt));
		
		while (isLoopState()) {
			setLoopState(false);
			for (int i = 0; i < arrInt.length - nbLoops; i++) {
				if ((i + 1 != arrInt.length) && (arrInt[i] > arrInt[i+1])) {
					int temp = arrInt[i];
					arrInt[i] = arrInt[i + 1];
					arrInt[i + 1] = temp;
					setLoopState(true);
				}
				//System.out.println("For " + i + " : " + Arrays.toString(arrInt));
				nbOps++;
			}
			nbLoops++;
		}
		
		//System.out.println("Number of operations 1 : " + nbOps);
		return arrInt;
	}

	public boolean isLoopState() {
		return loopState;
	}

	public void setLoopState(boolean loopState) {
		this.loopState = loopState;
	}
}
