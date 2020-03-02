package Basics.JavaMonitor12;

/*
we try to call notify() on an object in a synchronized block which is synchronized on a different object.
Running the code will again result in an IllegalMonitorStateException
* */
class BadSynchronization2 {

    public static void main(String args[]) {
        Object dummyObject = new Object();
        Object lock = new Object();

        synchronized (lock) {
            lock.notify();

            // Attempting to call notify() on the object
            // in synchronized block of another object
            dummyObject.notify();
        }
    }
}