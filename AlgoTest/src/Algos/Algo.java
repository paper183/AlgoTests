package Algos;

//Superclass for algorithms containing all the necessary methods and variables to test them
public class Algo {
	
	protected int[] arrInt;
	protected boolean loopState = true;
	
	protected boolean isBench = false;
	protected int nbOps = 0;
	protected long startTime, endTime, duration;
	
	public Algo() {
		this.arrInt = null;
		loopState = false;
	}
	
	public Algo(int[] arrInt) {
		this.arrInt = arrInt;
	}
	
	public Algo(int[] arrInt, boolean isBench) {
		this.arrInt = arrInt;
		this.isBench = isBench;
	}
	
	//To override in specific algorithm class
	//Most of the algorithms execution should be done in this method
	public void run() { }
	
	public void startBench() {
		isBench = true;
		nbOps = 0;
		startTime = System.nanoTime();
	}
	
	public void endBench() {
		endTime = System.nanoTime();
		duration = (endTime - startTime);
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
