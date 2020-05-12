package com.example.reusing;


import com.example.util.print.Print;

class Art {
	Art() {
		Print.print("Art constructor");
	}
}

class Drawing extends Art {
	Drawing() {
		Print.print("Drawing constructor");
	}
}

public class Cartoon extends Drawing {
	Cartoon() {
		Print.print("Cartton constructor");
	}
	public static void main(String[] args) {
		Cartoon x = new Cartoon();
	}
}
 