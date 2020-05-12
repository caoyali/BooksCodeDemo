package com.example.innerclasses;

import com.example.util.print.Print;

/**
 * real book p 206
 * 主要展示回调的优越性
 * @author caoyali
 *
 */
interface Incrementable {
	void increment();
}

class Callee1 implements Incrementable{
	private int i = 0;
	@Override
	public void increment() {
		// TODO Auto-generated method stub
		i++;
		Print.print(i);
	}
}

class MyIncrement {
	public void increment() {
		Print.print("MyIncrement increment!");
	}
	
	static void executeFun(MyIncrement myIncrement) {
		myIncrement.increment();
	}
}

// 继承自一个很具体的类
class Calee2 extends MyIncrement {
	int i= 0;
	
	@Override
	public void increment() {
		i ++;
		Print.print("Calee2 i=" + i);
	}
	
	// 接下来写一个内部类
	private class Closure implements Incrementable {

		@Override
		public void increment() {
			Calee2.this.increment();
		}
	}
	
	Incrementable getIncrementable() {
		// 这个内部类本身就是私有的。外部类是无法访问的。但是，Calee2 是可以访问的。它提供一个包访问权限的
		// 入口。这样其他的类就可以通过这个对象进行调用了
		return new Closure();
	}
}

class Caller {
	private Incrementable incrementable;
	
	public Caller(Incrementable incrementable) {
		// TODO Auto-generated constructor stub
		this.incrementable = incrementable;
	}
	
	void go() {
		incrementable.increment();
	}
}
public class CallBacks {
	public static void main(String[] args) {
		Callee1 callee1 = new Callee1();
		Calee2 calee2 = new Calee2();
		MyIncrement.executeFun(calee2);
		Caller caller1 = new Caller(callee1);
		Caller caller2 = new Caller(calee2.getIncrementable());
		
		caller1.go();
		caller1.go();
		
		caller2.go();
		caller2.go();
	}
}

// 总结：妈的真烧脑。主要记住，利用private 加 接口。可以很好的控制客户程序员如何调用。回调更不用说。毕竟天天用
