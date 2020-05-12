package com.example.reusing;


public class SpaceShip extends SpaceShipControls{
	private String name;
	public SpaceShip(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return this.name;
	}
	public static void main(String[] args) {
		SpaceShip spaceShip = new SpaceShip("NESA Protector");
		spaceShip.forward(100);
	}
	
}
