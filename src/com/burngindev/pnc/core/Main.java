/*
 * PianoNoteCoach by BurningDev
 */
package com.burngindev.pnc.core;

import org.pmw.tinylog.Configurator;

import com.burningdev.pnc.controller.MainController;

public class Main {
	/**
	 * Entry point of the application
	 */
	public static void main(String[] args) {
		Configurator.defaultConfig().formatPattern("{date:yyyy-MM-dd HH:mm:ss} [{level}]: {message}").activate();
		
		MainController mainController = new MainController();
		mainController.open();
	}
}
