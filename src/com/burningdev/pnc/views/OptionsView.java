/*
 * PianoNoteCoach by BurningDev
 */
package com.burningdev.pnc.views;

import java.awt.Toolkit;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;

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
	private JCheckBox checkSecondaryNotesGray;
	private JCheckBox checkSecondFourthLineGray;
	private JCheckBox checkBarline;
	
	private JSpinner spinnerAmountNotes;
	
	private JButton btnClose;
	private JButton btnSave;
	private JCheckBox checkDebugMidi;
	
	private JComboBox<String> comboBoxRange;
	
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
		frame.setBounds(100, 100, 450, 500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelNotes = new JPanel();
		panelNotes.setBorder(new TitledBorder(null, "Notes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelNotes.setBounds(10, 74, 424, 132);
		frame.getContentPane().add(panelNotes);
		panelNotes.setLayout(new BoxLayout(panelNotes, BoxLayout.Y_AXIS));
		
		checkUpperNotes = new JCheckBox("Show upper notes (Treble: F5 - C6, Bass: A3 - E4)");
		panelNotes.add(checkUpperNotes);
		
		checkLowerNotes = new JCheckBox("Show lower notes (Treble: A3 - E4, Bass: C2 - G2)");
		panelNotes.add(checkLowerNotes);
		
		checkNoteDesc = new JCheckBox("Display note description (e.g. G)");
		panelNotes.add(checkNoteDesc);
		
		JPanel panelAmountNotes = new JPanel();
		panelNotes.add(panelAmountNotes);
		panelAmountNotes.setLayout(null);
		
		spinnerAmountNotes = new JSpinner();
		spinnerAmountNotes.setToolTipText("");
		spinnerAmountNotes.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		spinnerAmountNotes.setBounds(4, 3, 41, 20);
		panelAmountNotes.add(spinnerAmountNotes);
		
		JLabel lblAmountOfNotes = new JLabel("Amount of notes");
		lblAmountOfNotes.setBounds(55, 6, 177, 14);
		panelAmountNotes.add(lblAmountOfNotes);
		
		JPanel panelMisc = new JPanel();
		panelMisc.setBorder(new TitledBorder(null, "Misc", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelMisc.setBounds(10, 217, 424, 84);
		frame.getContentPane().add(panelMisc);
		panelMisc.setLayout(new BoxLayout(panelMisc, BoxLayout.Y_AXIS));
		
		checkEnableSounds = new JCheckBox("Enable Sounds");
		panelMisc.add(checkEnableSounds);
		
		checkDebugMidi = new JCheckBox("Debug MIDI Interface");
		panelMisc.add(checkDebugMidi);
		
		JPanel panelButtons = new JPanel();
		panelButtons.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelButtons.setBounds(-13, 425, 473, 50);
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
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Design", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 312, 424, 102);
		frame.getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		checkSecondaryNotesGray = new JCheckBox("Secondary notes gray color");
		panel.add(checkSecondaryNotesGray);
		
		checkSecondFourthLineGray = new JCheckBox("Second and forth line gray color");
		panel.add(checkSecondFourthLineGray);
		
		checkBarline = new JCheckBox("Bar line");
		panel.add(checkBarline);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 424, 52);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Clef", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.add(panel_1);
		panel_1.setLayout(null);
		
		comboBoxRange = new JComboBox<>();
		// 0
		comboBoxRange.addItem("Treble");
		// 1
		comboBoxRange.addItem("Bassline");
		comboBoxRange.setBounds(10, 21, 140, 20);
		panel_1.add(comboBoxRange);
		
		JLabel lblNotesystemtreble = new JLabel("Note Range (Treble / Bassline)");
		lblNotesystemtreble.setBounds(160, 24, 248, 14);
		panel_1.add(lblNotesystemtreble);
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

	public JCheckBox getCheckSecondaryNotesGray() {
		return checkSecondaryNotesGray;
	}

	public JCheckBox getCheckSecondFourthLineGray() {
		return checkSecondFourthLineGray;
	}

	public JCheckBox getCheckDebugMidi() {
		return checkDebugMidi;
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

	public JCheckBox getCheckBarline() {
		return checkBarline;
	}

	public JComboBox<String> getComboBoxRange() {
		return comboBoxRange;
	}
}
