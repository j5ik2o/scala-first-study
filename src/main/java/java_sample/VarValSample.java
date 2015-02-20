package java_sample;

public class VarValSample {

    public static void main(String[] args) {
        int a = 0;
        a = 1;
        // compile error
        // a == "String";
        final int b = 1;
        // compile error
        // b = 2;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
