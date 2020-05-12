package com.example.innerclasses;

import com.example.innerclasses.controller.Controller;
import com.example.innerclasses.controller.Event;

public class GreenHouseControls extends Controller {
	private boolean light = false;
	
	public class LightOn extends Event {

		public LightOn(long delayTime) {
			super(delayTime);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void action() {
			light = true;
		}
		
		@Override
		public String toString() {
			return "light is on";
		}
		
	}
	
	public class LightOff extends Event {
		
		public LightOff(long delayTime) {
			super(delayTime);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void action() {
			light = false;
		}
		
		@Override
		public String toString() {
			return "light is off";
		}
	}
	
	private boolean water = false;
	
	public class WaterOn extends Event{
		

		public WaterOn(long delayTime) {
			super(delayTime);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void action() {
			// TODO Auto-generated method stub
			water = true;
		}
		
		@Override
		public String toString() {
			return "water is on";
		}
	}
	
	public class WaterOff extends Event{
		

		public WaterOff(long delayTime) {
			super(delayTime);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void action() {
			// TODO Auto-generated method stub
			water = false;
		}
		
		@Override
		public String toString() {
			return "water is off";
		}
	}
	
	private String thermostat = "Day";
	public class ThermostatNight extends Event{

		public ThermostatNight(long delayTime) {
			super(delayTime);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void action() {
			// TODO Auto-generated method stub
			thermostat = "Night";
		}
		
		@Override
		public String toString() {
			return "Night";
		}
		
	}
	
	public class ThermostatDay extends Event{

		public ThermostatDay(long delayTime) {
			super(delayTime);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void action() {
			// TODO Auto-generated method stub
			thermostat = "Day";
		}
		
		@Override
		public String toString() {
			return "Day";
		}
	}
	
	public class Bell extends Event{

		public Bell(long delayTime) {
			super(delayTime);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void action() {
			// TODO Auto-generated method stub
			addEvent(new Bell(this.dalayTime));
		}
		
		@Override
		public String toString() {
			return "Bing";
		}
	}
	
	public class Restar extends Event {
		private Event[] eventList;
		public Restar(long delayTime, Event[] events) {
			super(delayTime);
			// TODO Auto-generated constructor stub
			this.eventList = events;
			
			for (Event e : eventList) {
				addEvent(e);
			}
		}

		@Override
		public void action() {
			// TODO Auto-generated method stub
			for (Event event : eventList) {
				event.start();
				addEvent(event);
			}
		}
		
		@Override
		public String toString() {
			return "Restar";
		}
		
	}
	
	public static class Terminate extends Event {

		public Terminate(long delayTime) {
			super(delayTime);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void action() {
			// TODO Auto-generated method stub
			System.exit(0);
		}
		@Override
		public String toString() {
			return "return terminating";
		}
		
		
	}
}
