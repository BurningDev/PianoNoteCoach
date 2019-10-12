/*
 * PianoNoteCoach by BurningDev
 */
package com.burningdev.pnc.views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import org.pmw.tinylog.Logger;

import com.burngindev.pnc.core.Const;
import com.burningdev.pnc.musictheory.Note;

/**
 * The SheetPanel is used from the MainView. It draws a sheet of music.
 * 
 * @author BurningDev
 *
 */
public class SheetPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private static final int ZERO_X = 40;
	private static final int ZERO_Y = 100;

	private List<Note> notes = new ArrayList<>();
	private int designLines = DESIGN_BLACK;
	private int designSecondaryNotes = DESIGN_BLACK;
	private int range = 0;
	private boolean showLabels = false;
	private boolean barline = false;
	
	public static final int DESIGN_BLACK = 0;
	public static final int DESIGN_GRAY = 1;

	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);

		Graphics2D g = (Graphics2D) graphics;

		if (this.designLines == DESIGN_BLACK) {
			g.drawLine(ZERO_X + 5, ZERO_Y + 5, ZERO_X + 500, ZERO_Y + 5);
			g.drawLine(ZERO_X + 5, ZERO_Y + 20, ZERO_X + 500, ZERO_Y + 20);
			g.drawLine(ZERO_X + 5, ZERO_Y + 35, ZERO_X + 500, ZERO_Y + 35);
			g.drawLine(ZERO_X + 5, ZERO_Y + 50, ZERO_X + 500, ZERO_Y + 50);
			g.drawLine(ZERO_X + 5, ZERO_Y + 65, ZERO_X + 500, ZERO_Y + 65);
		} else if (this.designLines == DESIGN_GRAY) {
			g.setColor(Color.BLACK);
			g.drawLine(ZERO_X + 5, ZERO_Y + 5, ZERO_X + 500, ZERO_Y + 5);
			g.setColor(Color.GRAY);
			g.drawLine(ZERO_X + 5, ZERO_Y + 20, ZERO_X + 500, ZERO_Y + 20);
			g.setColor(Color.BLACK);
			g.drawLine(ZERO_X + 5, ZERO_Y + 35, ZERO_X + 500, ZERO_Y + 35);
			g.setColor(Color.GRAY);
			g.drawLine(ZERO_X + 5, ZERO_Y + 50, ZERO_X + 500, ZERO_Y + 50);
			g.setColor(Color.BLACK);
			g.drawLine(ZERO_X + 5, ZERO_Y + 65, ZERO_X + 500, ZERO_Y + 65);
		}

		if (this.barline) {
			g.drawLine(ZERO_X + 4 * 30 + 65, ZERO_Y + 5, ZERO_X + 4 * 30 + 65, ZERO_Y + 65);
			g.drawLine(ZERO_X + 8 * 30 + 65, ZERO_Y + 5, ZERO_X + 8 * 30 + 65, ZERO_Y + 65);
			g.drawLine(ZERO_X + 12 * 30 + 65, ZERO_Y + 5, ZERO_X + 12 * 30 + 65, ZERO_Y + 65);
		}

		g.drawLine(ZERO_X + 5, ZERO_Y + 5, ZERO_X + 5, ZERO_Y + 65);
		g.drawLine(ZERO_X + 6, ZERO_Y + 5, ZERO_X + 6, ZERO_Y + 65);
		g.drawLine(ZERO_X + 500, ZERO_Y + 5, ZERO_X + 500, ZERO_Y + 65);
		g.drawLine(ZERO_X + 499, ZERO_Y + 5, ZERO_X + 499, ZERO_Y + 65);

		Image image = null;
		try {
			if(this.range == Const.TREBLE) {
				image = ImageIO.read(new File("images/g_clef.png"));
			} else if(this.range == Const.BASSLINE) {
				image = ImageIO.read(new File("images/f_clef.png"));
			}
		} catch (IOException e) {
			Logger.error(e, e.getMessage());
		}
		g.drawImage(image, ZERO_X + 5, ZERO_Y - 35, null);

		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		int x = 0;
		for (Note note : this.notes) {
			if (x <= 13) {
				if (x != 0 && this.designSecondaryNotes == DESIGN_BLACK) {
					paintNote(x, note, this.showLabels, g, Color.BLACK);
					x++;
				} else if (x != 0 && this.designSecondaryNotes == DESIGN_GRAY) {
					paintNote(x, note, this.showLabels, g, Color.GRAY);
					x++;
				} else {
					paintNote(x, note, this.showLabels, g, Color.BLACK);
					x++;
				}
			}
		}
	}

	/**
	 * Paints a music note
	 * 
	 * @param place    is the x place from this note
	 * @param note     is the type of note
	 * @param showDesc is the information, if the title of the note should be
	 *                 displayed
	 * @param c        is the color of the note
	 * @param g        is the Graphics2D object of the panel
	 */
	private void paintNote(int place, Note note, boolean showDesc, Graphics2D g, Color c) {
		int xShift = place * 30 + 65;

		if (note.getLedgerLine() == Const.LL_UP_ONE) {
			g.drawLine(ZERO_X + xShift, ZERO_Y - 10, ZERO_X + xShift + 30, ZERO_Y - 10);
		} else if (note.getLedgerLine() == Const.LL_UP_TWO) {
			g.drawLine(ZERO_X + xShift, ZERO_Y - 10, ZERO_X + xShift + 30, ZERO_Y - 10);
			g.drawLine(ZERO_X + xShift, ZERO_Y - 25, ZERO_X + xShift + 30, ZERO_Y - 25);
		} else if (note.getLedgerLine() == Const.LL_DOWN_ONE) {
			g.drawLine(ZERO_X + xShift, ZERO_Y + 80, ZERO_X + xShift + 30, ZERO_Y + 80);
		} else if (note.getLedgerLine() == Const.LL_DOWN_TWO) {
			g.drawLine(ZERO_X + xShift, ZERO_Y + 80, ZERO_X + xShift + 30, ZERO_Y + 80);
			g.drawLine(ZERO_X + xShift, ZERO_Y + 95, ZERO_X + xShift + 30, ZERO_Y + 95);
		}

		g.setColor(c);
		if(note.getYShift() > 0.5 ) {
			g.drawLine(ZERO_X + xShift + 24, ZERO_Y + (int) (note.getYShift() * 15) + 28, ZERO_X + xShift + 24,
					ZERO_Y + (int) (note.getYShift() * 15) - 20);
		} else {
			g.drawLine(ZERO_X + xShift + 24, ZERO_Y + (int) (note.getYShift() * 15) + 28, ZERO_X + xShift + 24,
					ZERO_Y + (int) (note.getYShift() * 15) + 73);
		}
		
		g.fillOval(ZERO_X + xShift + 5, ZERO_Y + (int) (note.getYShift() * 15) + 20, 20, 15);
		if (showDesc) {
			g.setColor(Color.WHITE);
			g.drawString(note.getTitle(), ZERO_X + xShift + 12, ZERO_Y + (int) (note.getYShift() * 15) + 32);
			g.setColor(Color.BLACK);
		}
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public void setShowLabels(boolean showLabels) {
		this.showLabels = showLabels;
	}

	public void setDesignLines(int designLines) {
		this.designLines = designLines;
	}

	public void setDesignSecondaryNotes(int designSecondaryNotes) {
		this.designSecondaryNotes = designSecondaryNotes;
	}

	public void setBarline(boolean barline) {
		this.barline = barline;
	}

	public void setRange(int range) {
		this.range = range;
	}
}
