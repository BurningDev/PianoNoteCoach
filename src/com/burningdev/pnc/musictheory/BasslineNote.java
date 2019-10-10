/*
 * PianoNoteCoach by BurningDev
 */
package com.burningdev.pnc.musictheory;

import com.burngindev.pnc.core.Const;

/**
 * A Note represents a music note from the music theory. 
 * 
 * @author BurningDev
 *
 */
public enum BasslineNote implements Note {
	// C3 = 36; 60 - 24 = 36 
	C("C", -24, "C3h", 1, Const.LL_NONE, Note.NONE), D("D", -22, "D3h", 0.5, Const.LL_NONE, Note.NONE), E("E", -20, "E3h", 0, Const.LL_NONE, Note.NONE),
	F("F", -19, "F3h", -0.5, Const.LL_NONE, Note.NONE), G("G", -17, "G3h", -1, Const.LL_NONE, Note.NONE), A("A", -27, "A2h", 2, Const.LL_NONE, Note.NONE),
	H("B", -25, "B2h", 1.5, Const.LL_NONE, Note.NONE),
	//
	GD("G", -29, "G2h", 2.5, Const.LL_NONE, Note.DOWN),
	FD("F", -31, "F2h", 3, Const.LL_NONE, Note.DOWN),
	ED("E", -32, "E2h", 3.5, Const.LL_DOWN_ONE, Note.DOWN),
	DD("D", -34, "D2h", 4, Const.LL_DOWN_ONE, Note.DOWN),
	CD("C", -36, "C2h", 4.5, Const.LL_DOWN_TWO, Note.DOWN),
	//
	AU("A", -15, "A3h", -1.5, Const.LL_NONE, Note.UP),
	BU("B", -13, "B3h", -2, Const.LL_NONE, Note.UP),
	CU("C", -12, "C4h", -2.5, Const.LL_UP_ONE, Note.UP),
	DU("D", -10, "D4h", -3, Const.LL_UP_ONE, Note.UP),
	EU("E", -8, "E4h", -3.5, Const.LL_UP_TWO, Note.UP);

	/**
	 * Contructor
	 * 
	 * @param title is the title from the note, e.g. C. It just contains a letter, no information about the octave.
	 * @param key is the difference from the current note to C5. C5 has the key 60, so for Example D5 must have 2, because it is 2 notes above C5.
	 * @param sound is the name of the sound, which will be played. It has the following pattern: {Note}{Octave}h
	 * @param yShift is the y position on the sheet of music
	 * @param ledgerLine is the information, if the note needs a ledger line. This is the case, for example, with B3
	 */
	private BasslineNote(final String title, final int key, String sound, final double yShift, final int ledgerLine, final int noteLocation) {
		this.title = title;
		this.key = key;
		this.sound = sound;
		this.yShift = yShift;
		this.ledgerLine = ledgerLine;
		this.noteLocation = noteLocation;
	}

	private String title;
	private int key;
	private String sound;
	private double yShift;
	private int ledgerLine;
	private int noteLocation;

	public String getTitle() {
		return title;
	}

	public int getKey() {
		return key;
	}

	public String getSound() {
		return sound;
	}

	public double getYShift() {
		return yShift;
	}

	public int getLedgerLine() {
		return ledgerLine;
	}

	@Override
	public int getNoteLocation() {
		return this.noteLocation;
	}
}