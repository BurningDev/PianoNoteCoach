package com.burningdev.pnc.dialogs;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EtchedBorder;

import org.pmw.tinylog.Logger;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomeDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public WelcomeDialog() {
		setResizable(false);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			Logger.error(e, e.getMessage());
		}
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(WelcomeDialog.class.getResource("/com/burningdev/pnc/res/Icon.png")));
		setTitle("Welcome");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(-13, -13, 460, 81);
			getContentPane().add(panel);
			panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			panel.setBackground(Color.WHITE);
			panel.setLayout(null);
			{
				JLabel lblItLooksLike = new JLabel("It looks like you're using PianoNoteCoach for the first time.");
				lblItLooksLike.setBounds(22, 56, 414, 14);
				panel.add(lblItLooksLike);
			}
			{
				JLabel lblNewLabel = new JLabel("Welcome!");
				lblNewLabel.setBounds(22, 23, 123, 22);
				panel.add(lblNewLabel);
				lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(-13, 224, 460, 48);
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			getContentPane().add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton closeButton = new JButton("Close");
				closeButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				closeButton.setBounds(336, 11, 100, 25);
				buttonPane.add(closeButton);
				getRootPane().setDefaultButton(closeButton);
			}
		}
		
		JTextPane txtpnThisApplicationHelps = new JTextPane();
		txtpnThisApplicationHelps.setEditable(false);
		txtpnThisApplicationHelps.setText("This application helps you, to learn music notes. \r\n\r\nLook at the options. There you will find useful settings. For further information, open the info dialog.");
		txtpnThisApplicationHelps.setBackground(UIManager.getColor("Button.background"));
		txtpnThisApplicationHelps.setBounds(10, 79, 371, 127);
		getContentPane().add(txtpnThisApplicationHelps);
	}
}
