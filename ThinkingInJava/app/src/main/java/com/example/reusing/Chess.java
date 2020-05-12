package com.example.reusing;

import com.example.util.print.Print;

class Game {
	Game(int i) {
		Print.print("Game");
	}
}

class BoardGame extends Game{
//	这句编译不通过是因为，父类没有这个无参的构造方法定义。
//	如果一个类里面用户亲手写了构造方法，那么就意味着你抛弃默认的构造方法了！！注意，是抛弃！！没这个方法了
//	子类构造器必须首先调用父类的构造器，但是可以任意调用随便一个构造器。这个是可以的。只要调用就行！而且只是调用一次欧！！！！！
	BoardGame() {
		super(0);
		Print.print("Game without parame");
	}
	
	BoardGame(int i) {
		super(i);//父类构造器必须第一行就被调用。否则报错！
		Print.print("Game 1 para");
	}
	
	BoardGame(int i, String s) {
		super(i);
		Print.print("Game 2 para");
	}
}
public class Chess extends BoardGame{

	Chess(int i) {
		super(i, "");
		Print.print("Chess");
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		Chess chess = new Chess(4);
	}
	
}
