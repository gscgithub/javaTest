package gsc.common;

import org.junit.Test;

public enum MyEnum {
	enumA("A"),enumB("B"),enumC("C");
	enum AbstractMethodEnum {
		enum1{
			@Override
			public void print() {
				System.out.println("abstractMethodEnum enum1");
			}},
		enum2{
			@Override
			public void print() {
				System.out.println("abstractMethodEnum enum2");
			}
		};
		public abstract void print();
	}
	
	private String str;

	private String str2;

	MyEnum(String str) {
		this.str = str;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public void print() {
		System.out.println(str);
	}

}
