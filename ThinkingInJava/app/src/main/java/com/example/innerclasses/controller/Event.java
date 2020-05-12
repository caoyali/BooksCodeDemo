package com.example.innerclasses.controller;

/**
 * 内部类与控制框架
 * 纸质书 208页
 * @author caoyali
 *
 */
public abstract class Event {
	protected long eventTime;
	protected final long dalayTime;
	public Event(long delayTime) {
		this.dalayTime = delayTime;
	}
	
	public void start() {
		eventTime = System.nanoTime() + dalayTime;// 纳秒级时间戳
	}
	
	public boolean ready() {
		return System.nanoTime() > eventTime;
	}
	
	public abstract void action();
}
