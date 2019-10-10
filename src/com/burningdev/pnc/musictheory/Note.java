package com.burningdev.pnc.musictheory;

public interface Note {
	public static final int NONE = 0;
	public static final int UP = 1;
	public static final int DOWN = 2;
	
	public String getTitle();
	public int getKey();
	public String getSound();
	public double getYShift();
	public int getLedgerLine();
	public int getNoteLocation();
}
