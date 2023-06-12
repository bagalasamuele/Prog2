interface J {
    public void m1();

    public void m2(I obj);
}

interface I {
void m1 ();
}


class Class implements I,J{
    public void m1(){
        System.out.println("Class.m1");
    }
    public void m2(){ System.out.println("J.m2"); this.m1();}
    public void m2(I obj) { System.out.println("J.m3"); this.m2();}
}

class QuizEstensioni{

    public static void main(String [] args){
        I obj1 = new Class();
        obj1.m1();
    }
}