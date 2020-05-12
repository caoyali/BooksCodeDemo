//: SpaceShipDelegation.java
package com.example.reusing;
/**
 * 一种介于组合和继承之间的关系。
 * @author caoyali
 *
 */
public class SpaceShipDelegation {
	private String name;
	private SpaceShipControls controls = new SpaceShipControls();
	public SpaceShipDelegation(String name) {
		this.name = name;
	}
	//public 可以暴露给包外
	public void up(int velocity) {
		controls.up(velocity);
	}
	public void down(int velocity) {
		controls.down(velocity);
	}
	public void left(int velocity) {
		controls.left(velocity);
	}
	public void right(int velocity) {
		controls.right(velocity);
	}
	public void forward(int velocity) {
		controls.forward(velocity);
	}
	public void back(int velocity) {
		controls.back(velocity);
	}
	public void turboBoost() {
		controls.turboBoost();
	}
}
///~
