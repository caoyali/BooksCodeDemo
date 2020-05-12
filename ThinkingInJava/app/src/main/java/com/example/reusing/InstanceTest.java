package com.example.reusing;
import static com.example.util.print.Print.print;
class Base{
	Base() {
		print("Base constructor!");
	}
}

class Sub extends Base{
	Sub() {
		print("sub constructor!");
	}
}
public class InstanceTest {
	//说明这个是走在main方法调用之前的！
	private static InstanceTest INS = new InstanceTest();
	private Sub SUB_INS = new Sub();
	
	private InstanceTest() {
		print("InstanceTest constructor!");
	}
	
	public static void main(String[] arg) {
		print("main function first line logic!");
		if (null == INS) {
			return;
		} else {
			print("INS have been inilazaed!");
		}
		
//		if (null == SUB_INS) {
//			return;
//		} else {
//			print("SUB have been inilazaed!");
//		}
	}

}
