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
import com.burngindev.pnc.core.Note;

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

	private boolean showLabels = false;
	
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);

		Graphics2D g = (Graphics2D) graphics;

		g.drawLine(ZERO_X + 5, ZERO_Y + 5, ZERO_X + 500, ZERO_Y + 5);
		g.drawLine(ZERO_X + 5, ZERO_Y + 20, ZERO_X + 500, ZERO_Y + 20);
		g.drawLine(ZERO_X + 5, ZERO_Y + 35, ZERO_X + 500, ZERO_Y + 35);
		g.drawLine(ZERO_X + 5, ZERO_Y + 50, ZERO_X + 500, ZERO_Y + 50);
		g.drawLine(ZERO_X + 5, ZERO_Y + 65, ZERO_X + 500, ZERO_Y + 65);

		g.drawLine(ZERO_X + 5, ZERO_Y + 5, ZERO_X + 5, ZERO_Y + 65);
		g.drawLine(ZERO_X + 6, ZERO_Y + 5, ZERO_X + 6, ZERO_Y + 65);
		g.drawLine(ZERO_X + 500, ZERO_Y + 5, ZERO_X + 500, ZERO_Y + 65);
		g.drawLine(ZERO_X + 499, ZERO_Y + 5, ZERO_X + 499, ZERO_Y + 65);
		
		Image image = null;
		try {
			image = ImageIO.read(new File("images/g_clef.png"));
		} catch (IOException e) {
			Logger.error(e, e.getMessage());
		}
		g.drawImage(image, ZERO_X + 5, ZERO_Y - 35, null);

		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	            RenderingHints.VALUE_ANTIALIAS_ON); 
		
		int x = 0;
		for (Note note : this.notes) {
			if (x <= 13) {
				paintNote(x, note, this.showLabels, g);
				x++;
			}
		}
	}

	/**
	 * Paints a music note
	 * 
	 * @param place is the x place from this note
	 * @param note is the type of note
	 * @param showDesc is the information, if the title of the note should be displayed
	 * @param g is the Graphics2D object of the panel
	 */
	private void paintNote(int place, Note note, boolean showDesc, Graphics2D g) {
		int xShift = place * 30 + 65;

		if(note.getLedgerLine() == Const.LL_MIDDLE) {
			g.drawLine(ZERO_X + xShift, ZERO_Y + (int) (note.getYShift() * 15) + 28, ZERO_X + xShift + 30, ZERO_Y + (int) (note.getYShift() * 15) + 28);
		}
		
		else if(note.getLedgerLine() == Const.LL_UP) {
			g.drawLine(ZERO_X + xShift, ZERO_Y + (int) (note.getYShift() * 15) + 20, ZERO_X + xShift + 30, ZERO_Y + (int) (note.getYShift() * 15) + 20);
		}
		
		else if(note.getLedgerLine() == Const.LL_DOWN) {
			g.drawLine(ZERO_X + xShift, ZERO_Y + (int) (note.getYShift() * 15) + 35, ZERO_X + xShift + 30, ZERO_Y + (int) (note.getYShift() * 15) + 35);
		}
		
		g.drawLine(ZERO_X + xShift + 24, ZERO_Y + (int) (note.getYShift() * 15) + 28, ZERO_X + xShift + 24,
				ZERO_Y + (int) (note.getYShift() * 15) - 20);
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
}
