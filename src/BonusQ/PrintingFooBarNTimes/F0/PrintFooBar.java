package BonusQ.PrintingFooBarNTimes.F0;

class PrintFooBar {

    private int n;
    private Object lock;
    private boolean bar;

    public void PrintFoo() {
        for (int i = 1; i <= n; i++) {
            System.out.print("Foo");
        }
    }

    public void PrintBar() {
        for (int i = 1; i <= n; i++) {
            System.out.print("Bar");
        }
    }
}