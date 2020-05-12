package com.example.reusing;


import static com.example.util.print.Print.print;

class Characteristic {
	private String s;
	Characteristic (String s) {
		this.s = s;
		print("Creating characterisctic " + s);
	}
	
	protected void dispose() {
		print("disposing characterisctic " + s);
	}
}

class Description {
	private String s;
	Description(String s) {
		this.s = s;
		print("Creating discription " + s);
	}
	
	protected void dispose() {
		print("disposing Description " + s);
	}
}

class LivingCreature {
	private Characteristic p = new Characteristic("is alive");
	private Description t = new Description("Basic living Creature");
	
	LivingCreature() {
		print("LivingCreature()...");
	}
	
	protected void dispose() {
		print("LivingCreature dispose");
		t.dispose();
		p.dispose();
	}
}

class Animal extends LivingCreature {
	private Characteristic p = new Characteristic("has heart");
	private Description t = new Description("Aninal not Vegetable");
	Animal(){
		print("Animal()");
	}
	@Override
	protected void dispose() {
		print("Animal dispose");
		t.dispose();
		p.dispose();
	}
}

class Amphibian extends Animal{
	private Characteristic p = new Characteristic("can live in water");
	private Description t = new Description("Both water and land");
	@Override
	protected void dispose() {
		print("Animal dispose");
		t.dispose();
		p.dispose();
	}
	
	Amphibian(){
		print("Amphibian()");
	}
}

public class Forg extends Amphibian{
	private Characteristic p = new Characteristic("Croaks");
	private Description t = new Description("Eats Bugs");
	
	public Forg() {
		print("Forg()");
	}

	@Override
	protected void dispose() {
		print("Forg dispose");
		t.dispose();
		p.dispose();
		super.dispose();
	}
	
	public static void main(String[] srgs) {
		Forg forg = new Forg();
		print("Bye!");
		forg.dispose();
	} 
}
