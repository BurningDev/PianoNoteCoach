/*
 * PianoNoteCoach by BurningDev
 */
package com.burngindev.pnc.core;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.pmw.tinylog.Logger;

public class Config {
	private Properties properties;

	private File configFile;
	
	private boolean showUpperNotes = false;
	private boolean showLowerNotes = false;
	private boolean showLabels = true;
	private boolean playSounds = true;
	private boolean secondaryNotesGray = false;
	private boolean secondFourthLineGray = false;
	private boolean debugMidiInterface = false;
	private int amountNotes = 20;
	
	/**
	 * Constructor
	 * 
	 * @param configFile is the File of the configuration
	 */
	public Config(final File configFile) {
		this.properties = new Properties();
		this.configFile = configFile;
		
		try {
			if (!configFile.exists()) {
				configFile.createNewFile();
				
				save();
			} else {
				this.properties.load(new FileReader(configFile));
				
				this.showUpperNotes = Boolean.valueOf(String.valueOf(this.properties.get("showUpperNotes")));
				this.showLowerNotes = Boolean.valueOf(String.valueOf(this.properties.get("showLowerNotes")));
				this.showLabels = Boolean.valueOf(String.valueOf(this.properties.get("showLabels")));
				this.playSounds = Boolean.valueOf(String.valueOf(this.properties.get("playSounds")));
				this.secondaryNotesGray = Boolean.valueOf(String.valueOf(this.properties.get("secondaryNotesGray")));
				this.secondFourthLineGray = Boolean.valueOf(String.valueOf(this.properties.get("secondFourthLineGray")));
				this.debugMidiInterface = Boolean.valueOf(String.valueOf(this.properties.get("debugMidiInterface")));
				this.amountNotes = Integer.valueOf(String.valueOf(this.properties.get("amountNotes")));
			}
		} catch (IOException e) {
			Logger.error(e, e.getMessage());
		}
	}
	
	/**
	 * Saves the settings into the configuration file.
	 */
	public void save() {
		this.properties.put("showUpperNotes", String.valueOf(showUpperNotes));
		this.properties.put("showLowerNotes", String.valueOf(showLowerNotes));
		this.properties.put("showLabels", String.valueOf(showLabels));
		this.properties.put("playSounds", String.valueOf(playSounds));
		this.properties.put("amountNotes", String.valueOf(amountNotes));
		this.properties.put("secondaryNotesGray", String.valueOf(secondaryNotesGray));
		this.properties.put("secondFourthLineGray", String.valueOf(secondFourthLineGray));
		this.properties.put("debugMidiInterface", String.valueOf(debugMidiInterface));
		
		try {
			this.properties.store(new FileWriter(this.configFile), "ConfigFile of PianoNoteCoach");
		} catch (IOException e) {
			Logger.error(e, e.getMessage());
		}
	}

	public Properties getProperties() {
		return properties;
	}

	public boolean isShowUpperNotes() {
		return showUpperNotes;
	}

	public boolean isShowLowerNotes() {
		return showLowerNotes;
	}

	public boolean isShowLabels() {
		return showLabels;
	}

	public boolean isPlaySounds() {
		return playSounds;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public void setShowUpperNotes(boolean showUpperNotes) {
		this.showUpperNotes = showUpperNotes;
	}

	public void setShowLowerNotes(boolean showLowerNotes) {
		this.showLowerNotes = showLowerNotes;
	}

	public void setShowLabels(boolean showLabels) {
		this.showLabels = showLabels;
	}

	public void setPlaySounds(boolean playSounds) {
		this.playSounds = playSounds;
	}

	public int getAmountNotes() {
		return amountNotes;
	}

	public void setAmountNotes(int amountNotes) {
		this.amountNotes = amountNotes;
	}

	public boolean isSecondaryNotesGray() {
		return secondaryNotesGray;
	}

	public void setSecondaryNotesGray(boolean secondaryNotesGray) {
		this.secondaryNotesGray = secondaryNotesGray;
	}

	public boolean isSecondFourthLineGray() {
		return secondFourthLineGray;
	}

	public void setSecondFourthLineGray(boolean secondFourthLineGray) {
		this.secondFourthLineGray = secondFourthLineGray;
	}

	public boolean isDebugMidiInterface() {
		return debugMidiInterface;
	}

	public void setDebugMidiInterface(boolean debugMidiInterface) {
		this.debugMidiInterface = debugMidiInterface;
	}
}