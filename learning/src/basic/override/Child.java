package basic.override;

public class Child extends Parent{
    String s;
    static String ss;

    public static void m() {
        System.out.println("child void m()");
    }

    public static void main(String[] s) {

        //parent method get called
        m("string");
    }
}
