package BonusQ.PrintingFooBarNTimes.F1;

class FooBarThread extends Thread {

    FooBar fooBar;
    String method;

    public FooBarThread(FooBar fooBar, String method) {
        this.fooBar = fooBar;
        this.method = method;
    }

    public void run() {
        if ("foo".equals(method)) {
            fooBar.foo();
        } else if ("bar".equals(method)) {
            fooBar.bar();
        }
    }
}