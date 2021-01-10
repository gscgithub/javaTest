package gsc.javaGrammarTest1;

class PClass {
	
	public void method() {
		System.out.println("PClass");
		method();
	}
}
class CClass extends PClass{
	
	public void method() {
		System.out.println("CClass");
//		super.method();
	}
}
public class MethodOverrideTest {
	public static void main(String[] args) {
		PClass cClass = new CClass();
		cClass.method();
	}
}
