Interface I {
	public void m1();
	public void m3();
}

class A implements I {
	public void m1(){
	System.out.println("A.m1");
	m2(this);
	}

	public void m2(I obj) {
		System.out.println("A.m2");
		obj.m3();
	}

	public void m3(){
		System.out.println("A.m3");
	}
}

class B extends A {
	public void m2(I obj) {
	System.out.println("B.m2");
	super.m2(obj);
	}

	public void m3(){
	System.out.prinln("B.m3");
	}
} 

class Binding1_3 {
	public static void main(String[] args){
		B obj = new B();
		obj.m2(obj);
	}
}