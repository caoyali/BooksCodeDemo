package com.example.innerclasses;

import com.example.util.print.Print;

/**
 * page  276 Factory Method revisited
 * @author caoyali
 *
 */
interface Service {
	void method1(); //the function default is public!
	void method2();
}

interface ServiceFactory{
	Service getService();
}

class Implementation1 implements Service {
	// outer class can not access!
	private Implementation1() {}

	@Override
	public void method1() {
		Print.print("Implementation1 method1");
	}

	@Override
	public void method2() {
		Print.print("Implementation1 method2");
	}
	
	public static ServiceFactory factroy = new ServiceFactory() {
		
		@Override
		public Service getService() {
			// TODO Auto-generated method stub
			return new Implementation1();
		}
	};
}


class Implementation2 implements Service {
	// outer class can not access!
	private Implementation2() {}

	@Override
	public void method1() {
		Print.print("Implementation2 method1");
	}
	@Override
	public void method2() {
		Print.print("Implementation2 method2");
	}
	
	public static ServiceFactory factroy = new ServiceFactory() {
		
		@Override
		public Service getService() {
			// TODO Auto-generated method stub
			return new Implementation2();
		}
	};
}

public class Factrories {
	public static void main(String[] args) {
		serviceConsumer(Implementation1.factroy);
		serviceConsumer(Implementation2.factroy);
		
		
		
	}
	
	public static void serviceConsumer(ServiceFactory factory) {
		Service service = factory.getService();
		service.method1();
		service.method2();
	}
}
