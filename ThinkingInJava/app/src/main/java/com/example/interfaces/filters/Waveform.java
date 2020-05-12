//: interfaces/classprocessor/Waveform.java
package com.example.interfaces.filters;
/**
 * page 249
 * @author caoyali
 *
 */
public class Waveform {
	private static long counter;
	private final long id = counter++;

	@Override
	public String toString() {
		return "Waveform " + "id:" + id;
	}
}
///~
