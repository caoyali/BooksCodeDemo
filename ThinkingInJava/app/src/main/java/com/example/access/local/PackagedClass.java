package access.local;

public class PackagedClass {
	private static PackagedClass mInstance = new PackagedClass();
	
	public PackagedClass() {
		System.out.println("Creating a packaged class!");
	}
	
	public static PackagedClass getInstance() {
		return mInstance;
	}
}
