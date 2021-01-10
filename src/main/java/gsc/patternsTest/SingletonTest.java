package gsc.patternsTest;

public class SingletonTest {

	private static SingletonTest singleton = null;
	
	private SingletonTest () {
		System.out.println("construct execute");
	}
	public static SingletonTest getInstance() {
		if (singleton == null) {
			synchronized (SingletonTest.class) {
				if (singleton == null)
					singleton = new SingletonTest();
			}
		}
		return singleton;
	}
	
	public static void main(String[] args) {
		SingletonTest singleton = SingletonTest.getInstance();
		SingletonTest singleton2 = SingletonTest.getInstance();
		System.out.println(singleton == singleton2);
		System.out.println(Runtime.getRuntime().freeMemory() / (1024 * 1024));
		System.out.println(singleton.hashCode());
		System.out.println(singleton2.hashCode());
	}
}
