/*
 * PianoNoteCoach by BurningDev
 */
package com.burningdev.pnc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;

import org.jfugue.player.Player;
import org.pmw.tinylog.Logger;

import com.burngindev.pnc.core.Config;
import com.burngindev.pnc.core.MidiHandler;
import com.burngindev.pnc.core.Note;
import com.burningdev.pnc.dialogs.InfoDialog;
import com.burningdev.pnc.views.MainView;
import com.burningdev.pnc.views.SheetPanel;

/**
 * The Controller for the MainView. Is contains the logic.
 * 
 * @author BurningDev
 *
 */
public class MainController implements Callback, ActionListener, KeyListener {
	private MainView mainView;
	private Player player;
	private Config config;

	private List<Note> notes = new ArrayList<>();

	private boolean started = false;

	private int statusAllNotes = 0;
	private int statusFinishedNotes = 0;
	private int statusMistakes = 0;

	public MainController() {
		this.config = new Config(new File("config.properties"));
		this.mainView = new MainView();
		this.mainView.getSheetPanel().setNotes(this.notes);
		this.mainView.getSheetPanel().setShowLabels(this.config.isShowLabels());
		this.player = new Player();

		new MidiHandler(this);

		registerListeners();
	}

	public void open() {
		this.mainView.open();
	}

	@Override
	public void callback(int data1, int data2, int data3) {
		typeKey(data1, "", data2, data3);
		
		if(this.config.isDebugMidiInterface()) {
			this.mainView.getLblDebug().setText("[0] '" + data1 + "'  [1] '" + data2 + "'  [2] '" + data3 + "'");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			switch (e.getActionCommand()) {
			case "start":
				start();
				break;
			case "info":
				InfoDialog dialog = new InfoDialog();
				dialog.setLocationRelativeTo(null);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				break;
			case "options":
				OptionsController optionsController = new OptionsController(this.config);
				optionsController.open();
				break;
			case "exit":
				System.exit(0);
				break;
			default:
				Logger.error("ActionCommand \"" + e.getActionCommand() + "\" not found");
			}
		}
	}

	/**
	 * Registers the listeners for the ui components, like the buttons.
	 */
	private void registerListeners() {
		this.mainView.getBtnExit().addActionListener(this);
		this.mainView.getBtnStart().addActionListener(this);
		this.mainView.getBtnOptions().addActionListener(this);
		this.mainView.getBtnInfo().addActionListener(this);
		this.mainView.getFrame().addKeyListener(this);
	}

	private void start() {
		if(!this.config.isDebugMidiInterface()) {
			this.mainView.getLblDebug().setText("");
		}
		
		this.mainView.getSheetPanel().setShowLabels(this.config.isShowLabels());
		if(this.config.isSecondaryNotesGray()) {
			this.mainView.getSheetPanel().setDesignSecondaryNotes(SheetPanel.DESIGN_GRAY);
		} else {
			this.mainView.getSheetPanel().setDesignSecondaryNotes(SheetPanel.DESIGN_BLACK);
		}
		
		if(this.config.isSecondFourthLineGray()) {
			this.mainView.getSheetPanel().setDesignLines(SheetPanel.DESIGN_GRAY);
		} else {
			this.mainView.getSheetPanel().setDesignLines(SheetPanel.DESIGN_BLACK);
		}
		
		this.statusFinishedNotes = 0;
		this.statusMistakes = 0;

		this.notes.clear();

		for (int i = 0; i < this.config.getAmountNotes(); i++) {
			int index = (int) (Math.random() * (Note.values().length - 1) + 1);
			final Note note = Note.values()[index];

			if (!this.config.isShowLowerNotes() && (note.name().length() >= 2 && note.name().endsWith("D"))) {
				i--;
			} else if (!this.config.isShowUpperNotes() && (note.name().length() >= 2 && note.name().endsWith("U"))) {
				i--;
			} else {
				this.notes.add(Note.values()[index]);
			}
		}

		this.mainView.getSheetPanel().setNotes(this.notes);
		this.mainView.getSheetPanel().repaint();

		this.started = true;
		this.statusAllNotes = this.config.getAmountNotes();
		this.mainView.getStatus().setText("0 / " + this.statusAllNotes);

		this.mainView.getFrame().requestFocus();
	}

	private void typeKey(int key, String keyAsChar, int data2, int data3) {
		if (started == true && (data2 == -112 && data3 != 0)) {
			if (60 + this.notes.get(0).getKey() == key || this.notes.get(0).getTitle().equals(keyAsChar)) {
				if (this.config.isPlaySounds()) {
					String sound = this.notes.get(0).getSound();
					new Thread(new Runnable() {
						public void run() {
							try {
								player.play("T150 " + sound);
							} catch (IllegalStateException e) {

							}
						}
					}).start();
				}
				this.notes.remove(0);
				this.mainView.getSheetPanel().setNotes(this.notes);
				this.mainView.getSheetPanel().repaint();
				this.statusFinishedNotes++;
				this.mainView.getStatus().setText(this.statusFinishedNotes + " / " + this.statusAllNotes);

				if (this.notes.isEmpty()) {
					started = false;
					this.mainView.getStatus().setText("Finished, Mistakes: " + this.statusMistakes);
				}
			} else {
				this.statusMistakes++;
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyChar()) {
		case 'a':
			typeKey(-1, "C", -112, 1);
			break;
		case 's':
			typeKey(-1, "D", -112, 1);
			break;
		case 'd':
			typeKey(-1, "E", -112, 1);
			break;
		case 'f':
			typeKey(-1, "F", -112, 1);
			break;
		case 'g':
			typeKey(-1, "G", -112, 1);
			break;
		case 'h':
			typeKey(-1, "A", -112, 1);
			break;
		case 'j':
			typeKey(-1, "B", -112, 1);
			break;
		default:
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// not in use
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// not in use
	}
}