package com.example.interfaces.classprocessor;
//: interfaces/classprocessor/Apply.java
import java.util.*;

import static com.example.util.print.Print.print;

/**
 * @author caoyali
 * @see page 248, Complete decouping!
 */
class Processor{
	public String name() {
		return getClass().getSimpleName();
	}
	Object process(Object input) {
		return input;
	}
}

class UpCase extends Processor {
	/**
	 * the return type covariation!
	 */
	@Override
	String process(Object input) {
		return input.toString().toUpperCase();
	}
}

class DownCase extends Processor{
	@Override
	String process(Object inpute) {
		return inpute.toString().toLowerCase();
	}
}

class Splitter extends Processor{
	@Override
	String process (Object inpute) {
		return Arrays.toString(((String)inpute).split(" "));
	}
}

public class Apply {
	public static void process(Processor p, Object s) {
		print("Using Processor " + p.name());
		print(p.process(s));
	}
	
	public static String s = "Disagreenment with beliefs is by definition incorrect";
	
	public static void main(String[] args) {
		process(new UpCase(), s);
		process(new DownCase(), s);
		process(new Splitter(), s);
	}
}
///~
