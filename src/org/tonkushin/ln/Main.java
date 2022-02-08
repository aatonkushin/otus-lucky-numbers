package org.tonkushin.ln;

public class Main {

    public static void main(String[] args) {
        Lucky lucky = new Lucky();
        Tester tester = new Tester(lucky, "D:\\temp\\otus\\1.Tickets\\");
        tester.runTests();
    }
}
