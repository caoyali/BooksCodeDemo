//: interfaces/filters/LowPass.java
package com.example.interfaces.filters;
/**
 * page 249
 * @author caoyali
 *
 */
public class LowPass extends Filter{
	double cutoff;
	public LowPass(double cutoff) {
		this.cutoff = cutoff;
	}
	
	@Override
	public Waveform process(Waveform input) {
		return input;
	}
}
