abstract class A {
    public abstract void m1();
}

abstract class B extends A {
    public void m1() {
        System.out.println("B.m1");
    }

    public abstract void m2(A obj);
}

class C extends B {
    public void m1() {
        System.out.println("C.m1");
        super.m1();
    }

    public void m2(A obj) {
        System.out.println("C.m2");
        obj.m1();
    }
}


// Rispondete alle seguenti domande:
// 1. Se si eliminasse il metodo m2 dalla classe B, il codice che definisce
// A,B,C sarebbe comunque corretto? Perché?
// 2. Il seguente codice è corretto? Se no, spiegare perché. Se sì, determinare
// cosa stampa.
// A obj2 = new B();
// obj2.m1();
// 3. Il seguente codice è corretto? Se no, spiegare perché. Se sì, determinare
// cosa stampa.
// A obj3 = new C();
// obj3.m1();
// 4. Il seguente codice è corretto? Se no, spiegare perché. Se sì, determinare
// cosa stampa.
// A obj4 = new C(); obj4.m2(obj4);