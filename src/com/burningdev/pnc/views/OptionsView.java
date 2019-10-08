/*
 * PianoNoteCoach by BurningDev
 */
package com.burningdev.pnc.views;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.Toolkit;

/**
 * The OptionsView has all settings from this application.
 * 
 * @author BurningDev
 *
 */
public class OptionsView {

	private JFrame frame;

	private JCheckBox checkUpperNotes;
	private JCheckBox checkLowerNotes;
	private JCheckBox checkNoteDesc;
	private JCheckBox checkEnableSounds;
	
	private JSpinner spinnerAmountNotes;
	
	private JButton btnClose;
	private JButton btnSave;
	
	public void open() {
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public OptionsView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(OptionsView.class.getResource("/com/burningdev/pnc/res/Icon.png")));
		frame.setResizable(false);
		frame.setTitle("Options");
		frame.setBounds(100, 100, 450, 340);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelNotes = new JPanel();
		panelNotes.setBorder(new TitledBorder(null, "Notes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelNotes.setBounds(10, 11, 424, 146);
		frame.getContentPane().add(panelNotes);
		panelNotes.setLayout(new BoxLayout(panelNotes, BoxLayout.Y_AXIS));
		
		checkUpperNotes = new JCheckBox("Show upper notes (F5 - C6)");
		panelNotes.add(checkUpperNotes);
		
		checkLowerNotes = new JCheckBox("Show lower notes (A3 - E4)");
		panelNotes.add(checkLowerNotes);
		
		checkNoteDesc = new JCheckBox("Display note description (e.g. G)");
		panelNotes.add(checkNoteDesc);
		
		JPanel panelAmountNotes = new JPanel();
		panelNotes.add(panelAmountNotes);
		panelAmountNotes.setLayout(null);
		
		spinnerAmountNotes = new JSpinner();
		spinnerAmountNotes.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinnerAmountNotes.setBounds(4, 3, 41, 20);
		panelAmountNotes.add(spinnerAmountNotes);
		
		JLabel lblAmountOfNotes = new JLabel("Amount of notes");
		lblAmountOfNotes.setBounds(55, 6, 177, 14);
		panelAmountNotes.add(lblAmountOfNotes);
		
		JPanel panelMisc = new JPanel();
		panelMisc.setBorder(new TitledBorder(null, "Misc", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelMisc.setBounds(10, 168, 424, 84);
		frame.getContentPane().add(panelMisc);
		panelMisc.setLayout(new BoxLayout(panelMisc, BoxLayout.Y_AXIS));
		
		checkEnableSounds = new JCheckBox("Enable Sounds");
		panelMisc.add(checkEnableSounds);
		
		JPanel panelButtons = new JPanel();
		panelButtons.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelButtons.setBounds(-14, 263, 473, 50);
		frame.getContentPane().add(panelButtons);
		panelButtons.setLayout(null);
		
		btnClose = new JButton("Close");
		btnClose.setActionCommand("close");
		btnClose.setBounds(347, 11, 100, 25);
		panelButtons.add(btnClose);
		
		btnSave = new JButton("Save");
		btnSave.setActionCommand("save");
		btnSave.setBounds(237, 11, 100, 25);
		panelButtons.add(btnSave);
	}

	public JFrame getFrame() {
		return frame;
	}

	public JCheckBox getCheckUpperNotes() {
		return checkUpperNotes;
	}

	public JCheckBox getCheckLowerNotes() {
		return checkLowerNotes;
	}

	public JCheckBox getCheckNoteDesc() {
		return checkNoteDesc;
	}

	public JCheckBox getCheckEnableSounds() {
		return checkEnableSounds;
	}

	public JSpinner getSpinnerAmountNotes() {
		return spinnerAmountNotes;
	}

	public JButton getBtnClose() {
		return btnClose;
	}

	public JButton getBtnSave() {
		return btnSave;
	}
}
