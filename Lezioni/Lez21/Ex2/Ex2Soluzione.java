class Ex2Soluzione {
    public static void main(String[] args) {
        /*
         * DOM1. Eliminare m2 in B non produce errori nelle classi A,B,C,
         * perche' in A,B,C non ci sono chiamate a m2 con tipo apparente B.
         * (Se invece nella definizione di A,B,C avessimo una chiamata b.m2(a);
         * con b di tipo B produrremmo un errore).
         */
        /*
         * DOM.2. Le prossime righe producono l’errore:
         * "B is abstract; cannot be instantiated" perche' cerchiamo di usare il
         * costruttore new B() della classe astratta B.
         */
        /*
         * Aobj2=newB();
         * obj2.m1();
         */
        /*
         * DOM.3 La classe C e' concreta e puo' produrre obj2 a cui si assegna tipo
         * apparente A. La classe A contiene m1. Durante l’esecuzione, obj3 ha tipo
         * esatto C, e m1 in C stampa "C.m1" e richiama m1 in B che stampa "B.m1".
         * Quindi le prossime righe stampano:
         * C.m1 B.m1
         */
        A obj3 = new C();
        obj3.m1();
        /*
         * DOM.4 obj3 ha tipo esatto C e C contiene m2. Ma obj3 ha tipo apparente A che
         * non contiene m2. Quindi inviare m2 a obj3 produce l'errore:
         * "cannot find symbol.
         * symbol: method m2(A) location: variable obj3 of type A"
         */

        /*
         * A obj4 = new C();
         * obj4.m2(obj4);
         */
    }
}

abstract class A {
    public abstract void m1();
}

abstract class B extends A {
    @Override
    public void m1() {
        System.out.println("B.m1");
    }

    public abstract void m2(A obj);
}

class C extends B {
    @Override
    public void m1() {
        System.out.println("C.m1");
        super.m1();
    }

    @Override
    public void m2(A obj) {
        System.out.println("C.m2");
        obj.m1();
    }
}

// end class Esercizio 2