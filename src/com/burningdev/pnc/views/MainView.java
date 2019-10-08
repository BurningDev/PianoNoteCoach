/*
 * PianoNoteCoach by BurningDev
 */
package com.burningdev.pnc.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EtchedBorder;

import org.pmw.tinylog.Logger;

import java.awt.Font;
import java.awt.Toolkit;

/**
 * The MainView contains the sheet of music.
 * 
 * @author BurningDev
 *
 */
public class MainView {

	private JFrame frame;
	
	private JPanel sheetPanel;
	
	private JButton btnStart;
	private JButton btnOptions;
	private JButton btnInfo;
	private JButton btnExit;
	
	private JLabel lblStatus;
	
	public void open() {
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public MainView() {
		initialize();
	}

	private void initialize() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			Logger.error(e, e.getMessage());
		}
		
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/com/burningdev/pnc/res/Icon.png")));
		frame.setTitle("PianoNoteCoach");
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panelStatus = new JPanel();
		panelStatus.setBackground(Color.WHITE);
		FlowLayout flPanelStatus = (FlowLayout) panelStatus.getLayout();
		flPanelStatus.setAlignment(FlowLayout.RIGHT);
		frame.getContentPane().add(panelStatus, BorderLayout.NORTH);

		lblStatus = new JLabel("");
		lblStatus.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		panelStatus.add(lblStatus);

		JPanel panelButtons = new JPanel();
		panelButtons.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		frame.getContentPane().add(panelButtons, BorderLayout.SOUTH);

		btnStart = new JButton("Start");
		btnStart.setPreferredSize(new Dimension(100, 25));
		btnStart.setMinimumSize(new Dimension(100, 25));
		btnStart.setActionCommand("start");
		panelButtons.add(btnStart);

		btnOptions = new JButton("Options");
		btnOptions.setPreferredSize(new Dimension(100, 25));
		btnOptions.setMinimumSize(new Dimension(100, 25));
		btnOptions.setActionCommand("options");
		panelButtons.add(btnOptions);

		btnInfo = new JButton("Info");
		btnInfo.setPreferredSize(new Dimension(100, 25));
		btnInfo.setMinimumSize(new Dimension(100, 25));
		btnInfo.setActionCommand("info");
		panelButtons.add(btnInfo);

		btnExit = new JButton("Exit");
		btnExit.setPreferredSize(new Dimension(100, 25));
		btnExit.setMinimumSize(new Dimension(100, 25));
		btnExit.setActionCommand("exit");
		panelButtons.add(btnExit);

		sheetPanel = new SheetPanel();
		sheetPanel.setBackground(Color.WHITE);
		frame.getContentPane().add(sheetPanel, BorderLayout.CENTER);
	}
	
	public SheetPanel getSheetPanel() {
		return (SheetPanel) this.sheetPanel;
	}
	
	public JButton getBtnStart() {
		return this.btnStart;
	}
	
	public JButton getBtnOptions() {
		return this.btnOptions;
	}
	
	public JButton getBtnInfo() {
		return this.btnInfo;
	}
	
	public JButton getBtnExit() {
		return this.btnExit;
	}
	
	public JLabel getStatus() {
		return this.lblStatus;
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
}
