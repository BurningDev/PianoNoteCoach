/*
 * PianoNoteCoach by BurningDev
 */
package com.burningdev.pnc.dialogs;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import org.pmw.tinylog.Logger;

/**
 * A information dialog, which contains a description, FAQ and the license from
 * this application. It also lists all used third-party libraries in a table.
 * 
 * @author BurningDev
 */
public class InfoDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();

	public InfoDialog() {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(InfoDialog.class.getResource("/com/burningdev/pnc/res/Icon.png")));
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			Logger.error(e, e.getMessage());
		}

		setTitle("Info");
		setBounds(100, 100, 450, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane.setBounds(10, 46, 414, 268);
		contentPanel.add(scrollPane);

		JTextPane textPane = new JTextPane();
		textPane.setBorder(null);
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);
		textPane.setContentType("text/html");
		textPane.setText("<html>\r\n" + "    <head>\r\n" + "        <style>\r\n" + "        table, th, td {\r\n"
				+ "  border: 1px solid black;\r\n" + "} \r\n" + "th, td {\r\n" + "  padding: 10px;\r\n"
				+ "  text-align: left;\r\n" + "}\r\n" + "        </style>\r\n" + "    </head>\r\n" + "<body>\r\n"
				+ "<div style=\"font: SegoeUI\">\r\n"
				+ "This application <b>helps you, to learn notes</b>. You need a midi keyboard, to work with this program. If you don't have a midi keyboard,\r\n"
				+ "you can use this software with the keyboard from your computer. A = C, S = D .. J = B, because there are only seven keys, there are no different keys for other octaves.\r\n"
				+ "This means G = G3, G4, G5 .., if you use a computer keyboard. When PianoNoteLearner is started, you click\r\n"
				+ "on the button <i>Start</i> and after that, notes will be displayed and you type the notes with your midi keyboard. The use of the application is free.\r\n"
				+ "<h2>FAQ</h2>\r\n" + "<b>Can I use this program for free?</b><br>\r\n"
				+ "Yes, you can use it for free.<br>\r\n" + "<b>How do I use my Midi keyboard?</b><br>\r\n"
				+ "Connect the MIDI keyboard via the cable via USB to the computer. Make sure that no other software accesses the interface.<br>\r\n"
				+ "<b>My MIDI-Keyboard doesen't work, what can I do?</b><br>\r\n"
				+ "You may have a problem with the midi keyboard, because other manufacturers send data over the interface, which we do not expect. In such a case, try \r\n"
				+ "another midi keyboard if you have one more, otherwise you can use the program with the computer keyboard as well.<br>\r\n"
				+ "<h2>Support us</h2>\r\n" + "If you like this program, you can support us.<br>\r\n"
				+ "1. Tell your friends about this application<br>\r\n"
				+ "2. Give the github respository of this project a star<br>\r\n"
				+ "3. Tell us, if you find a bug<br>\r\n" + "<h2>License</h2>\r\n" + "Copyright 2019 BurningDev\r\n"
				+ "<br><br>\r\n" + "Licensed under the Apache License, Version 2.0 (the \"License\");\r\n"
				+ "you may not use this file except in compliance with the License.\r\n"
				+ "You may obtain a copy of the License at\r\n" + "<br><br>\r\n"
				+ "    http://www.apache.org/licenses/LICENSE-2.0\r\n" + "<br><br>\r\n"
				+ "Unless required by applicable law or agreed to in writing, software\r\n"
				+ "distributed under the License is distributed on an \"AS IS\" BASIS,\r\n"
				+ "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\r\n"
				+ "See the License for the specific language governing permissions and\r\n"
				+ "limitations under the License.\r\n" + "<h2>Third-party libraries</h2>\r\n" + "<table>\r\n"
				+ "<tr><th>Library</th> <th>Website</th> <th>License</th></tr>\r\n"
				+ "<tr><td>JFugue</td> <td>http://www.jfugue.org/</td> <td>Apache License, version 2.0</td></tr>\r\n"
				+ "<tr><td>Tinylog</td> <td>https://tinylog.org/</td> <td>Apache License 2.0</td></tr>\r\n"
				+ "</table>\r\n" + "</div>\r\n" + "</body>\r\n" + "</html>");

		JLabel lblPianonotecoach = new JLabel("PianoNoteCoach");
		lblPianonotecoach.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblPianonotecoach.setBounds(10, 11, 414, 24);
		contentPanel.add(lblPianonotecoach);
		JButton okButton = new JButton("OK");
		okButton.setBounds(324, 325, 100, 25);
		contentPanel.add(okButton);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				InfoDialog.this.dispose();
			}
		});
		okButton.setActionCommand("OK");
		okButton.setPreferredSize(new Dimension(100, 25));
		okButton.setMinimumSize(new Dimension(100, 25));
		getRootPane().setDefaultButton(okButton);
	}
}
