public class B {
    public static void m1(boolean x) {
        if (x) throw new RuntimeException("m1");
        System.out.println("T");
    }

    public static boolean m2() {
        try {
            System.out.println("provo m1");
            m1(true);
        } catch (Exception e) {
            System.out.println("m1 Exc");
            return true;
        }
        
        finally{
            System.out.println("Anche se ho un return prima, vengo eseguito lo stesso");
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(m2());

    }

}