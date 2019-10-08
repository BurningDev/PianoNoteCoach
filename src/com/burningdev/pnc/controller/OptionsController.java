/*
 * PianoNoteCoach by BurningDev
 */
package com.burningdev.pnc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import org.pmw.tinylog.Logger;

import com.burngindev.pnc.core.Config;
import com.burningdev.pnc.views.OptionsView;

/**
 * The Controller for the OptionsView. Is contains the logic.
 * 
 * @author BurningDev
 *
 */
public class OptionsController implements ActionListener {
	private OptionsView optionsView;
	private Config config;

	public OptionsController(final Config config) {
		this.optionsView = new OptionsView();
		this.config = config;

		registerListeners();
	}

	/**
	 * Registers the listeners for the ui components, like the buttons.
	 */
	private void registerListeners() {
		this.optionsView.getBtnSave().addActionListener(this);
		this.optionsView.getBtnClose().addActionListener(this);
	}

	public void open() {
		this.optionsView.open();

		this.optionsView.getCheckEnableSounds().setSelected(this.config.isPlaySounds());
		this.optionsView.getCheckLowerNotes().setSelected(this.config.isShowLowerNotes());
		this.optionsView.getCheckUpperNotes().setSelected(this.config.isShowUpperNotes());
		this.optionsView.getCheckNoteDesc().setSelected(this.config.isShowLabels());
		this.optionsView.getSpinnerAmountNotes().setValue(this.config.getAmountNotes());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			switch (e.getActionCommand()) {
			case "save":
				this.config.setAmountNotes((int) this.optionsView.getSpinnerAmountNotes().getValue());
				this.config.setPlaySounds(this.optionsView.getCheckEnableSounds().isSelected());
				this.config.setShowLabels(this.optionsView.getCheckNoteDesc().isSelected());
				this.config.setShowLowerNotes(this.optionsView.getCheckLowerNotes().isSelected());
				this.config.setShowUpperNotes(this.optionsView.getCheckUpperNotes().isSelected());
				
				this.config.save();
				
				JOptionPane.showMessageDialog(null, "Options successfully saved.", "Options saved", JOptionPane.INFORMATION_MESSAGE);
				break;
			case "close":
				this.optionsView.getFrame().dispose();
				break;
			default:
				Logger.error("ActionCommand \"" + e.getActionCommand() + "\" not found");
			}
		}
	}
}
