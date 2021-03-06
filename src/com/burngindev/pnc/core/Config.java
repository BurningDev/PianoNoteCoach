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
	private boolean barLine = false;
	
	private int range = 0;
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
				this.barLine = Boolean.valueOf(String.valueOf(this.properties.get("barLine")));
				
				this.amountNotes = Integer.valueOf(String.valueOf(this.properties.get("amountNotes")));
				this.range = Integer.valueOf(String.valueOf(this.properties.get("range")));
			}
		} catch (IOException e) {
			Logger.error(e, e.getMessage());
		}
	}
	
	/**
	 * Saves the settings into the configuration file.
	 */
	public void save() throws IOException {
		this.properties.put("showUpperNotes", String.valueOf(showUpperNotes));
		this.properties.put("showLowerNotes", String.valueOf(showLowerNotes));
		this.properties.put("showLabels", String.valueOf(showLabels));
		this.properties.put("playSounds", String.valueOf(playSounds));
		this.properties.put("secondaryNotesGray", String.valueOf(secondaryNotesGray));
		this.properties.put("secondFourthLineGray", String.valueOf(secondFourthLineGray));
		this.properties.put("debugMidiInterface", String.valueOf(debugMidiInterface));
		this.properties.put("barLine", String.valueOf(barLine));
		
		this.properties.put("amountNotes", String.valueOf(amountNotes));
		this.properties.put("range", String.valueOf(range));
		
		this.properties.store(new FileWriter(this.configFile), "ConfigFile of PianoNoteCoach");
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

	public boolean isBarLine() {
		return barLine;
	}

	public void setBarLine(boolean barLine) {
		this.barLine = barLine;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}
}