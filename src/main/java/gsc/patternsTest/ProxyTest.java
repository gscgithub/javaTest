package gsc.patternsTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

	public static void main(String[] args) {
		
		InvocationHandler ih = new AgentIntermediary(new Vendor());
		
		Sell sell = (Sell) Proxy.newProxyInstance(Sell.class.getClassLoader(), 
				new Class[] {Sell.class}, ih);
		sell.sell();
	}
}
interface Sell {
	public void sell();
}

class Vendor implements Sell {

	@Override
	public void sell() {
		System.out.println("vendor invoke");
		
	}
	
}

class AgentIntermediary implements InvocationHandler {

	private Sell sell;
	
	public AgentIntermediary (Sell sell) {
		this.sell = sell;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("invoke before");
		Object o = method.invoke(sell, args);
		System.out.println("invoke after");
		return o;

	}
	
}
















