package com.example.innerclasses;

import com.example.innerclasses.controller.Event;

public class GreenHouseController {
	public static void main(String[] args) {
		GreenHouseControls gControls = new GreenHouseControls();
		gControls.addEvent(gControls.new Bell(900));
		
		Event[] eventListEvents = {
				gControls.new ThermostatNight(0),
				gControls.new LightOn(200),
				gControls.new LightOff(400),
				gControls.new WaterOn(600),
				gControls.new WaterOff(800),
				gControls.new ThermostatDay(1400)
		};
		gControls.addEvent(gControls.new Restar(2000, eventListEvents));
		if (args.length == 1) {
			gControls.addEvent(new GreenHouseControls.Terminate(new Integer(args[0])));
		}
		gControls.run();
	}
}
