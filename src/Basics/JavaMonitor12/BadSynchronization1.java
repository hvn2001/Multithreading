// Java's Monitor & Hoare vs Mesa Monitors
package Basics.JavaMonitor12;

/*
wait() is being called outside of a synchronized block,
i.e. without implicitly locking the associated mutex.
Running the code results in IllegalMonitorStateException
* */
class BadSynchronization1 {

    public static void main(String args[]) throws InterruptedException {
        Object dummyObject = new Object();

        // Attempting to call wait() on the object
        // outside of a synchronized block.
        dummyObject.wait();
    }
}