/*
 * PianoNoteCoach by BurningDev
 */
package com.burningdev.pnc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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

		this.optionsView.getSpinnerAmountNotes().setValue(this.config.getAmountNotes());
		this.optionsView.getCheckEnableSounds().setSelected(this.config.isPlaySounds());
		this.optionsView.getCheckLowerNotes().setSelected(this.config.isShowLowerNotes());
		this.optionsView.getCheckUpperNotes().setSelected(this.config.isShowUpperNotes());
		this.optionsView.getCheckNoteDesc().setSelected(this.config.isShowLabels());
		this.optionsView.getCheckSecondaryNotesGray().setSelected(this.config.isSecondaryNotesGray());
		this.optionsView.getCheckSecondFourthLineGray().setSelected(this.config.isSecondFourthLineGray());
		this.optionsView.getCheckDebugMidi().setSelected(this.config.isDebugMidiInterface());
		this.optionsView.getCheckBarline().setSelected(this.config.isBarLine());
		this.optionsView.getComboBoxRange().setSelectedIndex(this.config.getRange());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			switch (e.getActionCommand()) {
			case "save":
				this.config.setRange((int) this.optionsView.getComboBoxRange().getSelectedIndex());
				this.config.setAmountNotes((int) this.optionsView.getSpinnerAmountNotes().getValue());
				this.config.setPlaySounds(this.optionsView.getCheckEnableSounds().isSelected());
				this.config.setShowLabels(this.optionsView.getCheckNoteDesc().isSelected());
				this.config.setShowLowerNotes(this.optionsView.getCheckLowerNotes().isSelected());
				this.config.setShowUpperNotes(this.optionsView.getCheckUpperNotes().isSelected());
				this.config.setSecondaryNotesGray(this.optionsView.getCheckSecondaryNotesGray().isSelected());
				this.config.setSecondFourthLineGray(this.optionsView.getCheckSecondFourthLineGray().isSelected());
				this.config.setDebugMidiInterface(this.optionsView.getCheckDebugMidi().isSelected());
				this.config.setBarLine(this.optionsView.getCheckBarline().isSelected());

				boolean noError = true;

				try {
					this.config.save();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Options not saved: " + e1.getMessage(), "Error occured",
							JOptionPane.ERROR_MESSAGE);
					Logger.error(e1, e1.getMessage());
					noError = false;
				}

				if (noError) {
					JOptionPane.showMessageDialog(null, "Options successfully saved.", "Options saved",
							JOptionPane.INFORMATION_MESSAGE);
				}
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
