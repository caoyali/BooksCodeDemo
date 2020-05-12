package com.example.reusing;


import com.example.util.print.Print;

class Plate {
	//如果构造方法都采用private修饰的话，就意味着这家伙不可以继承。我说的是都设置为private的情况
	Plate(int i) {
		Print.print("Plate cons, i=" + i);
	}
	
	void a() {}
}

class DinnerPlate extends Plate{
	public DinnerPlate(int i) {
		super(i);
		Print.print("DinnerPlate cons i=" + i);
	}
	//???难道继承也有范围的讲究？好像子类可以放大访问权限！但是private除外，因为这个已经被死死的限制住了
	protected void a() {
		
	}
}

class Utensil {
	Utensil (int i) {
		Print.print("Utensil cons i=" + i);
	}
}

class Spoon extends Utensil{
	public Spoon(int i) {
		super(i);
		Print.print("Spoon cons i=" + i);
	}
} 

class Fork extends Utensil {
	Fork(int i) {
		super(i);
		Print.print("Fork cons i=" + i);
	}
}

class Knife extends Utensil {
	Knife(int i) {
		super(i);
		Print.print("Knife cons i=" + i);
	}
}

class Custom {
	Custom (int i) {
		Print.print("Custem cons i=" + i);
	}
}
public class PlaceSetting extends Custom{
	private Spoon spoon;
	private Fork fork;
	private Knife knife;
	private DinnerPlate dinnerPlate;
	
	public PlaceSetting(int i) {
		super(i);
		spoon = new Spoon(i++);
		fork = new Fork(i++);
		knife = new Knife(i++);
		dinnerPlate = new DinnerPlate(i++);
		Print.print("PlaceSetting cons i=" + i);
	}
	
	public static void main(String[] str) {
		PlaceSetting placeSetting = new PlaceSetting(9);
	}
}
