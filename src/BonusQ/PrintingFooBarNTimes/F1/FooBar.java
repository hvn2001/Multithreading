package BonusQ.PrintingFooBarNTimes.F1;

class FooBar {
    private int n;
    private Object lock;
    private boolean bar;

    public FooBar(int n) {
        this.n = n;
        this.lock = new Object();
        this.bar = false;
    }

    public void foo() {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                if (bar) {
                    try {
                        lock.wait();
                    } catch (Exception e) {

                    }
                }
                System.out.print("Foo");
                bar = true;
                lock.notify();
            }
        }
    }

    public void bar() {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                if (bar != true) {
                    try {
                        lock.wait();
                    } catch (Exception e) {

                    }
                }
                bar = false;
                System.out.println("Bar");
                lock.notify();
            }
        }
    }
}