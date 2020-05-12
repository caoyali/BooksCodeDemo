//:reusing/Detergent.java
package com.example.reusing;


import com.example.util.print.Print;

class Cleanser {
	private String s = "Cleanser";
	public void append(String a) {
		s += a;
	}
	
	public void dilute() {
		append(" dilute");
	}
	
	public void apply() {
		append(" apply"); 
	}
	
	public void scrub() {
		append(" scrub");
	}
	
	@Override
	public String toString() {
		return s;
	}
	
	public static void main(String[] args) {
		Cleanser x = new Cleanser();
		x.dilute();
		x.apply();
		x.scrub();
		Print.print(x);
	}
}
public class Detergent extends Cleanser{
	@Override
	public void scrub() {
		append(" Detergent.scrub()");
		super.scrub();
	}
	
	public void foam() {
		append(" foam");
	}
	
	public static void main(String[] args) {
		Detergent d = new Detergent();
		d.dilute();
		d.apply();
		d.scrub();
		d.foam();
		Print.print(d);
		Print.print("Testing base class:");
		Cleanser.main(args);
	}
}
///~
