package access.foreign;

import access.local.*;

public class Foreign {
	public static void main(String[] args) {
//		PackagedClass pc = new PackagedClass(); 编译失败
		PackagedClass pc = PackagedClass.getInstance();
	}
}
