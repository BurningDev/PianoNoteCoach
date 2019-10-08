package com.burngindev.pnc.core;

import javax.sound.midi.*;

import com.burningdev.pnc.controller.Callback;

import java.util.List;

public class MidiHandler {

	private Callback callback;
	
	public MidiHandler(Callback callback) {
		this.callback = callback;
		
		MidiDevice device;
		MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
		for (int i = 0; i < infos.length; i++) {
			try {
				device = MidiSystem.getMidiDevice(infos[i]);

				List<Transmitter> transmitters = device.getTransmitters();

				for (int j = 0; j < transmitters.size(); j++) {
					transmitters.get(j).setReceiver(
							new MidiInputReceiver());
				}
				
				Transmitter trans = device.getTransmitter();
				trans.setReceiver(new MidiInputReceiver());

				device.open();

			} catch (MidiUnavailableException e) {
				
			}
		}

	}

	public class MidiInputReceiver implements Receiver {

		public MidiInputReceiver() {

		}

		@Override
		public void send(MidiMessage msg, long timeStamp) {
			callback.callback(msg.getMessage()[1], msg.getMessage()[0], msg.getMessage()[2]);
		}

		@Override
		public void close() {
		}
	}
}