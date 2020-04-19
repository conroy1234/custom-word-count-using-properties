package org.exc.rev.model;

public class testingBean {

	private int maxnumber;
	private int minnumber;
	
	
	
	public testingBean(int maxnumber, int minnumber) {		
		this.maxnumber = maxnumber;
		this.minnumber = minnumber;
	}
	public int getMaxnumber() {
		return maxnumber;
	}
	public void setMaxnumber(int maxnumber) {
		this.maxnumber = maxnumber;
	}
	public int getMinnumber() {
		return minnumber;
	}
	public void setMinnumber(int minnumber) {
		this.minnumber = minnumber;
	}
	@Override
	public String toString() {
		return "testingBean [maxnumber=" + maxnumber + ", minnumber=" + minnumber + "]";
	}
	
	
}
