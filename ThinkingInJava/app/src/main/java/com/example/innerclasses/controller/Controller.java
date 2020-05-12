package com.example.innerclasses.controller;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 纸质书 208
 * @author caoyali
 *
 */

public class Controller {
	private java.util.List<Event> eventList = new ArrayList<>();
	public void addEvent(Event e) {
		eventList.add(e);
	}
	
	public void run() {
		while(eventList.size() > 0) {
			Iterator<Event> iterator = eventList.iterator();
			Event event;
			while (iterator.hasNext()) {
				event = iterator.next();
				System.out.print(event);
				event.action();
				iterator.remove();
			}
		}
	}
}
