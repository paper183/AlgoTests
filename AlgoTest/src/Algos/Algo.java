package Algos;

public class Algo {
	
	protected int[] arrInt;
	protected boolean loopState;
	
	protected boolean isBench;
	protected int nbOps;
	protected long startTime, endTime, duration;
	
	public Algo() {
		this.arrInt = null;
		loopState = false;
		isBench = false;
	}
	
	public Algo(int[] arrInt) {
		this.arrInt = arrInt;
		loopState = true;
		isBench = false;
	}
	
	public Algo(int[] arrInt, boolean isBench) {
		this.arrInt = arrInt;
		loopState = true;
		this.isBench = isBench;
	}
	
	public void run() {
		
	}
	
	public void startBench() {
		isBench = true;
		nbOps = 0;
		startTime = System.nanoTime();
	}
	
	public void endBench() {
		endTime = System.nanoTime();
		duration = (endTime - startTime);
		//System.out.println("Time : " + duration);
		//System.out.println("Number of operations: " + nbOps);
		//System.out.println("End : " + Arrays.toString(arrInt));
	}

	public int[] getArrInt() {
		return arrInt;
	}

	public void setArrInt(int[] arrInt) {
		this.arrInt = arrInt;
		loopState = true;
	}

	public int getNbOps() {
		return nbOps;
	}

	public long getDuration() {
		return duration;
	}

}
