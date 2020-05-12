//: interfaces/filters/Filter.java
package com.example.interfaces.filters;
/**
 * page 249
 * @author caoyali
 *
 */
public class Filter {
	public String name() {
		return getClass().getSimpleName();
	}
	public Waveform process(Waveform waveform) {
		return waveform;
	}
}
///~
