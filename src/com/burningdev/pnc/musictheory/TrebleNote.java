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
public enum TrebleNote implements Note {
	C("C", 0, "C5h", 0, Const.LL_NONE, Note.NONE), D("D", 2, "D5h", -0.5, Const.LL_NONE, Note.NONE), E("E", 4, "E5h", -1, Const.LL_NONE, Note.NONE),
	F("F", -7, "F4h", 2, Const.LL_NONE, Note.NONE), G("G", -5, "G4h", 1.5, Const.LL_NONE, Note.NONE), A("A", -3, "A4h", 1, Const.LL_NONE, Note.NONE),
	H("B", -1, "B4h", 0.5, Const.LL_NONE, Note.NONE),
	//
	ED("E", -8, "E4h", 2.5, Const.LL_NONE, Note.DOWN),
	DD("D", -10, "D4h", 3, Const.LL_NONE, Note.DOWN),
	CD("C", -12, "C4h", 3.5, Const.LL_DOWN_ONE, Note.DOWN),
	BD("B", -13, "B3h", 4, Const.LL_DOWN_ONE, Note.DOWN),
	AD("A", -15, "A3h", 4.5, Const.LL_DOWN_TWO, Note.DOWN),
	//
	FU("F", 5, "F5h", -1.5, Const.LL_NONE, Note.UP),
	GU("G", 7, "G5h", -2, Const.LL_NONE, Note.UP),
	AU("A", 9, "A5h", -2.5, Const.LL_UP_ONE, Note.UP),
	BU("B", 11, "B5h", -3, Const.LL_UP_ONE, Note.UP),
	CU("C", 12, "C6h", -3.5, Const.LL_UP_TWO, Note.UP);

	/**
	 * Contructor
	 * 
	 * @param title is the title from the note, e.g. C. It just contains a letter, no information about the octave.
	 * @param key is the difference from the current note to C5. C5 has the key 60, so for Example D5 must have 2, because it is 2 notes above C5.
	 * @param sound is the name of the sound, which will be played. It has the following pattern: {Note}{Octave}h
	 * @param yShift is the y position on the sheet of music
	 * @param ledgerLine is the information, if the note needs a ledger line. This is the case, for example, with B3
	 */
	private TrebleNote(final String title, final int key, String sound, final double yShift, final int ledgerLine, final int noteLocation) {
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